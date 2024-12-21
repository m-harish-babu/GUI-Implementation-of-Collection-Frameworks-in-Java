import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public abstract class CollectionFrame<T> extends JFrame {

    protected JPanel contentPane;
    protected JTextArea dataArea;
    protected JTextField inputField;
    protected Collection<T> data;
    protected JLabel titleLabel;

    public CollectionFrame(String title, Collection<T> data, String[] buttonLabels) {
        super(title);
        this.data = data;

        // Set the size to match Index class
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 950, 700); // Window size updated
        setResizable(false);

        // Panel setup
        contentPane = new JPanel();
        contentPane.setBackground(new Color(237, 237, 233));
        contentPane.setLayout(null); // Manual layout
        setContentPane(contentPane);

        // Title Label
        titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
        titleLabel.setForeground(new Color(47, 72, 88));
        titleLabel.setBounds(375, 20, 200, 40); // Centered at top
        titleLabel.setHorizontalAlignment(JLabel.CENTER); // Center alignment
        titleLabel.setBounds(325, 20, 300, 40); // Horizontally center
        contentPane.add(titleLabel);

        // Element Label
        JLabel elementLabel = new JLabel("Element:");
        elementLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        elementLabel.setForeground(new Color(47, 72, 88));
        elementLabel.setBounds(145, 100, 300, 50); // Adjusted width for better alignment
        contentPane.add(elementLabel);

        // Input Field
        inputField = new JTextField();
        inputField.setFont(new Font("Tahoma", Font.PLAIN, 24));
        inputField.setBounds(275, 100, 530, 50); // Adjusted width and position to fit within bounds
        contentPane.add(inputField);

        // Buttons
        int buttonY = 180; // Buttons below input field
        int buttonWidth = 200;
        int buttonSpacing = 30; // Increased spacing for better alignment
        int totalWidth = (buttonWidth + buttonSpacing) * buttonLabels.length - buttonSpacing;
        int buttonStartX = (950 - totalWidth) / 2; // Centered horizontally

        for (int i = 0; i < buttonLabels.length; i++) {
            String label = buttonLabels[i];
            int buttonX = buttonStartX + i * (buttonWidth + buttonSpacing);
            addButton(label, buttonX, buttonY);
        }

        // Text Area
        dataArea = new JTextArea();
        dataArea.setFont(new Font("Tahoma", Font.PLAIN, 24));
        dataArea.setForeground(new Color(47, 72, 88)); // Set text color to blue
        dataArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(dataArea);
        scrollPane.setBounds(145, 260, 660, 350); // Centered horizontally
        contentPane.add(scrollPane);
    }

    private void addButton(String buttonText, int x, int y) {
        JButton button = new JButton(buttonText);
        button.setFont(new Font("Tahoma", Font.BOLD, 20));
        button.setForeground(new Color(3, 64, 120));
        button.setBackground(new Color(221, 229, 182));
        button.setBorder(new LineBorder(new Color(238, 108, 77), 2));
        button.setBounds(x, y, 200, 40); // Adjusted button size and position
        contentPane.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (buttonText) {
                    case "Add":
                    case "Insert":
                    case "Enqueue":
                    case "Push":
                        addElement();
                        break;
                    case "Remove":
                    case "Delete":
                    case "Dequeue":
                    case "Pop":
                    case "Poll":
                        removeElement();
                        break;
                    case "Display":
                    case "Find":
                        displayCollection();
                        break;
                }
            }
        });
    }

    protected abstract void addElement();

    protected abstract void removeElement();

    protected void displayCollection() {
        if (data != null) {
            dataArea.setText(data.toString().replaceAll("[\\[\\]]", "").replaceAll(",", " | "));
        } else {
            dataArea.setText("Collection is null!");
        }
    }

    @SuppressWarnings({ "unchecked" })
	protected T getInput() {
        String input = inputField.getText();
        inputField.setText("");
        if (input.isEmpty()) {
            return null;
        }
        return (T) input; // Assuming input is valid for simplicity
    }
}
