import java.util.TreeSet;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class TreeSetFrame extends CollectionFrame<String> {
    public TreeSetFrame() {
        super("TreeSet", new TreeSet<>(), new String[]{"Add", "Remove", "Display"});
    }

    @Override
    protected void addElement() {
        String element = getInput();
        if (element != null) {
            data.add(element);
        }
    }

    @Override
    protected void removeElement() {
        String element = getInput();
        if (element != null) {
            if (!data.remove(element)) {
                JOptionPane.showMessageDialog(this, "Element not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}