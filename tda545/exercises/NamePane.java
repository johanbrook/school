import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class NamePane extends JFrame implements ActionListener {
	
	private JTextField text;
	
	public NamePane(){
		super("Names");
		setBounds(300, 400, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2, 1));
		
		JPanel texts = new JPanel();
		
		JLabel label = new JLabel("Skriv in ditt namn: ");
		texts.add(label);
		
		text = new JTextField(20);
		texts.add(text);
		
		add(texts);
		
		JButton submit = new JButton("Test");
		JButton clear = new JButton("Clear");
		submit.setActionCommand("submit");
		clear.setActionCommand("clear");
		
		submit.addActionListener(this);
		clear.addActionListener(this);
		
		JPanel buttons = new JPanel();
		buttons.add(submit);
		buttons.add(clear);
		
		add(buttons);
		pack();
	}
	
	public static void main(String[] args) {
		NamePane p = new NamePane();
		p.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getActionCommand().equals("submit")){
			String t = text.getText().toUpperCase();
			String h = JOptionPane.showInputDialog("Vad är din hårfärg?").toUpperCase();
			if(h != null){
				text.setText(t + " " + h);
			}
		}
		else{
			text.setText("");
		}
	}
	
}