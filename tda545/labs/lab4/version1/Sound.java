/** 
*	Sound class.
*
*	@author Johan Brook (900720-0216), Robin Andersson (900122-0574)
*	@group 0
*	@assignment Lab 4
*	@date 2011-10-03
*/

import java.applet.*;
import java.net.*;

public class Sound {
  	private AudioClip song;
	private URL songPath;
 	
	/**
	*	Create a new sound to play.
	*
	*	@param filename The path to the sound file
	*/
	public Sound(String filename){
		try{
			songPath = Sound.class.getResource(filename);
			song = Applet.newAudioClip(songPath);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	/**
	*	Plays the sound
	*/
	public void play(){
		song.play();
	}
}
