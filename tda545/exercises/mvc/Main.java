import javax.swing.*;
import java.awt.*;

public class Main {
	public static void main(String[] args) {
		User johan = new User("Johan", 21);
		UserController controller = new UserController(johan);
		
		JFrame f = new JFrame("MVC Test");
		f.setLocation(500, 200);
		f.setPreferredSize(new Dimension(500, 200));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(controller);
		f.setResizable(false);
		f.pack();
		f.setVisible(true);
	}
}