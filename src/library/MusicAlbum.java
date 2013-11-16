package library;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

class MusicAlbum
	extends Item
{
    // Set private fields to contain information about a MusicAlbum, and ensure they are initially empty
    private String band = "";
    private int numberOfSongs = 0;
    private String title = "";
    // Arguably, members should be a HashSet, since the datasets will be small. But, since these will all
    // have to be displayed Sorted at some point, Trees make since and are still non-linear
    private SortedSet<String> members = new TreeSet<String>();
    private SortedSet<String> keywords = new TreeSet<String>();

    // Set the Author of a Book, assuming no author has yet been set
    public void setBandName(String bandInput){
        if (band == "")
            band = bandInput;
    }

    // Set the Song Count of a MusicAlbum, assuming no page count has been set
    public void setSongCount(int songs){
        if (numberOfSongs == 0)
            numberOfSongs = songs;
    }

   // Add member to the band list
    public void addBandMembers(String... memberList){
        for (String member : memberList)
            if (!members.contains(member))
                members.add(member);
    }

    // Add keywords to a book. I was split on whether this is a "Library" function or a "MusicAlbum" function, since in
    // reality, keywords are declared post-production, as compared to things like the Title. I decided to default to the
    // lowest level of storage
    public void addKeyword(String... keywordList){
        for (String keyword : keywordList)
            if (!keywords.contains(keyword))
                keywords.add(keyword);
    }

    // Set the Title of a MusicAlbum, assuming no title has been set
    public void setTitle(String albumName){
        if (title == "")
            title = albumName;
    }

    // Remove keywords from item. I allowed this, since it seems logical to me that keywords for a title may change
    // over time.
    public void removeKeyword(String... keywordList){
        for (String keyword : keywordList)
            if (keywords.contains(keyword))
                keywords.remove(keyword);
    }

    @Override
    protected void displayInfo(PrintStream out){
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
        out.print("keywords: ");
        for (String keyword : keywords) {
            if (!keyword.equals(keywords.last()))
                out.print(keyword + ", ");
            else
                out.println(keyword);
        }
        out.println("");
    }

    public String getTitle() {
        return title;
    }
}
