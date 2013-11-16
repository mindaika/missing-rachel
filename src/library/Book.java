package library;

import java.io.PrintStream;
import java.util.SortedSet;
import java.util.TreeSet;

class Book
	extends Item
{
    // Set private fields to contain information about a Book, and ensure they are initially empty
    private String author = "";
    private int numberOfPages = 0;
    private String title = "";
    private SortedSet<String> keywords = new TreeSet<String>();

    // Set the Author of a Book, assuming no author has yet been set
    public void setAuthor(String authorInput){
        if (author == "")
            author = authorInput;
    }

    // Set the Page Count of a Book, assuming no page count has been set
    public void setPageCount(int pages){
        if (numberOfPages == 0)
            numberOfPages = pages;
    }

    // Set the Title of a Book, assuming no title has been set
    public void setTitle(String bookName){
        if (title == "")
            title = bookName;
    }

    // Add keywords to a book. I was split on whether this is a "Library" function or a "Book" function, since in
    // reality, keywords are declared post-production, as compared to things like the Title. I decided to default to the
    // lowest level of storage
    public void addKeyword(String... keywordList){
        for (String keyword : keywordList)
            if (!keywords.contains(keyword))
                keywords.add(keyword);
    }

    // Remove keywords from book. I allowed this, since it seems logical to me that keywords for a title may change
    // over time.
    public void removeKeyword(String... keywordList){
        for (String keyword : keywordList)
            if (keywords.contains(keyword))
                keywords.remove(keyword);
    }

    @Override
    protected void displayInfo(PrintStream out){
        out.println("-Book-");
        out.println("author:   " + author);
        out.println("# pages:  " + numberOfPages);
        out.println("title:    " + title);
        out.print("keywords: ");
        for (String keyword : keywords) {
            // Clumsy and awkward looking, just like me attempting ballet
            if (!keyword.equals(keywords.last()))
                out.print(keyword + ", ");
            else
                out.print(keyword);
        }
        out.println("\n");
    }

    public String getTitle() {
        return title;
    }
}
