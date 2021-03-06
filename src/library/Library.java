package library;

import java.io.PrintStream;
import java.util.*;


public class Library {
    // A Library is a Collection of Items
    private final Collection<Item> NYPL = new HashSet<Item>();
    //protected Map<String, List<Item>> keyMap = new HashMap<String, List<Item>>();


    // general methods

    // Sort a List, based on Title
    // I suspect I could just add items to an already sorted list... or not, since that was the whole purpose behind
    // the Comparator: "sorting" doesn't mean anything without a basis for sorting; in this case, title
    private Collection<Item> listSort(List listToSort) {
        Collections.sort(listToSort, new Comparator<Item>() {
            public int compare(Item o1, Item o2) {
                String S1 = o1.getTitle();
                String S2 = o2.getTitle();
                return S1.compareTo(S2);
            }
        });
        //noinspection unchecked,unchecked
        return listToSort;
    }

    // returns all of the items which have the specified keyword
    // In theory, the keyword -> Item relation should be a hashmap. But in order to do that, we'd have to create
    // multiple hashes for each item, which isn't trivial. Consequently, it seems we're going to have to do a linear
    // search of everything in the Collection to match keywords.
    public Collection<Item> itemsForKeyword(String keyword) {
        List<Item> itemList = Item.keyMap.get(keyword);
        if (itemList != null)
            listSort(itemList);

        /*List<Item> keyList = new ArrayList<Item>();
        for (Item keyMatch : NYPL) {
            if (keyMatch.keyCheck(keyword)) {
                keyList.add(keyMatch);
            }
        }
        // Testing for KeyHash
        System.out.println(Item.keyMap.get(keyword));*/
        return itemList;
    }

    // print an item from this library to the output stream provided
    public void printItem(PrintStream out, Item item) {
        item.displayInfo(out);
    }

    // book-related methods

    // adds a book to the library
    public Item addBook(String title, String author, int nPages, String... keywords) {
        Book newBook = new Book();

        // This could potentially be more elegant as a single method...
        // On second thought, I'd still have two parts: a set title/pages/author section
        // And a add keywords section. It'd work, but meh...
        newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setPageCount(nPages);
        newBook.addKeyword(keywords);
        NYPL.add(newBook);

        return newBook;
    }

    // removes a book from the library
    public boolean removeBook(String title) {
        Boolean successFlag = false;
        Book toBeDeleted = null;
        for (Item bookMatch : NYPL) {
            if (bookMatch.getTitle().equals(title) && (bookMatch instanceof Book)) {
                toBeDeleted = (Book) bookMatch;
                String[] someArray = new String[bookMatch.keywords.size()];
                bookMatch.removeKeyword(bookMatch.keywords.toArray(someArray));
            }
            successFlag = true;
        }
        if (successFlag)
            NYPL.remove(toBeDeleted);
        return successFlag;
    }

    // returns all of the books by the specified author
    public Collection<Item> booksByAuthor(String author) {
        List<Item> authorList = new ArrayList<Item>();
        for (Item bookList : NYPL) {
            if (bookList instanceof Book && (((Book) bookList).getAuthor().equals(author))) {
                authorList.add(bookList);
            }
        }

        return listSort(authorList);
    }

    // returns all of the books in the library
    public Collection<Item> books() {
        List<Item> bookList = new ArrayList<Item>();
        for (Item isAbook : NYPL) {
            if (isAbook instanceof Book) {
                bookList.add(isAbook);
            }
        }

        return listSort(bookList);
    }

    // music-related methods

    // adds a music album to the library
    public Item addMusicAlbum(String title, String band, int nSongs, String... keywords) {
        MusicAlbum newAlbum = new MusicAlbum();

        // This could potentially be more elegant as a single method...
        // On second thought, I'd still have two parts: a set title/pages/author section
        // And a add keywords section. It'd work, but meh...
        newAlbum.setTitle(title);
        newAlbum.setBandName(band);
        newAlbum.setSongCount(nSongs);
        newAlbum.addKeyword(keywords);
        NYPL.add(newAlbum);

        return newAlbum;
    }

    // adds the specified band members to a music album
    public void addBandMembers(Item album, String... members) {
        // Maybe not necessary? Checks to see if the library contains the item, and if the item of of the type
        // needed to call addBandMembers
        if (NYPL.contains(album) && (album instanceof MusicAlbum)) {
            ((MusicAlbum) album).addBandMembers(members);
        }
    }

