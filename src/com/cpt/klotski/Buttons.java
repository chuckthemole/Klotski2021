package com.cpt.klotski;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Buttons extends Klotski {
    HBox hbox;
    Button restart;
    Button solve;
    Button quit; 
    Button undo;
    Button music;

    Buttons() {     
    	hbox = new HBox();
    	restart = new Button("Restart");
    	solve = new Button("Solve");
        quit = new Button("Quit"); 
        undo = new Button("Undo");
        music = new Button("Music");
    	
        // Set up HBox style
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(0, 20, 10, 20));
        //hbox.getChildren().addAll(restart, solve, quit, undo);
        hbox.getChildren().add(restart);
        hbox.getChildren().add(solve);
        hbox.getChildren().add(quit);
        hbox.getChildren().add(undo);
        hbox.getChildren().add(music);

        hbox.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 2;" +
                      "-fx-border-insets: 5;" + 
                      "-fx-border-radius: 5;" + 
                      "-fx-border-color: blue;");
       
        hbox.setLayoutX(50);
        hbox.setLayoutY(550);
        
        music.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
            	music();
            }
        });
        
        quit.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
            	quit();
            }
        });
        
        solve.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	solve();
            }
        });
        
        restart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	restart();    
            }
        });
        
        undo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	undo();
            }
        });
    }
    
    public HBox getHBox() {
        return hbox;
    }
    
    public Button getRestart() {
        return restart;
    }
    
    public Button getUndo() {
        return undo;
    }
    
    public Button getSolve() {
        return solve;
    }
    
    public Button getQuit() {
        return quit;
    }
}