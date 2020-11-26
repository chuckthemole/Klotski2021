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
	private int width;
	private int height;
	private int blockColumn;
	private int blockRow;
	private final int DIVISOR_ROWS_COLUMNS = 100;
	
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

		blockColumn = (int) p.getX() / DIVISOR_ROWS_COLUMNS;
		blockRow = (int) p.getY() / DIVISOR_ROWS_COLUMNS;
		
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
		
		blockColumn = x / DIVISOR_ROWS_COLUMNS;
		blockRow = y / DIVISOR_ROWS_COLUMNS;
		
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
	 * @return width of block
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * 
	 * @return height of block
	 */
	public int getHeight() {
		return height;
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
	
	/**
	 * 
	 * @return the block position
	 */
	public Point getPosition() {
		return position;
	}
	
	/**
	 * 
	 * @return the block's previous position
	 */
	public Point getPreviousPosition() {
		return position;
	}
	
	/**
	 * 
	 * @return block's column
	 */
	public int getBlockColumn() {
		return blockColumn;
	}
	
	/**
	 * 
	 * @return block's row
	 */
	public int getRowColumn() {
		return blockRow;
	}
	
	/**
	 * 
	 * @param p the point for block to be set
	 */
	public void setPosition(Point p) {
		position = p;
		block.setX(p.getX());
		block.setY(p.getY());
	}
	
	/**
	 * 
	 * @param x the x-coordinate for block to be set
	 * @param y the y-coordinate for block to be set
	 */
	public void setPosition(int x, int y) {
		position = new Point(x, y);
		block.setX(x);
		block.setY(y);
	}
	
	/**
	 * 
	 * @param p the point for block's previous position to be set
	 */
	public void setPreviousPosition(Point p) {
		position = p;
		block.setX(p.getX());
		block.setY(p.getY());
	}
	
	/**
	 * 
	 * @param x the x-coordinate for block's previous position to be set
	 * @param y the y-coordinate for block's previous position to be set
	 */
	public void setPreviousPosition(int x, int y) {
		position = new Point(x, y);
		this.getRec().setX(x);
		this.getRec().setY(y);
	}
	
	/**
	 * 
	 * @param x the x-coordinate for block to be set
	 */
	public void setX(int x) {
		position = new Point(x, (int) position.getY());
		this.getRec().setX(x);
	}
	
	/**
	 * 
	 * @param x the x-coordinate for block to be set
	 */
	public void setY(int y) {
		position = new Point((int) position.getX(), y);
		this.getRec().setY(y);
	}
	
	/**
	 * 
	 * @param column is the value to set blockColumn
	 */
	public void setBlockColumn(int column) {
		blockColumn = column;
	}
	
	/**
	 * 
	 * @param row is the value to set blockRow
	 */
	public void setBlockRow(int row) {
		blockRow = row;
	}
	
	/**
	 * 
	 * @param n is the int to set numberOfBlocks
	 */
	public static void setNumberOfBlocks(int n) {
		numberOfBlocks = n;
	}
	
	private void createBlock(int x, int y, int x_dimension, int y_dimension, Color fillColor) {
		block = new Rectangle(x, y, x_dimension, y_dimension);
	    block.setStroke(Color.BLACK);
	    block.setFill(fillColor);
	    height = y_dimension;
	    width = x_dimension;	   
	}
}
