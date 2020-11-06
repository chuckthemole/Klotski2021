package com.cpt.klotski;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * 
 * @author Chuck
 *
 */
public class Klotski extends Application {
	private final String musicPath = "//Music//song2.MP3";
	private static KlotskiBoard mainBoard = new KlotskiBoard();
	
    @Override
    public void start(Stage s) throws Exception{
        System.out.print("Start called...");
    	//playMusic(musicPath);
        buildStage();          
    }
    
    public static void playMusic(String s) {
    	if (OperatingSystem.isWindows()) {
    		s.replace('/', '\\');
    	}
    	try {
	    	PlayMusic.playMusic(s);
    	}
    	catch(Exception e) {
    		System.out.print(e);
    	}
    }
    
    public static void buildStage() {
    	Stage stage = new Stage();
        Pane blocksPane = new Pane();

    	mainBoard = new KlotskiBoard();
    	for (KlotskiBlock block : mainBoard.getBlocks()) {
    		blocksPane.getChildren().add(block.getRec());
    	}
        
        Pane mainPane = new Pane();
        final String cssDefault = "-fx-border-color: blue;\n" + "-fx-border-width: 20;\n";
        mainPane.setStyle(cssDefault);
        mainPane.getChildren().add(blocksPane);
        blocksPane.setLayoutX(40);
        blocksPane.setLayoutY(40);
        
    	Group root = new Group(mainPane);
    	Scene scene = new Scene(root);
        scene.setFill(Paint.valueOf("Black"));
        stage.setOnCloseRequest(e -> System.exit(0));       
        stage.setTitle("Klotski");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.sizeToScene();
        stage.show(); 
    }

    public static void main(String[] args) {
        launch(args);
    }
}
