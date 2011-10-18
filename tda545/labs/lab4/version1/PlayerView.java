/** 
*	The view of a single player.
*
*	@author Johan Brook (900720-0216), Robin Andersson (900122-0574)
*	@group 0
*	@assignment Lab 4
*	@date 2011-10-03
*/

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PlayerView extends JPanel implements Observer {
	
	private Player player;
	private JLabel points;
	
	/**
	*	Create a new player view, based on a Player
	*
	*	@param player A valid player object.
	*/
	public PlayerView(Player player){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.player = player;
		this.points = new JLabel(Integer.toString(player.getPoints()));
		
		Font playerFont = new Font("Helvetica", Font.BOLD, 14);
		Font pointsFont = new Font("Helvetica", Font.BOLD, 30);
		
		JLabel name = new JLabel(player.getName());
		
		name.setFont(playerFont);
		points.setFont(pointsFont);
		
		add(name);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(points);
		
		name.setAlignmentX(Component.CENTER_ALIGNMENT);
		points.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		setVisible(true);
	}
	
	public void update(Observable p, Object args){
		if(p instanceof Player){
			Player active = (Player) p;
			
			points.setText(Integer.toString(active.getPoints()));
			
			System.out.println(player.isActive());
			
			if(player.isActive()){
				setBackground(Color.YELLOW);
			}
			else{
				setBackground(null);
			}
		}
	}
}