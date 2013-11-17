package library;

import java.io.PrintStream;
import java.util.SortedSet;
import java.util.TreeSet;

class MusicAlbum
        extends Item {
    // Arguably, members should be a HashSet, since the data sets will be small. But, since these will all
    // have to be displayed Sorted at some point, Trees make since and are still non-linear
    private final SortedSet<String> members = new TreeSet<String>();
    // Set private fields to contain information about a MusicAlbum, and ensure they are initially empty
    private String band = "";
    private int numberOfSongs = 0;
    private String title = "";
    //private final SortedSet<String> keywords = new TreeSet<String>();

    // Set the Author of a Book, assuming no author has yet been set
    public void setBandName(String bandInput) {
        if (band.equals(""))
            band = bandInput;
    }

    // Set the Song Count of a MusicAlbum, assuming no page count has been set
    public void setSongCount(int songs) {
        if (numberOfSongs == 0)
            numberOfSongs = songs;
    }

    // Add member to the band list
    public void addBandMembers(String... memberList) {
        for (String member : memberList)
            if (!members.contains(member))
                members.add(member);
    }
/*

    // Add keywords to a book. I was split on whether this is a "Library" function or a "MusicAlbum" function, since in
    // reality, keywords are declared post-production, as compared to things like the Title. I decided to default to the
    // lowest level of storage
    public void addKeyword(String... keywordList){
        for (String keyword : keywordList)
            if (!keywords.contains(keyword))
                keywords.add(keyword);
    }
*/

    @Override
    protected void displayInfo(PrintStream out) {
        out.println("-Music Album-");
        out.println("band:     " + band);
        out.println("# songs:  " + numberOfSongs);
        out.print("members:  ");
        for (String member : members) {
            if (!member.equals(members.last()))
                out.print(member + ", ");
            else
                out.println(member);
        }
        out.println("title:    " + title);
        printKeywords(out);
        /*for (String keyword : keywords) {
            if (!keyword.equals(keywords.last()))
                out.print(keyword + ", ");
            else
                out.println(keyword);
        }*/
        out.println("\n");
    }

    public String getTitle() {
        return title;
    }

    // Set the Title of a MusicAlbum, assuming no title has been set
    public void setTitle(String albumName) {
        if (title.equals(""))
            title = albumName;
    }

    public String getBand() {
        return band;
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

    public Boolean museCheck(String musician) {
        Boolean match = false;
        if (this.members.contains(musician))
            match = true;
        return match;
    }
}
