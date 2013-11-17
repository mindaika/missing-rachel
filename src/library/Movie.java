package library;

import java.io.PrintStream;
import java.util.SortedSet;
import java.util.TreeSet;

class Movie
        extends Item {
    private final SortedSet<String> members = new TreeSet<String>();
    // Set private fields to contain information about a Movie, and ensure they are initially empty
    private String director = "";
    private int numberOfScenes = 0;
    private String title = "";
    //private final SortedSet<String> keywords = new TreeSet<String>();

    // Set the Song Count of a MusicAlbum, assuming no page count has been set
    public void setSceneCount(int scenes) {
        if (numberOfScenes == 0)
            numberOfScenes = scenes;
    }

    // Add member to the director list
    public void addCastMembers(String... memberList) {
        for (String member : memberList)
            if (!members.contains(member))
                members.add(member);
    }

    @Override
    protected void displayInfo(PrintStream out) {
        out.println("-Movie-");
        out.println("director: " + director);
        out.println("# scenes: " + numberOfScenes);
        out.print("cast:     ");
        for (String member : members) {
            if (!member.equals(members.last()))
                out.print(member + ", ");
            else
                out.println(member);
        }
        out.println("title:    " + title);
        printKeywords(out);
/*        for (String keyword : keywords) {
            if (!keyword.equals(keywords.last()))
                out.print(keyword + ", ");
            else
                out.println(keyword);
        }*/
        out.println("\n");
    }

    // Add keywords to a book. I was split on whether this is a "Library" function or a "MusicAlbum" function, since in
    // reality, keywords are declared post-production, as compared to things like the Title. I decided to default to the
    // lowest level of storage
    /*
    public void addKeyword(String... keywordList){
        for (String keyword : keywordList)
            if (!keywords.contains(keyword))
                keywords.add(keyword);
    }*/

    public String getTitle() {
        return title;
    }

    // Set the Title of a MusicAlbum, assuming no title has been set
    public void setTitle(String movieTitle) {
        if (title.equals(""))
            title = movieTitle;
    }

    public String getDirector() {
        return director;
    }

    // Set the Author of a Book, assuming no author has yet been set
    public void setDirector(String dirInput) {
        if (director.equals(""))
            director = dirInput;
    }
/*

    @Override
    public Boolean keyCheck(String keyword) {
        Boolean match = false;
        if (this.keywords.contains(keyword))
            match = true;
        return match;
    }
*/

    public Boolean hasActor(String person) {
        Boolean match = false;
        if (this.members.contains(person))
            match = true;
        return match;
    }
}
