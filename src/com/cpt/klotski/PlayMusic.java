package com.cpt.klotski;

//import java.io.FileInputStream;
import java.io.File;
//import java.io.InputStream;

//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
	
	public static void playMusic(String filePath) {
		try {
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
	
		}
		catch(Exception e) {
			System.out.println(e);
		}	
	}
	
	public static void play() {
		try {
		mediaPlayer.play();
		System.out.println("Music Started....");
	
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
}