    // removes a music album from the library
    public boolean removeMusicAlbum(String title) {
        Boolean successFlag = false;
        MusicAlbum toBeDeleted = null;
        for (Item musicMatch : NYPL) {
            if (musicMatch.getTitle().equals(title) && (musicMatch instanceof MusicAlbum)) {
                toBeDeleted = (MusicAlbum) musicMatch;
                String[] someArray = new String[musicMatch.keywords.size()];
                musicMatch.removeKeyword(musicMatch.keywords.toArray(someArray));
            }
            successFlag = true;
        }
        if (successFlag)
            NYPL.remove(toBeDeleted);
        /*if (Item.keyMap.containsValue(toBeDeleted)) {
            Item.keyMap.remove(toBeDeleted);
        }*/
        return successFlag;
    }

    // returns all of the music albums by the specified band
    public Collection<Item> musicByBand(String band) {
        List<Item> bandList = new ArrayList<Item>();
        for (Item bands : NYPL) {
            if (bands instanceof MusicAlbum && (((MusicAlbum) bands).getBand().equals(band))) {
                bandList.add(bands);
            }
        }

        return listSort(bandList);
    }

    // returns all of the music albums by the specified musician
    public Collection<Item> musicByMusician(String musician) {
        List<Item> museList = new ArrayList<Item>();
        for (Item musicMan : NYPL) {
            if (musicMan instanceof MusicAlbum && ((MusicAlbum) musicMan).museCheck(musician)) {
                museList.add(musicMan);
            }
        }
        return listSort(museList);
    }

    // returns all of the music albums in the library, sorted by title
    public Collection<Item> musicAlbums() {
        // Create a Collection of musicAlbums in the NYPL
        List<Item> musicList = new ArrayList<Item>();
        for (Item isAmusic : NYPL) {
            if (isAmusic instanceof MusicAlbum) {
                musicList.add(isAmusic);
            }
        }

        return listSort(musicList);
    }

    // movie-related methods

    // adds a movie to the library
    public Item addMovie(String title, String director, int nScenes, String... keywords) {
        Movie newMovie = new Movie();

        // This could potentially be more elegant as a single method...
        // On second thought, I'd still have two parts: a set title/pages/author section
        // And a add keywords section. It'd work, but meh...
        newMovie.setTitle(title);
        newMovie.setDirector(director);
        newMovie.setSceneCount(nScenes);
        newMovie.addKeyword(keywords);
        NYPL.add(newMovie);

        return newMovie;
    }

    // adds the specified actors to a movie
    public void addCast(Item movie, String... members) {
        if (NYPL.contains(movie) && (movie instanceof Movie)) {
            ((Movie) movie).addCastMembers(members);
        }
    }

    // removes a movie from the library
    public boolean removeMovie(String title) {
        Boolean successFlag = false;
        Movie toBeDeleted = null;
        for (Item movieMatch : NYPL) {
            if (movieMatch.getTitle().equals(title) && (movieMatch instanceof Movie)) {
                toBeDeleted = (Movie) movieMatch;
                String[] someArray = new String[movieMatch.keywords.size()];
                movieMatch.removeKeyword(movieMatch.keywords.toArray(someArray));
            }

            successFlag = true;
        }
        if (successFlag)
            NYPL.remove(toBeDeleted);
        /*if (Item.keyMap.containsValue(toBeDeleted)) {
            Item.keyMap.remove(toBeDeleted);
        }*/
        return successFlag;
    }

    // returns all of the movies by the specified director
    public Collection<Item> moviesByDirector(String director) {
        List<Item> directorList = new ArrayList<Item>();
        for (Item film : NYPL) {
            if (film instanceof Movie && (((Movie) film).getDirector().equals(director))) {
                directorList.add(film);
            }
        }

        return listSort(directorList);
    }

    // returns all of the movies by the specified actor
    public Collection<Item> moviesByActor(String actor) {
        List<Item> castList = new ArrayList<Item>();
        for (Item film : NYPL) {
            if (film instanceof Movie && ((Movie) film).hasActor(actor)) {
                castList.add(film);
            }
        }
        return listSort(castList);
    }

    // returns all of the movies in the library
    public Collection<Item> movies() {
        List<Item> movieList = new ArrayList<Item>();
        for (Item isAMovie : NYPL) {
            if (isAMovie instanceof Movie) {
                movieList.add(isAMovie);
            }
        }
        return listSort(movieList);
    }


}
