package library;

import java.io.PrintStream;
import java.util.*;

public class Library
{
	// general methods
    // I debated whether there should be a single Collection containing all the items in the library, or separate
    // Collections for each section. I decided on separates on the basis that if J. Smith made both a movie and a book
    // with the same title, you would need to differentiate them. Hmm... actually nevermind.
    Collection<Item> NYPL = new HashSet<Item>();

	// returns all of the items which have the specified keyword
	public Collection<Item> itemsForKeyword(String keyword)
	{
		return null;
	}
	
	// print an item from this library to the output stream provided
	public void printItem(PrintStream out, Item item)
	{
        item.displayInfo(out);
	}
	
	// book-related methods
	
	// adds a book to the library
	public Item addBook(String title, String author, int nPages, String... keywords)
	{
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
	public boolean removeBook(String title)
	{
		return false;
	}
	
	// returns all of the books by the specified author
	public Collection<Item> booksByAuthor(String author)
	{
        return null;
	}
	
	// returns all of the books in the library
	public Collection<Item> books()
	{
        Collection<Item> bookList = new HashSet<Item>();
        for (Item isAbook : NYPL) {
            if (isAbook instanceof Book ) {
                bookList.add(isAbook);
            }
        }
        Comparator<Book> comparator = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                //if (o2.getTitle().equals(o1.getTitle()))
                return 0;
            }
        };

        //Collections.sort(bookList, new Comparator<Book>() {

        return bookList;
	}
	
	// music-related methods
	
	// adds a music album to the library
	public Item addMusicAlbum(String title, String band, int nSongs, String... keywords)
	{
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
	public void addBandMembers(Item album, String... members)
	{
        // Maybe not necessary? Checks to see if the library contains the item, and if the item of of the type
        // needed to call addBandMembers
        if (NYPL.contains(album) && (album instanceof MusicAlbum)) {
            ((MusicAlbum) album).addBandMembers(members);
        }
	}
	
	// removes a music album from the library
	public boolean removeMusicAlbum(String title)
	{
		return false;
	}

	// returns all of the music albums by the specified band
	public Collection<Item> musicByBand(String band)
	{
		return null;
	}
	
	// returns all of the music albums by the specified musician
	public Collection<Item> musicByMusician(String musician)
	{
		return null;
	}
	
	// returns all of the music albums in the library
	public Collection<Item> musicAlbums()
	{
		return null;
	}
	
	// movie-related methods
	
	// adds a movie to the library
	public Item addMovie(String title, String director, int nScenes, String... keywords)
	{
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
	public void addCast(Item movie, String... members)
	{
        if (NYPL.contains(movie) && (movie instanceof Movie)) {
            ((Movie) movie).addCastMembers(members);
        }
	}

	// removes a movie from the library
	public boolean removeMovie(String title)
	{
		return false;
	}
	
	// returns all of the movies by the specified director
	public Collection<Item> moviesByDirector(String director)
	{
		return null;
	}
	
	// returns all of the movies by the specified actor
	public Collection<Item> moviesByActor(String actor)
	{
		return null;
	}
	
	// returns all of the movies in the library
	public Collection<Item> movies()
	{
		return null;
	}	
}
