import java.applet.*;
import java.net.*;

/** 
*	Sound class.
*
*	@author Johan Brook (900720-0216), Robin Andersson (900122-0574)
*	@group 0
*	@assignment Lab 4
*	@date 2011-10-11
*/
public class Sound {
	
	// Instance variable
	
  	private AudioClip song;
 	
	/**
	*	Creates a new sound to play.
	*
	*	@param filename The path to the sound file
	*/
	public Sound(String filename){
		
		try{
			URL songPath = Sound.class.getResource(filename);
			song = Applet.newAudioClip(songPath);
		}
		catch(Exception e){
			System.out.println("Sound file couldn't be found or opened");
		}
	}
	
	/**
	*	Plays the sound.
	*
	*	Does nothing if the sound file couldn't be found.
	*/
	public void play(){
		if(song != null){
			song.play();
		}
	}
}
