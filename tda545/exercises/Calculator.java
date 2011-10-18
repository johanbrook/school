import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator extends JFrame implements ActionListener {
	
	private JTextField n1;
	private JTextField n2;
	private JButton add;
	private JButton sub;
	private JButton div;
	private JButton mul;
	
	private JLabel result;
	
	public Calculator(){
		super("Calculator");
		setBounds(200, 300, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 1));
		
		result = new JLabel();
		add(result, JLabel.CENTER);
		
		add = new JButton("Add");
		sub = new JButton("Sub");
		div = new JButton("Div");
		mul = new JButton("Mul");
		
		add.addActionListener(this);
		sub.addActionListener(this);
		div.addActionListener(this);
		mul.addActionListener(this);
		
		n1 = new JTextField(5);
		n2 = new JTextField(5);
		
		JPanel t = new JPanel();
		t.add(n1);
		t.add(n2);
		
		add(t);
		
		JPanel b = new JPanel();
		b.add(add);
		b.add(sub);
		b.add(div);
		b.add(mul);
		
		add(b);
		
		pack();
	}
	
	
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		
		int term1;
		int term2;
		int r = 0;
		
		try{
			term1 = Integer.parseInt(n1.getText());
			term2 = Integer.parseInt(n2.getText());
		}
		catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(this, "Du måste mata in korrekta tal!");
			return;
		}
		
		if(obj == add){
			r = term1 + term2;
		}
		else if(obj == sub){
			r = term1 - term2;
		}
		else if(obj == mul){
			r = term1 * term2;
		}
		else if(obj == div){
			r = term1 / term2;
		}
		
		result.setText(r + "");
		result.setBackground(Color.YELLOW);
	}
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.setVisible(true);
	}
	
}