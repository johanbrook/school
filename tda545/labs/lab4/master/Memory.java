import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

/** 
*	Main game window
*
*	@author Johan Brook (900720-0216), Robin Andersson (900122-0574)
*	@group 0
*	@assignment Lab 4
*	@date 2011-10-11
*/
public class Memory extends JFrame {
	
	// Constants

	private final String IMAGE_PATH = "images";
	
	// Instance variables
	
	private GameController game;

	/**
	*	Creates a new memory game.
	*
	*	@param name The title of the game window
	*/
	public Memory(String name){
		super(name);
		
		// To prevent "might not have been initialized".
		int rows = 6;
		int cols = 6;
		String player1Name = null;
		String player2Name = null;
		
		File[] images = null;	// All images in the directory
		Kort[] cards = null;	// Kort objects representing every image
		
		setLocation(300, 300);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		
		// Try to load the images and handle errors accordingly

		try{
			File imageFolder = new File(IMAGE_PATH);
			images = imageFolder.listFiles();
			
			// If the image folder is empty then the program exits
			if(images.length <= 0){
				JOptionPane.showMessageDialog(this,
					"Kunde inte hitta några bilder!\nPlacera önskat antal" +
					"bilder i mappen 'images'.\n\nProgrammet avslutas.",
					"Inga bilder hittades", JOptionPane.ERROR_MESSAGE);
					
				System.exit(0);
			}
						
			cards = new Kort[images.length];
			
			// Create Kort objects from the images
			for(int i = 0; i < images.length; i++){
				cards[i] = new Kort( 
					new ImageIcon(images[i].getPath()), 
					Kort.Status.DOLT);
			}
			
		}
		catch(NullPointerException e){
			JOptionPane.showMessageDialog(this, "Ingen '" + IMAGE_PATH +
				"'-mapp hittades!\nProgrammet avslutas.", "Inläsningsfel",
				JOptionPane.ERROR_MESSAGE);
				
			System.exit(1);
		}
		
		
		// Input from user
		
		boolean correctInput = false;
		IntroDialog dialog = new IntroDialog(this, "Inställningar");
		
		while(!correctInput){
			dialog.setVisible(true);
			
			if(dialog.getValue().equals(new Integer
										(JOptionPane.CLOSED_OPTION))){
				System.exit(0);
			}
			
			// Store input values
			String[] results = dialog.getInput();

			rows = Integer.parseInt(results[0]);
			cols = Integer.parseInt(results[1]);
			player1Name = results[2];
			player2Name = results[3];
			
			// Exit loop if there're enough images to support the user request
			if(rows * cols <= images.length * 2){
				correctInput = true;
			}
			else{
				JOptionPane.showMessageDialog(this,
					"Det finns inte tillräckligt med bilder!\n"+
					"Minska antalet rader och kolumner, eller lägg"+
					" in fler\nbilder i mappen '"+IMAGE_PATH+"' och " +
					"starta om programmet.", 
					
					"Error", 
					JOptionPane.ERROR_MESSAGE);
			}
		}


		// The main window UI


		// Buttons
		JButton newGameB = new JButton("Nytt");
		JButton quitB = new JButton("Avsluta");
		
		// Create two players
		Player player1 = new Player(player1Name, true);
		Player player2 = new Player(player2Name);
		
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
		
		newGameB.setActionCommand("new");
		quitB.setActionCommand("quit");
		
		controlPane.add(newGameB);
		controlPane.add(quitB);
		
		// Create a new game board:
		game = new GameController(rows, cols, cards, player1, player2);
		
		// GameController listens to the new game and quit buttons
		newGameB.addActionListener(game);
		quitB.addActionListener(game);
		
		add(playerPane, BorderLayout.WEST);
		add(game, BorderLayout.CENTER);
		add(controlPane, BorderLayout.SOUTH);
		
		// New game!
		game.nyttSpel();
		
		pack();
		setVisible(true);
	}
}