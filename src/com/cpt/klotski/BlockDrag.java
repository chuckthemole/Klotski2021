package com.cpt.klotski;
/**
 * Program name:    MouseDrag.java
 * Discussion:      Final
 * Written by:      Charles T
 * Due Date:        
 */

import java.awt.Point;
import javafx.scene.shape.Rectangle;
import javafx.scene.Cursor;

/**
 * 
 * @author Chuck
 *
 */
public class BlockDrag {
	private KlotskiBlock block;
   
    /**
     * 
     * @param b is a block on the klotskiBoard
     * @param klotskiBoard is the current KlotskiBoard object
     */
    BlockDrag(KlotskiBlock b, KlotskiBoard klotskiBoard, boolean mouseActive) {
    	block = b;
    	Rectangle currentBlock = b.getRec();
    	
        b.getRec().setCursor(Cursor.HAND);
        
    	/*
    	 * Sets the current block to the mouse's position
    	 * Allows player to drag the game objects
    	 */
        b.getRec().setOnMouseDragged(e -> {     	
        	currentBlock.toFront();
        	double blockXBorder = 400 - b.getRec().getWidth();
        	double blockYBorder = 500 - b.getRec().getHeight();
        	
        	if (mouseActive) {       	
	        	// Right and left border walls
	        	if (currentBlock.getX() >= blockXBorder && e.getX() > blockXBorder) {
	        		currentBlock.setX(blockXBorder);
	        	}
	        	else if (currentBlock.getX() <= 0 && e.getX() < 100) {
	        		currentBlock.setX(0);
	        	}
	        	else 
	        		currentBlock.setX(e.getX() - (currentBlock.getWidth() / 2));
	        	
	        	// Top and bottom border walls
	        	if (currentBlock.getY() >= blockYBorder && e.getY() > blockYBorder) {
	        		currentBlock.setY(blockYBorder);
	        	}
	        	else if (currentBlock.getY() <= 0 && e.getY() < 100) {
	        		currentBlock.setY(0);
	        	}
	        	else 
	        		currentBlock.setY(e.getY() - (currentBlock.getHeight() / 2));  
        	}
        	e.consume();
        });
        
        /*
         * When mouse is released on a game object, check to make sure the space is available.
         */
        b.getRec().setOnMouseReleased(e -> {
        	//Rectangle currentBlock = b.getRec();
        	double x = currentBlock.getX();
        	double y = currentBlock.getY();
        	
        	klotskiBoard.setBlockPosition(block, new Point((int) x, (int) y));
        	currentBlock.toBack();
        });
    }
    
    public KlotskiBlock getBlock() {
    	return block;
    }
}