/** 
*	A memory card
*
*	@author Johan Brook (900720-0216), Robin Andersson (900122-0574)
*	@group 0
*	@assignment Lab 4
*	@date 2011-10-03
*	@note 
*/

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Kort extends JButton {
    
	private static int numberOfVisibleCards = 0;
	private static int numberOfActiveCards;
	
	private final int CARD_SIDE = 50;

    // Instance variables
    private Icon bild;
	private Status status;
    
	// State
    public enum Status {DOLT, SYNLIGT, SAKNAS}

    // Constructors
	
	/**
	*	Creates a new card
	*	
	*	@param icon The image of the card
	*/
    public Kort(Icon icon){
		this(icon, Status.DOLT);
    }

	/**
	*	Creates a new card with a status
	*
	*	@param icon The image of the card
	*	@param status A status
	*/
    public Kort(Icon icon, Status status){
		setIcon(icon);
		this.bild = icon;
		setStatus(status);
		
		setOpaque(true);
		setBorder(new EmptyBorder(0,0,0,0));
		
		numberOfActiveCards++;
		
		// Assign a nice hand cursor to the cards:
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		setPreferredSize(new Dimension(CARD_SIDE, CARD_SIDE));
    }
    

    // Public methods

	/**
	*	Set the status (visibility, state) for this card.
	*/
    public void setStatus(Status status){
		this.status = status;
		
		switch(this.status){
			case SAKNAS:	setBackground(Color.WHITE); 
							setIcon(null); 
							numberOfVisibleCards = 0;
							numberOfActiveCards--;
							break;
							
			case DOLT:		setBackground(Color.BLUE); 
							setIcon(null); 
							numberOfVisibleCards = 0;
							break;
							
			case SYNLIGT:	setIcon(this.bild);
							numberOfVisibleCards++;
							break;
		}
		
	}

	/**
	*	Return status
	*/
    public Status getStatus(){
		return this.status;
    }

	/**
	*	Create a carbon copy of this card, with the same
	*	image and status.
	*/
    public Kort copy(){
		return new Kort(this.bild, this.status);
    }

	/**
	*	Compares this card to another Kort and returns
	*	'true' if their icons are the same.
	*/
    public boolean sammaBild(Kort card){
		return getIcon() == card.getIcon();
    }

	/**
	*	Returns the path to this card's image.
	*/
	public String toString(){
		return this.bild.toString();
	}


	
	// Class methods
	
	/**
	*	Returns the number of visible cards.
	*/
	public static int getNumberOfVisibleCards(){
		return numberOfVisibleCards;
	}
	
	public static int getNumberOfActiveCards(){
		return numberOfActiveCards;
	}

}
