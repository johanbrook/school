import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator extends JFrame implements ActionListener {
	
	private JTextField n1;
	private JTextField n2;
	
	private JLabel result;
	
	public Calculator(){
		super("Calculator");
		setBounds(200, 300, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 1));
		
		result = new JLabel();
		add(result, JLabel.CENTER);
		
		JButton add = new JButton("Add");
		JButton sub = new JButton("Sub");
		JButton div = new JButton("Div");
		JButton mul = new JButton("Mul");
		
		add.addActionListener(this);
		sub.addActionListener(this);
		div.addActionListener(this);
		mul.addActionListener(this);
		
		add.setActionCommand("add");
		sub.setActionCommand("sub");
		div.setActionCommand("div");
		mul.setActionCommand("mul");
		
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
	
	
	private void calculate(char operator) throws NumberFormatException {
		int term1 = Integer.parseInt(n1.getText());
		int term2 = Integer.parseInt(n2.getText());
		int r;
		
		switch(operator){
			case '-': 	r = term1 - term2; break;
			case '+':	r = term1 + term2; break;
			case '*':	r = term1 * term2; break;
			case '/':	r = term1 / term2; break;
			default:	r = 0;
		}
		
		result.setText(r + "");
		
	}
	
	public void actionPerformed(ActionEvent e){
		JButton obj = (JButton) e.getSource();
		char op = '\0';
		
		if(obj.getActionCommand().equals("add"))
			op = '+';
		else if(obj.getActionCommand().equals("sub"))
			op = '-';
		else if(obj.getActionCommand().equals("div"))
			op = '/';
		else if(obj.getActionCommand().equals("mul"))
			op = '*';
		
		try{
			calculate(op);
		}
		catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(this, "Skriv in giltiga tal!");
		}
	}
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.setVisible(true);
	}
	
}