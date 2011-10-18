/** 
*	Main game window
*
*	@author Johan Brook (900720-0216), Robin Andersson (900122-0574)
*	@group 0
*	@assignment Lab 4
*	@date 2011-10-03
*	@note 
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import com.apple.eawt.Application;

public class Memory extends JFrame {
	
	// Instance variables
	
	private GameController game;
	public final String IMAGE_PATH = "images";
	
	/**
	*	Create a new memory game.
	*
	*	@param name The title of the game window
	*/
	public Memory(String name){
		super(name);
		
		int rows = 6;
		int cols = 6;
		Kort[] cards = null;
		
		setLocation(300, 300);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		Application app = Application.getApplication();
		BufferedImage icon = null;
		try{
			icon = ImageIO.read(new File(IMAGE_PATH + "/icon.jpg"));
			app.setDockIconImage(icon);
			
		}catch(IOException e){
			System.out.println("Couldn't read icon file: " + e.getMessage());
		}
		
		
		boolean success = false;
		
		while(!success){
			String sRows = JOptionPane.showInputDialog(this, "Hur många rader?");
			if(sRows == null){
				System.exit(0);
			}

			String sCols = JOptionPane.showInputDialog(this, "Hur många kolumner?");
			if(sCols == null){
				System.exit(0);
			}
			
			try{	
				rows = Integer.parseInt(sRows);
				cols = Integer.parseInt(sCols);
				
				if(rows*cols % 2 != 0){
					JOptionPane.showMessageDialog(this, "Antalet rutor får inte vara udda!", "Error", JOptionPane.ERROR_MESSAGE);
					success = false;
				}
				else{
					cards = Verktyg.loadIcons((rows * cols) / 2, IMAGE_PATH);
					success = true;
				}
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(this, "Du måste skriva in siffror!", "Error", JOptionPane.ERROR_MESSAGE);
				success = false;
			}
			catch(ArrayIndexOutOfBoundsException e){
				JOptionPane.showMessageDialog(this, "Det fanns inte tillräckligt med bilder!", "Error", JOptionPane.ERROR_MESSAGE);
				success = false;
			}
			catch(NullPointerException e){
				JOptionPane.showMessageDialog(this, "Kunde inte hitta bilder i mappen!", "Error", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}

		}

		// Buttons
		JButton newGameB = new JButton("Nytt");
		JButton quitB = new JButton("Avsluta");
		
		// Create two players
		Player player1 = new Player("Johan", true);
		Player player2 = new Player("Robin");
		
		// .. and views for them
		PlayerView player1View = new PlayerView(player1);
		PlayerView player2View = new PlayerView(player2);
		
		player1.addObserver(player1View);
		player2.addObserver(player2View);
		
		JPanel playerPane = new JPanel(new GridLayout(2,1));
		playerPane.setPreferredSize(new Dimension(70, 100));
		
		playerPane.add(player1View);
		playerPane.add(player2View);
		

		JPanel controlPane = new JPanel();
		
		newGameB.addActionListener(new newGameListener());
		quitB.addActionListener(new quitGameListener());
		
		controlPane.add(newGameB);
		controlPane.add(quitB);
		
		// Create a new game board:
		game = new GameController(rows, cols, cards, player1, player2);
		
		add(playerPane, BorderLayout.WEST);
		add(game, BorderLayout.CENTER);
		add(controlPane, BorderLayout.SOUTH);
		
		// New game!
		game.newGame();
		
		pack();
		setVisible(true);
	}
	
	
	
	
	private class newGameListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			game.newGame();
		}
	}
	
	private class quitGameListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			game.killGame();
			/*
				int choice = JOptionPane.showConfirmDialog(null, "Vill du verkligen avsluta spelet?", "Varning", JOptionPane.YES_NO_OPTION);

				if(choice == JOptionPane.OK_OPTION)	
					System.exit(0);
			
			*/
		}
	}
	
	
	public static void main(String[] args){
		new Memory("Test");
	}
}
