// Each book, music album, or movie will be an instance of a subclass of this class.
// Instances of this class should not be created. Specifying it as 'abstract' ensures
// that they cannot.

package library;

import java.io.PrintStream;
import java.util.*;

// Herein lies the Item interface for the Library, containing general methods applicable to all items.
public abstract class Item {
    protected Set<String> keywords = new TreeSet<String>();
    //protected static Map keyMap = new HashMap<String, Item>();
    protected static Map<String, List<Item>> keyMap = new HashMap<String, List<Item>>();


    abstract protected void displayInfo(PrintStream out);

    abstract public String getTitle();

    public void addKeyword(String... keywordList) {
        for (String keyword : keywordList) {
            keywords.add(keyword);
            if (keyMap.containsKey(keyword)) {
                keyMap.get(keyword).add(this);
            } else {
                List<Item> itemsMatchingKeyword = new LinkedList<Item>();
                keyMap.put(keyword, itemsMatchingKeyword);
                keyMap.get(keyword).add(this);
            }
        }
    }

/*    public Boolean keyCheck(String keyword) {
        System.out.println(keyMap.get(keyword));
        return (keywords.contains(keyword));
    }*/

    // This raises a curious issue: There are a number of unique things to print for any given item, and a number of
    // non-uniques, keywords amongst them. If I move all the non-uniques here, I have this awkward back and forth of
    // printing things from Item and printing things from <Subclass>
    protected void printKeywords(PrintStream out) {
        out.print("keywords: ");
        Iterator<String> k = keywords.iterator();
        while (k.hasNext()) {
            out.print(k.next());
            if (k.hasNext())
                out.print(", ");
        }
    }

/*    public List<Item> getItemsMatchingKeyword(String keyword) {
        return keyMap.get(keyword);
    }*/
}
