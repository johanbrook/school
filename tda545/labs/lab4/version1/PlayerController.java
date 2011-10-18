/** 
*	The player controller (deprecated)
*
*	@author Johan Brook (900720-0216), Robin Andersson (900122-0574)
*	@group 0
*	@assignment Lab 4
*	@date 2011-10-03
*/

import javax.swing.*;
import java.awt.*;
import java.util.*;

class PlayerController extends JPanel implements Observer {
	
	private JPanel player1Pane;
	private JPanel player2Pane;
	
	private final int WIDTH = 120;
	
	/**
	*	Create a new player controller
	*
	*	@deprecated Replaced by several PlayerViews
	*/
	public PlayerController(Player player1, Player player2){

		setLayout(new GridLayout(2, 1));
		
		Font playerFont = new Font("Helvetica", Font.BOLD, 14);
		
		player1Pane = new JPanel(new BorderLayout());
		player2Pane = new JPanel(new BorderLayout());
		
		JLabel p1Label = new JLabel(player1.getName());
		JLabel p2Label = new JLabel(player2.getName());
		
		p1Label.setFont(playerFont);
		p2Label.setFont(playerFont);
		
		player1Pane.add(p1Label, BorderLayout.NORTH);
		player2Pane.add(p2Label, BorderLayout.NORTH);
		
		player1Pane.setBackground(Color.YELLOW);
		
		add(player1Pane, BorderLayout.NORTH);
		add(player2Pane, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public void update(Observable p, Object args){
		if(p instanceof Player){
			Player player = (Player) p;
			System.out.println(player.getPoints());
		}
	}
	
}