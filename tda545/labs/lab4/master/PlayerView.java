import javax.swing.*;
import java.awt.*;
import java.util.*;

/** 
*	The visual representations of player object.
*
*	@author Johan Brook (900720-0216), Robin Andersson (900122-0574)
*	@group 0
*	@assignment Lab 4
*	@date 2011-10-11
*/
public class PlayerView extends JPanel implements Observer {
	
	// Instance variables
	
	private Player player;
	private JLabel pointsLabel;
	
	/**
	*	Creates a new player view, based on a Player
	*
	*	@param player A valid player object
	*/
	public PlayerView(Player player){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.player = player;
		this.pointsLabel = new JLabel(Integer.toString(player.getPoints()));
		
		Font playerFont = new Font("Helvetica", Font.BOLD, 14);
		Font pointsFont = new Font("Helvetica", Font.BOLD, 30);
		
		JLabel name = new JLabel(player.getName());
		
		name.setFont(playerFont);
		pointsLabel.setFont(pointsFont);
		
		add(name);
		// An empty box to create space between the player's name and points
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(pointsLabel);
		
		name.setAlignmentX(Component.CENTER_ALIGNMENT);
		pointsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		setVisible(true);
	}
	
	/**
	*	Updates the player-specific view when a player instance is changed.
	*
	*	The <code>arg</code> argument is not used.
	*/
	public void update(Observable p, Object arg){
		if(p instanceof Player){
			Player active = (Player) p;
			pointsLabel.setText(Integer.toString(active.getPoints()));
			
			if(player.isActive()){
				setBackground(Color.YELLOW);
			}
			else{
				setBackground(null);
			}
		}
	}
}