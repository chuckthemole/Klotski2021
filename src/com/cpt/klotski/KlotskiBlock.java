package com.cpt.klotski;

import java.awt.Point;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

/**
 * 
 * @author Chuck Thomas
 *
 */
public class KlotskiBlock {
	private Rectangle block;
	private String blockType;
	private Point position;
	private static int numberOfBlocks = 0;
	private int blockIdentifier;
	
	/**
	 * 
	 * @param type is the name of the block type
	 * @param p is the block's upper left point
	 */
	KlotskiBlock(String type, Point p) {
		blockType = type;
		position = p;
		blockIdentifier = numberOfBlocks;
		numberOfBlocks++;
		
		switch (type) {
		case "Small Square":
			createBlock((int) p.getX(), (int) p.getY(), 100, 100, Color.BLUE);
			break;
		case "Big Square":
			createBlock((int) p.getX(), (int) p.getY(), 200, 200, Color.DARKRED);
			break;
		case "Vertical Rectangle":
			createBlock((int) p.getX(), (int) p.getY(), 100, 200, Color.RED);
			break;
		case "Horizontal Rectangle":
			createBlock((int) p.getX(), (int) p.getY(), 200, 100, Color.RED);
			break;
		case "Block Mouse":
			createBlock((int) p.getX(), (int) p.getY(), 100, 100, Color.TRANSPARENT);
			break;
		default:
			System.out.println("No such block of type: " + type);				
		}
	}
	
	/**
	 * 
	 * @param type is the name of the block type
	 * @param x is the block's upper left x-coordinate
	 * @param y is the block's upper left y-coordinate
	 */
	KlotskiBlock(String type, int x, int y) {
		blockType = type;
		position = new Point(x, y);
		blockIdentifier = numberOfBlocks;
		numberOfBlocks++;
		
		switch (type) {
		case "Small Square":
			createBlock(x, y, 100, 100, Color.BLUE);
			break;
		case "Big Square":
			createBlock(x, y, 200, 200, Color.DARKRED);
			break;
		case "Vertical Rectangle":
			createBlock(x, y, 100, 200, Color.RED);
			break;
		case "Horizontal Rectangle":
			createBlock(x, y, 200, 100, Color.RED);
			break;
		case "Block Mouse":
			createBlock(x, y, 100, 100, Color.TRANSPARENT);
			break;
		default:
			System.out.println("No such block of type: " + type);				
		}
	}
	
	/**
	 * 
	 * @return the block type
	 */
	public String getBlockType() {
		return blockType;
	}
	
	/**
	 * 
	 * @return the block position
	 */
	public Point getBlockPosition() {
		return position;
	}
	
	/**
	 * 
	 * @return the rectangle of the block
	 */
	public Rectangle getRec() {
		return block;
	}
	
	/**
	 * 
	 * @return the block's unique identifier
	 */
	public int getBlockIdentifier() {
		return blockIdentifier;
	}
	
	private void createBlock(int x, int y, int x_dimension, int y_dimension, Color fillColor) {
		block = new Rectangle(x, y, x_dimension, y_dimension);
	    block.setStroke(Color.BLACK);
	    block.setFill(fillColor);
	}
}
