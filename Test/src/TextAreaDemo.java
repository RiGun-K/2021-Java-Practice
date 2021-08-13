import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAreaDemo extends JFrame implements ActionListener {
	private JTextField textField;
	private JTextArea textArea;

	public TextAreaDemo() {
		this.setTitle("Text Area");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField(30);
		textField.addActionListener(this);
		
		textArea = new JTextArea(10, 30);
		textArea.setEditable(false);
		
		this.add(textField, BorderLayout.NORTH);
		this.add(textArea, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		this.add(scrollPane, BorderLayout.CENTER);
		
		this.pack();
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String text = textField.getText();
		textArea.append(text + "\n");
		
		textField.selectAll();
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
	
	public static void main(String[] args) {
		new TextAreaDemo();
	}
}

