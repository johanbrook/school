import javax.swing.*;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.*;

/** 
*	The game controller.
*
*	This class takes care of creating a main board, drawing the
*	cards, and handling card events. The game logic, basically.
*
*	@author Johan Brook (900720-0216), Robin Andersson (900122-0574)
*	@group 0
*	@assignment Lab 4
*	@date 2011-10-11
*	@note 
*/
public class GameController extends JPanel implements ActionListener {
	
	// Constants
	
	/* How long two cards should be shown (in milliseconds) */
	private final int DELAY = 1500;

	// Instance variables
	
	/* Two players */
	private Player player1;
	private Player player2;
	
	/* The current player */
	private Player activePlayer;
	
	private int cardsRemaining;
	
	/* An array containing all the cards */
	private Kort[] cards;
	/* .. and the cards we're actually playing with: */
	private Kort[] gameCards;
	
	private Kort secondCard;
	private Kort firstCard;
	
	private Timer timer;
	
	private Sound failSound = new Sound("sounds/Funk.wav");
	private Sound correctSound = new Sound("sounds/Pop.wav");
	
	
	/**
	*	Creates a new controller with rows, columns, cards, and two players.
	*	
	*	@param rows Number of rows to fill the playing field
	*	@param cols Numer of columns to fill the playing field
	*	@param cards Field with <code>Kort</code> objects representing every
						image in the images folder
	*	@param player1 A <code>Player</code> representing the first player in
						the game
	*	@param player2 A <code>Player</code> representing the second player in
						the game
	*/	
	public GameController(int rows, int cols, Kort[] cards, 
							Player player1, Player player2){
								
		this.cards = cards;
		this.gameCards = new Kort[rows * cols];
		
		this.player1 = player1;
		this.player2 = player2;
		
		this.timer = new Timer(DELAY, new TimerListener());
		this.timer.setRepeats(false);
		
		// Set the amount of grid cells according to the rows and columns
		setLayout(new GridLayout(rows, cols, 3, 3));
		setVisible(true);
	}
	
	
	/**
	*	Creates a new game. Reset playing field and put new cards on the board.
	*/
	public void nyttSpel(){
		System.out.println("** New game created **");
		
		// Clean up old stuff (references, game area, etc.)
		
		removeAll();
		revalidate();
		
		player1.reset();
		player2.reset();
		player1.setActive(true);
		
		cardsRemaining = gameCards.length;
		
		firstCard = null;
		secondCard = null;
		
		timer.stop();
		
		// end clean
		
		activePlayer = player1;
		
		Verktyg.slumpOrdning(cards);
		
		// Copy one half of the cards, and handle scenarios when
		// the number of cards on the board equals an odd number.
		
		if(gameCards.length % 2 == 0){
			for(int i = 0; i < gameCards.length / 2; i++){
				gameCards[i] = cards[i].copy();
				gameCards[i + gameCards.length / 2] = gameCards[i].copy();
			}
		}
		else{
			for(int i = 0; i < (gameCards.length / 2 + 1); i++){
				gameCards[i] = cards[i].copy();
				
				if( (i + 1) * 2 < gameCards.length){
					gameCards[i + (gameCards.length / 2 + 1)] 
														= gameCards[i].copy();
				}
			}
		}
		
		Verktyg.slumpOrdning(gameCards);
	
		// Draw cards on game pane:
		
		for(int i = 0; i < gameCards.length; i++){
			gameCards[i].addActionListener(this);
			add(gameCards[i]);
		}
	}

	
	
	/**
	*	Where all the action is. Listens to card clicks. 
	*/
	public void actionPerformed(ActionEvent e){
		
		// Handle the New game and Quit button events:
		String action = e.getActionCommand();

		if("new".equals(action) && !timer.isRunning()){
			nyttSpel();
		}
		else if("quit".equals(action) && !timer.isRunning()){

			int choice = JOptionPane.showConfirmDialog(null, 
				"Vill du verkligen avsluta spelet?", 
				"Varning", 
				JOptionPane.YES_NO_OPTION);

			if(choice == JOptionPane.OK_OPTION)	
				System.exit(0);
		}
		
		// Or, a game card is pressed:
		else if(e.getSource() instanceof Kort){

			Kort selectedCard = (Kort) e.getSource();
		
			if(selectedCard.getStatus() == Kort.Status.SAKNAS){
				return;
			}
		
			// Store the first selected card
			if(firstCard == null){
				firstCard = selectedCard;
				firstCard.setStatus(Kort.Status.SYNLIGT);
			}
		
			// Store the second selected card, and start timer
			else if(secondCard == null && firstCard != selectedCard){
				timer.start();
				secondCard = selectedCard;
				secondCard.setStatus(Kort.Status.SYNLIGT);
			}
		}	
	}
	
	
	/*
		Determine and return the winner of a game (added to a
		suitable phrase).
	*/
	private String getWinner(){
		if(player1.getPoints() > player2.getPoints()){
			return "Vinnaren är " + player1.getName();
		}
		else if(player1.getPoints() < player2.getPoints()){
			return "Vinnaren är " + player2.getName();
		}
		else{
			return "Ställningen blev lika";
		}
		
		
	}
	
	

	/* When the timer runs out */
	
	private class TimerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

			if(firstCard.sammaBild(secondCard)){
				activePlayer.addPoint();
				firstCard.setStatus(Kort.Status.SAKNAS);
				secondCard.setStatus(Kort.Status.SAKNAS);

				correctSound.play();

				// Keep track of the remaining cards
				cardsRemaining = cardsRemaining - 2;

				// If no or one card remains the game ends
				if(cardsRemaining <= 1){

					int userChoice = JOptionPane.showConfirmDialog(null,
									getWinner() + "!\nVill du spela igen?", 
									"Spelet klart", 
									JOptionPane.YES_NO_OPTION);

					if(userChoice == JOptionPane.OK_OPTION){
						nyttSpel();
					}else{
						System.exit(0);
					}
				}

			}
			else{
				firstCard.setStatus(Kort.Status.DOLT);
				secondCard.setStatus(Kort.Status.DOLT);

				// Set the active player to the other player.
				activePlayer = (activePlayer == player1) ? player2 : player1;

				// Remember to set the states in the player models as well:
				player1.toggleActive();
				player2.toggleActive();

				failSound.play();
			}

			// Reset local references:
			firstCard = null;
			secondCard = null;

	
		}
	}
	
}