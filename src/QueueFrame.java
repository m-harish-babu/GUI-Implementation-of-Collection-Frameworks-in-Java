import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class QueueFrame extends CollectionFrame<String> {
    public QueueFrame() {
        super("Queue", new LinkedList<>(), new String[]{"Enqueue", "Dequeue", "Display"});
    }

    @Override
    protected void addElement() {
        String element = getInput();
        if (element != null) {
            Queue<String> queue = (Queue<String>) data; // Cast data to Queue
            queue.offer(element); // Enqueue element
        }
    }

    @Override
    protected void removeElement() {
        Queue<String> queue = (Queue<String>) data; // Cast data to Queue
        if (queue.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Queue is empty!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            queue.poll(); // Dequeue element
        }
    }
}
