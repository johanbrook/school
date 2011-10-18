import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AlarmClock extends JFrame implements ActionListener {
	
	private JButton set;
	private JButton minutesButton;
	private JButton hoursButton;
	
	private int hours;
	private int minutes;
	
	public AlarmClock(){
		hours = 0;
		minutes = 0;
		
		Font font = new Font("Times", Font.PLAIN, 36);
		JLabel label = new JLabel("Larmclock", JLabel.CENTER);
		label.setFont(font);
		
		JPanel p = new JPanel();
		p.add(label);
		p.setBackground(Color.YELLOW);
		p.setOpaque(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,1));
		
		JPanel buttonsPanel = new JPanel();
		
		set = new JButton("Set");
		minutesButton = new JButton("0");
		hoursButton = new JButton("0");
		
		set.addActionListener(this);
		hoursButton.addActionListener(this);
		minutesButton.addActionListener(this);
		
		set.setFont(font);
		minutesButton.setFont(font);
		hoursButton.setFont(font);
		
		buttonsPanel.add(hoursButton);
		buttonsPanel.add(minutesButton);
		buttonsPanel.add(set);
		
		add(p);
		add(buttonsPanel);
		
		pack();
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e){
		Object temp = e.getSource();
		if(temp == hoursButton){
			hours++;
			
			if(hours == 24){
				hours = 0;
			}
			
		}
		else if(temp == minutesButton){
			minutes += 10;
			if(minutes == 60){
				minutes = 0;
				hours++;
			}
		}
		else{
			System.out.println("Tid satt till " + hours + ":" + minutes);
		}
		
		minutesButton.setText(minutes+"");
		hoursButton.setText(hours+"");
	}
	
	public static void main(String[] args) {
		new AlarmClock();
	}
	
	
}