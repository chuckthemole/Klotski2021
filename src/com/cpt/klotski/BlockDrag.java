package com.cpt.klotski;

import java.awt.Point;
import javafx.scene.shape.Rectangle;
import javafx.scene.Cursor;

/**
 * 
 * @author Chuck
 *
 */
public class BlockDrag {
	static KlotskiBoard currentBoard;
	final int X_AXIS_BORDER_MAX = 400;
	final int Y_AXIS_BORDER_MAX = 500;
	final int X_AXIS_BORDER_MIN = 0;
	final int Y_AXIS_BORDER_MIN = 0;
	final int X_AXIS_LEFT_COLUMN_MAX = 100;
	final int Y_AXIS_TOP_ROW_MAX = 100;
	final int ZERO = 0;

    /**
     * 
     * @param b is a block on the klotskiBoard
     * @param klotskiBoard is the current KlotskiBoard object
     */
    BlockDrag(KlotskiBlock b, KlotskiBoard klotskiBoard, boolean mouseActive) {
        b.getRec().setCursor(Cursor.HAND);
        Point oldPosition = b.getPosition();
        
        b.getRec().setOnMouseDragged(e -> { 
        	currentBoard = klotskiBoard;
        	b.getRec().toFront();
        	final double BLOCKS_X_MAX_POSITION = X_AXIS_BORDER_MAX - b.getRec().getWidth();
        	final double BLOCKS_Y_MAX_POSITION = Y_AXIS_BORDER_MAX - b.getRec().getHeight();
        	final double HALF_BLOCK_WIDTH = b.getRec().getWidth() / 2;
        	final double HALF_BLOCK_HEIGHT = (b.getRec().getHeight() / 2);
        	
        	if (mouseActive) {       	
	        	// Right and left border walls
	        	if (b.getRec().getX() >= BLOCKS_X_MAX_POSITION && e.getX() > BLOCKS_X_MAX_POSITION) {
	        		b.getRec().setX(BLOCKS_X_MAX_POSITION);
	        	}
	        	else if (b.getRec().getX() <= X_AXIS_BORDER_MIN && e.getX() < X_AXIS_LEFT_COLUMN_MAX) {
	        		b.getRec().setX(ZERO);
	        	}
	        	else {
	        		b.getRec().setX(e.getX() - HALF_BLOCK_WIDTH);
	        	}
	        	
	        	// Top and bottom border walls
	        	if (b.getRec().getY() >= BLOCKS_Y_MAX_POSITION && e.getY() > BLOCKS_Y_MAX_POSITION) {
	        		b.getRec().setY(BLOCKS_Y_MAX_POSITION);
	        	}
	        	else if (b.getRec().getY() <= Y_AXIS_BORDER_MIN && e.getY() < Y_AXIS_TOP_ROW_MAX) {
	        		b.getRec().setY(ZERO);
	        	}
	        	else {
	        		b.getRec().setY(e.getY() - HALF_BLOCK_HEIGHT);  
	        	}
        	}
        	e.consume();
        });
        
        b.getRec().setOnMouseReleased(e -> {
        	double x = b.getPosition().getX();
        	double y = b.getPosition().getY();
        	
        	klotskiBoard.setBlockPosition(b, new Point((int) x, (int) y));
        	b.getRec().toBack();
        });
    }
    
    private boolean checkCollision(KlotskiBlock block) {   
    	boolean collision = true;
    	
        for (KlotskiBlock b : currentBoard.getBlocks()) {
            // If one block is on the left side of the other block
            if (block.getBlockPosition().getX() > b.getBlockPosition().getX() + b.getWidth() ||
            		b.getBlockPosition().getX() > block.getBlockPosition().getX() + block.getWidth()) {
            	collision = false;
            }  
            else {
            	return true;
            }
            // If one block is above the other block
            if (block.getBlockPosition().getY() > b.getBlockPosition().getY() + b.getHeight() ||
            		b.getBlockPosition().getY() > block.getBlockPosition().getY() + block.getHeight()) {
            	collision = false;
            }
            else {
            	return true;
            }
        }
        return collision;
    }
}