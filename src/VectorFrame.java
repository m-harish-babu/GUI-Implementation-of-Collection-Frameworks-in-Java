import java.util.Vector;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class VectorFrame extends CollectionFrame<String> {
    public VectorFrame() {
        super("Vector", new Vector<>(), new String[]{"Add", "Remove", "Display"});
    }

    @Override
    protected void addElement() {
        String element = getInput();
        if (element != null) {
            Vector<String> vector = (Vector<String>) data; // Cast data to Vector
            vector.add(element); // Add element to vector
        }
    }

    @Override
    protected void removeElement() {
        String element = getInput();
        if (element != null) {
            Vector<String> vector = (Vector<String>) data; // Cast data to Vector
            if (!vector.remove(element)) {
                JOptionPane.showMessageDialog(this, "Element not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
