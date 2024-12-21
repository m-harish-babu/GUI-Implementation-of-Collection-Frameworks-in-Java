import java.util.LinkedList;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class LinkedListFrame extends CollectionFrame<String> {
	public LinkedListFrame() {
        super("LinkedList", new LinkedList<>(), new String[]{"Insert", "Delete", "Display"}); // Corrected
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