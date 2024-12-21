import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Index extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// Launch the Application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Index frame = new Index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the frame.
	public Index() {
        setTitle("Index");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 700);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(237, 237, 233));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Select The Collection Framework");
        lblNewLabel.setForeground(new Color(47, 72, 88));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel.setBounds(225, 100, 550, 50);
        contentPane.add(lblNewLabel);

        // Create buttons and add action listeners
        addButton("LinkedList", 250, 200, LinkedListFrame.class);
        addButton("ArrayList", 500, 200, ArrayListFrame.class);
        addButton("Stack", 250, 275, StackFrame.class);
        addButton("Queue", 500, 275, QueueFrame.class);
        addButton("ArrayDeque", 250, 350, ArrayDequeFrame.class);
        addButton("PriorityQueue", 500, 350, PriorityQueueFrame.class);
        addButton("HashSet", 250, 425, HashSetFrame.class);
        addButton("LinkedHashSet", 500, 425, LinkedHashSetFrame.class);
        addButton("TreeSet", 250, 500, TreeSetFrame.class);
        addButton("Vector", 500, 500, VectorFrame.class);
    }

	private void addButton(String buttonText, int x, int y, Class<? extends JFrame> frameClass) { // Corrected line
        JButton button = new JButton(buttonText);
        button.setForeground(new Color(3, 64, 120));
        button.setFont(new Font("Tahoma", Font.BOLD, 20));
        button.setBackground(new Color(221, 229, 182));
        button.setBorder(new LineBorder(new Color(238, 108, 77), 2));
        button.setBounds(x, y, 200, 40);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFrame frame = frameClass.getDeclaredConstructor().newInstance();
                    frame.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(Index.this, "Error opening frame: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        contentPane.add(button);
    }
}
