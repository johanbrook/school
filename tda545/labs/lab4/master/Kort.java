import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/** 
*	A memory card.
*
*	@author Johan Brook (900720-0216), Robin Andersson (900122-0574)
*	@group 0
*	@assignment Lab 4
*	@date 2011-10-11

	Fråga om: 
			
		- Hur kommenterar man enum. Vad kallas för enum och vad kallas "elementen" inuti?
		- Varför funkar det inte med repaint()? Vi måste även ha revailidate()
		- Är det okay att ha "Nytt spel" och "Avsluta"-knapparna igång när timern går?
	
*/
public class Kort extends JButton {
	
	private final int CARD_SIDE = 50;

    // Instance variables
    private Icon bild;
	private Status status;
    
	/**
	*	An <code>enum</code> representing the card's "in game visibility".
	*
	*	<code>DOLT</code> represents hidden mode, <code>SYNLIGT</code>
	*	represents visible mode, and <code>SAKNAS</code> is a removed card.
	*/
    public enum Status {DOLT, SYNLIGT, SAKNAS}


    // Constructors
	
	/**
	*	Creates a new card.
	*	
	*	@param icon The image of the card
	*/
    public Kort(Icon icon){
		this(icon, Status.SAKNAS);
    }

	/**
	*	Creates a new card with a status
	*
	*	@param icon The image of the card
	*	@param status An <code>enum</code> representing the card's "in game visibility" 
	*/
    public Kort(Icon icon, Status status){
		setIcon(icon);
		this.bild = icon;
		setStatus(status);
		
		setOpaque(true);
		setBorder(new EmptyBorder(0,0,0,0));
		
		// Assign a nice hand cursor to the cards:
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		setPreferredSize(new Dimension(CARD_SIDE, CARD_SIDE));
    }


    // Public methods

	/**
	*	Sets the status (visibility/state) for this card.
	*
	*	@param status An <code>enum</code> representing the card's "in game visibility"
	*/
    public void setStatus(Status status){
		this.status = status;
		
			switch(this.status){
				case SAKNAS:	setBackground(Color.WHITE); 
								setIcon(null); 
								break;

				case DOLT:		setBackground(Color.BLUE); 
								setIcon(null); 
								break;

				case SYNLIGT:	setIcon(this.bild);
								break;
			}
		
	}

	/**
	*	Returns the <code>enum</code> representing the card's "in game visibility"
	*
	*	@return The status
	*/
    public Status getStatus(){
		return this.status;
    }

	/**
	*	Create a carbon copy of this card, with the same
	*	image and status.
	*
	*	@return A new <code>Kort</code> object with the same image and status references
	*/
    public Kort copy(){
		return new Kort(this.bild, this.status);
    }

	/**
	*	Compares this card to another <code>Kort</code> and returns
	*	true if their images are the same.
	*
	*	@param card The <code>Kort</code> object to compare with
	*/
    public boolean sammaBild(Kort card){
		return getIcon() == card.getIcon();
    }

	/**
	*	Returns the path to this card's image (used for testing).
	*
	*	@return The path name
	*/
	public String toString(){
		return this.bild.toString();
	}
	
}
