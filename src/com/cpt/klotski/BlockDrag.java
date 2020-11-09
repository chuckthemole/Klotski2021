package com.cpt.klotski;

import java.awt.Point;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Point2D;
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
	
	final int RIGHT_WALL = 400;
	final int LEFT_WALL = 0;
	final int BOTTOM_WALL = 500;
	final int TOP_WALL = 0;
	
	private int x;
	private int y;
	

    /**
     * 
     * @param b is a block on the klotskiBoard
     * @param klotskiBoard is the current KlotskiBoard object
     */
    BlockDrag(KlotskiBlock b, KlotskiBoard klotskiBoard, boolean mouseActive) {
    	x = 1;
    	y = 1;
        b.getRec().setCursor(Cursor.HAND);
        Point oldPosition = b.getPosition();
        
        b.getRec().xProperty().addListener((Observable, oldValue, newValue) -> {
            System.out.println("X position changed from <" + oldValue + "> to <" + newValue + ">");
            x = oldValue.intValue();
        });
        
        b.getRec().yProperty().addListener((Observable, oldValue, newValue) -> {
            System.out.println("Y position changed from <" + oldValue + "> to <" + newValue + ">");
            y = oldValue.intValue();
        });
        
        b.getRec().setOnMouseDragged(e -> { 
        	currentBoard = klotskiBoard;
        	b.getRec().toFront();
        	
            Rectangle bound = new Rectangle(400,500);
        	
        	if (mouseActive) {  
        		Point2D currentPointer = new Point2D(e.getX(), e.getY());

	            if (x >= 0 && x + b.getWidth() < bound.getWidth()){
	                b.getRec().setX(currentPointer.getX() - b.getWidth() / 2);
	            }
                    
                if (y >= 0 && x + b.getHeight() <= bound.getHeight()){
                    b.getRec().setY(currentPointer.getY() - b.getHeight() / 2);
                }

        	}
        	e.consume();
        });
        
        b.getRec().setOnMouseReleased(e -> {
        	klotskiBoard.setBlockPosition(b, new Point((int) b.getPosition().getX(), (int) b.getPosition().getY()));
        	x = (int) b.getPosition().getX();
        	y = (int) b.getPosition().getY();
        	b.getRec().toBack();
        });
    }
    
    public void setX(int value) {
    	x = value;
    }
    
    public void setY(int value) {
    	y = value;
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