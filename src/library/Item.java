// Each book, music album, or movie will be an instance of a subclass of this class.
// Instances of this class should not be created. Specifying it as 'abstract' ensures
// that they cannot.

package library;

import java.io.PrintStream;
import java.util.Collection;

// Herein lies the Item interface for the Library, containing general methods applicable to all items.
public abstract class Item
{

    abstract protected void displayInfo(PrintStream out);

    abstract public String getTitle();

    abstract public Boolean keyCheck(String keyword);
}
