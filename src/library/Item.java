// Each book, music album, or movie will be an instance of a subclass of this class.
// Instances of this class should not be created. Specifying it as 'abstract' ensures
// that they cannot.

package library;

import java.io.PrintStream;

public abstract class Item
{
    abstract protected void displayInfo(PrintStream out);
}
