import java.util.HashSet;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class HashSetFrame extends CollectionFrame<String> {
    public HashSetFrame() {
        super("HashSet", new HashSet<>(), new String[]{"Add", "Remove", "Display"});
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