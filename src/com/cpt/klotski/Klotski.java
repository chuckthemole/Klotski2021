package com.cpt.klotski;

import com.sun.javafx.geom.Vec2d;


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
	private static KlotskiBoard mainBoard;
	private Scene scene;
    private BlockDrag[] blockDrag;
    private static boolean mouseActive;
	
    @Override
    public void start(Stage s) throws Exception{
        System.out.print("Start called...");
        enableMouse();
    	//playMusic(musicPath);
        buildStage(s); 
        addListeners();
    }
    
    private static void playMusic(String s) {
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
    
    private void buildStage(Stage stage) {
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
    	scene = new Scene(root);
        scene.setFill(Paint.valueOf("Black"));
        stage.setOnCloseRequest(e -> System.exit(0));       
        stage.setTitle("Klotski");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.sizeToScene();
        stage.show(); 
    }

    private void addListeners() {
    	blockDrag = new BlockDrag[10];
    	int i;
        for (i = 9; i >= 0; i--) {
            blockDrag[i] = new BlockDrag(mainBoard.getBlocks()[i], mainBoard, mouseActive); 
        }  
    }
    
    public boolean isMouseActive() {
    	return mouseActive;
    }
    
    public void disableMouse() {
    	mouseActive = false;
    }
    
    public void enableMouse() {
    	mouseActive = true;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
