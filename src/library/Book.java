package library;

import java.io.PrintStream;

class Book
        extends Item {
    // Set private fields to contain information about a Book, and ensure they are initially empty
    private String author = "";
    private int numberOfPages = 0;
    private String title = "";
    //final private SortedSet<String> keywords = new TreeSet<String>();

    // Set the Page Count of a Book, assuming no page count has been set
    public void setPageCount(int pages) {
        if (numberOfPages == 0)
            numberOfPages = pages;
    }

    @Override
    protected void displayInfo(PrintStream out) {
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

    // Add keywords to a book. I was split on whether this is a "Library" function or a "Book" function, since in
    // reality, keywords are declared post-production, as compared to things like the Title. I decided to default to the
    // lowest level of storage
    /*
    public void addKeyword(String... keywordList){
        for (String keyword : keywordList)
            if (!keywords.contains(keyword))
                keywords.add(keyword);
    }*/

    // Set the Title of a Book, assuming no title has been set
    public void setTitle(String bookName) {
        if (title.equals(""))
            title = bookName;
    }

    public String getAuthor() {
        return author;
    }

    // Set the Author of a Book, assuming no author has yet been set
    public void setAuthor(String authorInput) {
        if (author.equals(""))
            author = authorInput;
    }

    /*
    @Override
    public Boolean keyCheck(String keyword) {
        Boolean match = false;
        if (this.keywords.contains(keyword))
            match = true;
        return match;
    }*/
}
