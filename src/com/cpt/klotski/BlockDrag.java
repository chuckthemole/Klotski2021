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
    	Rectangle currentBlock = b.getRec();
        b.getRec().setCursor(Cursor.HAND);
        
        b.getRec().setOnMouseDragged(e -> {     	
        	currentBlock.toFront();
        	final double BLOCKS_X_MAX_POSITION = X_AXIS_BORDER_MAX - b.getRec().getWidth();
        	final double BLOCKS_Y_MAX_POSITION = Y_AXIS_BORDER_MAX - b.getRec().getHeight();
        	final double HALF_BLOCK_WIDTH = currentBlock.getWidth() / 2;
        	final double HALF_BLOCK_HEIGHT = (currentBlock.getHeight() / 2);
        	
        	if (mouseActive) {       	
	        	// Right and left border walls
	        	if (currentBlock.getX() >= BLOCKS_X_MAX_POSITION && e.getX() > BLOCKS_X_MAX_POSITION) {
	        		currentBlock.setX(BLOCKS_X_MAX_POSITION);
	        	}
	        	else if (currentBlock.getX() <= X_AXIS_BORDER_MIN && e.getX() < X_AXIS_LEFT_COLUMN_MAX) {
	        		currentBlock.setX(ZERO);
	        	}
	        	else {
	        		currentBlock.setX(e.getX() - HALF_BLOCK_WIDTH);
	        	}
	        	
	        	// Top and bottom border walls
	        	if (currentBlock.getY() >= BLOCKS_Y_MAX_POSITION && e.getY() > BLOCKS_Y_MAX_POSITION) {
	        		currentBlock.setY(BLOCKS_Y_MAX_POSITION);
	        	}
	        	else if (currentBlock.getY() <= Y_AXIS_BORDER_MIN && e.getY() < Y_AXIS_TOP_ROW_MAX) {
	        		currentBlock.setY(ZERO);
	        	}
	        	else {
	        		currentBlock.setY(e.getY() - HALF_BLOCK_HEIGHT);  
	        	}
        	}
        	e.consume();
        });
        
        b.getRec().setOnMouseReleased(e -> {
        	double x = currentBlock.getX();
        	double y = currentBlock.getY();
        	
        	klotskiBoard.setBlockPosition(b, new Point((int) x, (int) y)); // check move is legal
        	currentBlock.toBack();
        });
    }
}