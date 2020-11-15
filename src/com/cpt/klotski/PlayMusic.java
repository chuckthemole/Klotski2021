package com.cpt.klotski;

//import java.io.FileInputStream;
import java.io.File;
import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer;  
//import java.io.InputStream;

//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;

/**
 * Audio file formats: AIFF, AU and WAV
 * 
 * @author chuck
 *
 */
public class PlayMusic {
	private static Media hit;
	private static MediaPlayer mediaPlayer;
	private static Media slide = initBlockSlide();
	private static MediaPlayer mp = new MediaPlayer(slide);
	private static boolean musicIsPlaying;
	
	public static void playMusic(String filePath) {
		try {
			musicIsPlaying = true;
			hit = new Media(new File(filePath).toURI().toString());
			mediaPlayer = new MediaPlayer(hit);
			mediaPlayer.play();
			System.out.println("Playing Music...");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error playing music!");
		}
	}
	
	public static Media initBlockSlide() {
		if (OperatingSystem.isMac() || OperatingSystem.isUnix()) {
			return new Media(new File("Music//slide.MP3").toURI().toString());
		}
		if (OperatingSystem.isWindows()) {
			return new Media(new File("Music\\slide.MP3").toURI().toString());
			
		}
		else return null;
	}
	
	public static void stop() {
		try {
			mediaPlayer.stop();
			System.out.println("Music Stopped....");
			musicIsPlaying = false;
		}
		catch(Exception e) {
			System.out.println(e);
		}	
	}
	
	public static void play() {
		try {
			mediaPlayer.play();
			System.out.println("Music Started....");
			musicIsPlaying = true;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Can't Stop Music");
		}
	}
	
	public static void playSlide() {
		System.out.println("Block Sliding...");
		mp.play();
	}
	
	public static void stopSlide() {
		mp.stop();
	}
	
	public static boolean getMusicIsPlaying() {
		return musicIsPlaying;
	}
}
