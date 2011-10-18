/** 
*	The game controller.
*
*	This class takes care of creating a main board, drawing the
*	cards, and handling card events. The game logic, basically.
*
*	@author Johan Brook (900720-0216), Robin Andersson (900122-0574)
*	@group 0
*	@assignment Lab 4
*	@date 2011-10-03
*	@note 
*/

import javax.swing.*;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.*;

public class GameController extends JPanel implements ActionListener {
	
	// Constants
	
	/* How long two cards should be shown (in milliseconds) */
	private final int DELAY = 1500;
	
	private final String CORRECT_GUESS_TITLE = "Rätt gissning!";
	private final String INCORRECT_GUESS_TITLE = "Fel gissning";
	
	/* Two players */
	private Player player1;
	private Player player2;
	
	/* The active player */
	private Player activePlayer;
	
	/* The size of the board */
	private int gridArea;
	
	/* An array containing all the cards */
	private Kort[] cards;
	private Kort activeCard;
	private Kort oldCard;
	
	/* Timer variables */
	private boolean timerIsRunning = false;
	private Timer timer;
	
	private CardListener cardListener;
	
	private Sound failSound = new Sound("sounds/Funk.wav");
	private Sound correctSound = new Sound("sounds/Pop.wav");
	
	
	/**
	*	Create a new controller with rows, columns, cards, and two players
	*
	*/
	public GameController(int rows, int cols, Kort[] cards, 
							Player player1, Player player2){
								
		this.gridArea = rows * cols;
		this.cards = cards;
		this.player1 = player1;
		this.player2 = player2;
		
		this.timer = new Timer(DELAY, new TimerListener());
		
		// Set the amount of grid cells according to the rows and columns
		setLayout(new GridLayout(rows, cols, 3, 3));
		setVisible(true);
	}
	
	
	/**
	*	Create a new game, i.e. shuffle and draw new cards on
	*	the board.
	*/
	public void newGame(){
		System.out.println("** New game created **");
		
		// Clean up old stuff
		killGame();
		
		// Set the active player to player 1
		activePlayer = player1;
		
		System.out.println("Card length: " + cards.length);
		shuffleAndDoubleCards(cards);
		System.out.println("Card length after double: " + cards.length);
		
		Kort.resetAll(cards.length);
		
		cardListener = new CardListener();
		
		for(int i = 0; i < gridArea; i++){
			Kort card = cards[i];
			card.addActionListener(cardListener);
			
			add(card);
		}
	}
	
	/**
	*	Cleans up the board.
	*/
	public void killGame(){
		for(int i = 0; i < cards.length; i++){
			cards[i].removeActionListener(cardListener);
			cards[i].setStatus(Kort.Status.DOLT);
		}
		
		player1.reset();
		player2.reset();
		
	// TODO: Måste styra upp klassvariabeln numberofvisiblecards i Kort.java
		removeAll();
		revalidate();
		repaint();
	}
	
	
	/**
	*	Where all the action is. Listens to click on the cards.
	*/
	public void actionPerformed(ActionEvent e){
		Kort c = (Kort) e.getSource();
		
		// Don't do anything if the timer is running
		if(c.getStatus() != Kort.Status.SAKNAS && !timerIsRunning){

			// Show the card
			c.setStatus(Kort.Status.SYNLIGT);
			
			// Is this the first card to be shown?
			if(Kort.getNumberOfVisibleCards() < 2){
				oldCard = c;
			}
			
			// Nope, this was the second. Start the timer:
			else{
				activeCard = c;
				timer.start();
				timerIsRunning = true;
				
				// Have we found two matching cards?
				if(oldCard.sammaBild(activeCard)){
					
					// Yay! Add a point to the player (and change the window title)
					activePlayer.addPoint();
					((JFrame) SwingUtilities.getRoot(this)).setTitle(CORRECT_GUESS_TITLE);
				}
				else{
					((JFrame) SwingUtilities.getRoot(this)).setTitle(INCORRECT_GUESS_TITLE);
				}
			}
		}
	}
	
	/**
	*	Takes an array of cards and shuffles the order and 
	*	doubles them (in order two have pairs).
	*/
	private void shuffleAndDoubleCards(Kort[] unScrambledCards){
		Verktyg.slumpOrdning(unScrambledCards);
		
		Kort[] temp = new Kort[gridArea];
		int half = (gridArea / 2);
		
		for(int i = 0; i < half; i++ ){
			temp[i] = unScrambledCards[i];
			temp[half + i] = temp[i].copy();
		}
		
		Verktyg.slumpOrdning(temp);
		this.cards = temp;
	}
	
	
	private class CardListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			Kort c = (Kort) e.getSource();

			// Don't do anything if the timer is running
			if(c.getStatus() != Kort.Status.SAKNAS && !timerIsRunning){

				// Show the card
				c.setStatus(Kort.Status.SYNLIGT);

				// Is this the first card to be shown?
				if(Kort.getNumberOfVisibleCards() < 2){
					oldCard = c;
				}

				// Nope, this was the second. Start the timer:
				else{
					activeCard = c;
					timer.start();
					timerIsRunning = true;

					// Have we found two matching cards?
					if(oldCard.sammaBild(activeCard)){

						// Yay! Add a point to the player (and change the window title)
						activePlayer.addPoint();
						//((JFrame) SwingUtilities.getRoot(this)).setTitle(CORRECT_GUESS_TITLE);
					}
					else{
						//((JFrame) SwingUtilities.getRoot(this)).setTitle(INCORRECT_GUESS_TITLE);
					}
				}
			}
		}
	}
	
	
	/**
	*	Listener callback to be called when the timer of the
	*	cards have run out.
	*/
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			
			// Are the cards matching?
			if(oldCard.sammaBild(activeCard)){
				
				// Remove both of the cards from the game
				oldCard.setStatus(Kort.Status.SAKNAS);
				activeCard.setStatus(Kort.Status.SAKNAS);

				correctSound.play();
			}
			else{
				// Turn them back again
				oldCard.setStatus(Kort.Status.DOLT);
				activeCard.setStatus(Kort.Status.DOLT);

				// Set the active player to the other player.
				activePlayer = (activePlayer == player1) ? player2 : player1;
				
				// Remember to set the states in the player models as well:
				player1.toggleActive();
				player2.toggleActive();
				
				failSound.play();
			}
			
			System.out.println("Active cards:" + Kort.getNumberOfActiveCards());
			
			// If all the cards have been removed:
			if(Kort.getNumberOfActiveCards() == 0){
				String winner = (player1.getPoints() > player2.getPoints()) ? player1.getName() : player2.getName();
				
				int choice = JOptionPane.showConfirmDialog(null, winner + " vann!\nVill du spela igen?", "Spelet klart", JOptionPane.YES_NO_OPTION);
				
				if(choice != JOptionPane.OK_OPTION)	
					System.exit(0);
			}
			
			timer.stop();
			timerIsRunning = false;
		}
	}
	
	
}