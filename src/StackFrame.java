import java.util.Stack;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class StackFrame extends CollectionFrame<String> {
    public StackFrame() {
        super("Stack", new Stack<>(), new String[]{"Push", "Pop", "Display"});
    }

    @Override
    protected void addElement() {
        String element = getInput();
        if (element != null) {
            Stack<String> stack = (Stack<String>) data; // Cast data to Stack
            stack.push(element); // Push element onto stack
        }
    }

    @Override
    protected void removeElement() {
        Stack<String> stack = (Stack<String>) data; // Cast data to Stack
        if (stack.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Stack is empty!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            stack.pop(); // Pop element from stack
        }
    }
}
