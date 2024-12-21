import java.util.ArrayDeque;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ArrayDequeFrame extends CollectionFrame<String> {
    public ArrayDequeFrame() {
        super("ArrayDeque", new ArrayDeque<>(), new String[]{"Enqueue", "Dequeue", "Display"});
    }

    @Override
    protected void addElement() {
        String element = getInput();
        if (element != null) {
            data.add(element); // Add to the deque
        }
    }

    @Override
    protected void removeElement() {
        if (!data.isEmpty()) {
            // Remove the first element (queue behavior)
            String removedElement = ((ArrayDeque<String>) data).poll();
            if (removedElement == null) {
                JOptionPane.showMessageDialog(this, "Deque is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Deque is already empty!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
