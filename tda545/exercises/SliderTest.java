import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class SliderTest extends JFrame implements ChangeListener, ActionListener {
	
	private JRadioButton male;
	private JRadioButton female;
	private JSlider slider;
	
	private JTextField result;
	
	public SliderTest(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 200, 400);
		setLayout(new BorderLayout());
		
		JLabel gender = new JLabel("Your gender:");
		
		male = new JRadioButton("Male", true);
		female = new JRadioButton("Female");
		
		ButtonGroup group = new ButtonGroup();
		group.add(male);
		group.add(female);
		
		result = new JTextField(20);
		result.setEditable(false);
		
		male.addActionListener(this);
		female.addActionListener(this);
		
		JLabel height = new JLabel("Height in inches:");
		slider = new JSlider(JSlider.VERTICAL, 40, 80, 50);
		slider.addChangeListener(this);
		
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		
		JPanel l = new JPanel();
		JPanel r = new JPanel(new BorderLayout());
		
		l.setLayout(new GridLayout(2, 1));
		l.add(gender);
		l.add(male);
		l.add(female);
		
		r.add(height, BorderLayout.NORTH);
		r.add(slider, BorderLayout.CENTER);
		r.add(result, BorderLayout.SOUTH);
		
		add(l, BorderLayout.WEST);
		add(r, BorderLayout.EAST);
		
		pack();
	}
	
	private double femaleWeight(int height){
		return (height * height) / 30;
	}
	
	private double maleWeight(int height){
		return (height * height) / 28;
	}
	
	public void stateChanged(ChangeEvent e){
		
		if(e.getSource() == slider){
			JSlider s = (JSlider) e.getSource();
			int value = s.getValue();
			
			if(male.isSelected())
				result.setText(maleWeight(value) + "");
			else
				result.setText(femaleWeight(value) + "");
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == male){
			result.setText(maleWeight(slider.getValue()) + "");
		}
		else if(e.getSource() == female){
			result.setText(femaleWeight(slider.getValue()) + "");
		}
	}
	
	public static void main(String[] args) {
		SliderTest j = new SliderTest();
		j.setVisible(true);
	}
}