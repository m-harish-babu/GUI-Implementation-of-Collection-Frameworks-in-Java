import java.util.PriorityQueue;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class PriorityQueueFrame extends CollectionFrame<String> {
    public PriorityQueueFrame() {
        super("PriorityQueue", new PriorityQueue<>(), new String[]{"Insert", "Remove", "Display"});
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
        if (!data.isEmpty()) {
            // Cast the data to PriorityQueue to access poll()
            String removedElement = ((PriorityQueue<String>) data).poll();
            if (removedElement == null) {
                JOptionPane.showMessageDialog(this, "Queue is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Queue is already empty!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
