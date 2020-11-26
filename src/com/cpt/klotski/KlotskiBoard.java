package com.cpt.klotski;

import java.awt.Point;

/**
 * 
 * @author Chuck
 *
 */
public class KlotskiBoard {      
    private static KlotskiBlock[] blocks;
    private static int[][] blockPositions;
    private static Point[][] boardPoints;
    private UndoStack undoStack;
    
    private final int ROWS = 5;
    private final int COLUMNS = 4;
    
    private static final int NUMBER_OF_BLOCKS = 10;
    private static final int SMALL_SQUARE_1 = 0;
    private static final int SMALL_SQUARE_2 = 1;
    private static final int SMALL_SQUARE_3 = 2;
    private static final int SMALL_SQUARE_4 = 3;
    private static final int VERTICAL_BLOCK_1 = 4;
    private static final int VERTICAL_BLOCK_2 = 5;
    private static final int VERTICAL_BLOCK_3 = 6;
    private static final int VERTICAL_BLOCK_4 = 7;
    private static final int HORIZONTAL_BLOCK = 8;
    private static final int BIG_SQUARE = 9;
    
    private final int ROW_ONE = 0;
    private final int ROW_TWO = 100;
    private final int ROW_THREE = 200;
    private final int ROW_FOUR = 300;
    private final int ROW_FIVE = 400;
    private final int COLUMN_ONE = 0;
    private final int COLUMN_TWO = 100;
    private final int COLUMN_THREE = 200;
    private final int COLUMN_FOUR = 300;
    
    private final int EMPTY_SPACE = -1;

    KlotskiBoard() {
        blocks = new KlotskiBlock[NUMBER_OF_BLOCKS];
        KlotskiBlock.setNumberOfBlocks(0);
        blocks[SMALL_SQUARE_1] = new KlotskiBlock("Small Square", COLUMN_FOUR, ROW_FIVE);  
        blocks[SMALL_SQUARE_2] = new KlotskiBlock("Small Square", COLUMN_TWO, ROW_FOUR);
        blocks[SMALL_SQUARE_3] = new KlotskiBlock("Small Square", COLUMN_THREE, ROW_FOUR);
        blocks[SMALL_SQUARE_4] = new KlotskiBlock("Small Square", COLUMN_ONE, ROW_FIVE);
        blocks[VERTICAL_BLOCK_1] = new KlotskiBlock("Vertical Rectangle", COLUMN_ONE, ROW_ONE);          
        blocks[VERTICAL_BLOCK_2] = new KlotskiBlock("Vertical Rectangle", COLUMN_ONE, ROW_THREE);         
        blocks[VERTICAL_BLOCK_3] = new KlotskiBlock("Vertical Rectangle", COLUMN_FOUR, ROW_ONE);       
        blocks[VERTICAL_BLOCK_4] = new KlotskiBlock("Vertical Rectangle", COLUMN_FOUR, ROW_THREE);      
        blocks[HORIZONTAL_BLOCK] = new KlotskiBlock("Horizontal Rectangle", COLUMN_TWO, ROW_THREE); 
        blocks[BIG_SQUARE] = new KlotskiBlock("Big Square", COLUMN_TWO, ROW_ONE); 
        
        blockPositions = new int[COLUMNS][ROWS];
        blockPositions[COLUMN_FOUR / 100][ROW_FIVE / 100] = blocks[SMALL_SQUARE_1].getBlockIdentifier();
        blockPositions[COLUMN_TWO / 100][ROW_FOUR / 100] = blocks[SMALL_SQUARE_2].getBlockIdentifier();
        blockPositions[COLUMN_THREE / 100][ROW_FOUR / 100] = blocks[SMALL_SQUARE_3].getBlockIdentifier();
        blockPositions[COLUMN_ONE / 100][ROW_FIVE / 100] = blocks[SMALL_SQUARE_4].getBlockIdentifier();
        blockPositions[COLUMN_ONE / 100][ROW_ONE / 100] = blocks[VERTICAL_BLOCK_1].getBlockIdentifier();
        blockPositions[COLUMN_ONE / 100][ROW_TWO / 100] = blocks[VERTICAL_BLOCK_1].getBlockIdentifier();
        blockPositions[COLUMN_ONE / 100][ROW_THREE / 100] = blocks[VERTICAL_BLOCK_2].getBlockIdentifier();
        blockPositions[COLUMN_ONE / 100][ROW_FOUR / 100] = blocks[VERTICAL_BLOCK_2].getBlockIdentifier();
        blockPositions[COLUMN_FOUR / 100][ROW_ONE / 100] = blocks[VERTICAL_BLOCK_3].getBlockIdentifier();
        blockPositions[COLUMN_FOUR / 100][ROW_TWO / 100] = blocks[VERTICAL_BLOCK_3].getBlockIdentifier();
        blockPositions[COLUMN_FOUR / 100][ROW_THREE / 100] = blocks[VERTICAL_BLOCK_4].getBlockIdentifier();
        blockPositions[COLUMN_FOUR / 100][ROW_FOUR / 100] = blocks[VERTICAL_BLOCK_4].getBlockIdentifier();
        blockPositions[COLUMN_TWO / 100][ROW_THREE / 100] = blocks[HORIZONTAL_BLOCK].getBlockIdentifier();
        blockPositions[COLUMN_THREE / 100][ROW_THREE / 100] = blocks[HORIZONTAL_BLOCK].getBlockIdentifier();
        blockPositions[COLUMN_TWO / 100][ROW_ONE / 100] = blocks[BIG_SQUARE].getBlockIdentifier();
        blockPositions[COLUMN_TWO / 100][ROW_TWO / 100] = blocks[BIG_SQUARE].getBlockIdentifier();
        blockPositions[COLUMN_THREE / 100][ROW_ONE / 100] = blocks[BIG_SQUARE].getBlockIdentifier();
        blockPositions[COLUMN_THREE / 100][ROW_TWO / 100] = blocks[BIG_SQUARE].getBlockIdentifier();
        blockPositions[COLUMN_TWO / 100][ROW_FIVE / 100] = EMPTY_SPACE;
        blockPositions[COLUMN_THREE / 100][ROW_FIVE / 100] = EMPTY_SPACE;
        
        
        
        boardPoints = new Point[4][5];
        boardPoints[0][0] = new Point(0, 0);
        boardPoints[0][1] = new Point(0, 100);
        boardPoints[0][2] = new Point(0, 200);
        boardPoints[0][3] = new Point(0, 300);
        boardPoints[0][4] = new Point(0, 400);
        boardPoints[1][0] = new Point(100, 0);
        boardPoints[1][1] = new Point(100, 100);
        boardPoints[1][2] = new Point(100, 200);
        boardPoints[1][3] = new Point(100, 300);
        boardPoints[1][4] = new Point(100, 400);      
        boardPoints[2][0] = new Point(200, 0);
        boardPoints[2][1] = new Point(200, 100);
        boardPoints[2][2] = new Point(200, 200);
        boardPoints[2][3] = new Point(200, 300);
        boardPoints[2][4] = new Point(200, 400);        
        boardPoints[3][0] = new Point(300, 0);
        boardPoints[3][1] = new Point(300, 100);
        boardPoints[3][2] = new Point(300, 200);
        boardPoints[3][3] = new Point(300, 300);
        boardPoints[3][4] = new Point(300, 400);
    }
    
    /**
     * Undo previous move
     */
    public void undo() {
    	try {
    		// TO DO get from other project
    	}
    	catch (Exception e) {
    		System.out.println("Stack is empty..." + e);
    	}
    }
    
    /**
     * 
     * @return the stack containing undo moves
     */
    public UndoStack getUndoStack() {
    	return undoStack;
    }
    
    /**
     * 
     * @return the array of blocks
     */
    public KlotskiBlock[] getBlocks() {
    	return blocks;
    }
    
    /**
     * 
     * @return 2d array of each block's position on board
     */
    public int[][] getBlockPositions() {
    	return blockPositions;
    }
    
    /**
     * 
     * @return 2d array of each board position
     */
    public Point[][] getBoardPoints() {
    	return boardPoints;
    }
    
    /**
     * Moves a Klotski Block, b, to a position, p, if the move is a legal move. 
     * 
     * @param b block to have position set
     * @param p point to set the block
     * @return
     */
    public int setBlockPosition(KlotskiBlock b, Point p) {
    	int flag = -1;
    	
    	//Maybe call method setBoardPositions
    	
    	flag = movingLogic(b, p);
    	
    	if (flag == 1) {
    	}
    	else if (flag == -1) {
    		b.setPosition(b.getPosition());
    		System.out.println("Block identifier: " + b.getBlockIdentifier());
    	}
    	else {
    	}
    	
    	return flag;
    }
    
    /**
     * Prints the current board positions
     */
    public void printBoardPositions() {
    	int i, j;
    	
    	System.out.println("\nBoard Positions:");
    	for (i = 0; i < ROWS; i++) {
    		System.out.print("| ");
    		for (j = 0; j < COLUMNS; j++) {
    			if (blockPositions[j][i] != -1) {
    				System.out.print(blockPositions[j][i] + "  ");
    			}
    			else {
    				System.out.print(blockPositions[j][i] + " ");
    			}
    		}
    		System.out.print("|");
    		System.out.println();
    	}
    }
    
    private int movingLogic(KlotskiBlock block, Point p) {
    	double oldX = block.getPosition().getX();
    	double oldY = block.getPosition().getY();
    	int canMove = -1;

    	switch (block.getBlockType()) {
	    	case "Small Square":
	    		canMove = movingLogicSmallSquare(p.getX(), p.getY(), oldX, oldY, block);
	    		break;
	    	case "Vertical Rectangle":
	    		break;
	    	case "Horizontal Rectangle":
	    		break;
	    	case "Big Square":
	    		break;
	    	default:
	    		System.out.println("No block type!");
    	}
    	
		System.out.println("\ncanMove = " + canMove );
    	return canMove;
    }
    
    private int movingLogicSmallSquare(double x, double y, double oldX, double oldY, KlotskiBlock b) {
    	int i, j;
    	int flag = -1;
    	
    	Point location = new Point((int) x, (int) y);
		Point newLocation = boardPoints[0][0];
		int newLocationX = 0;
		int newLocationY = 0;
		double minDistance = location.distance(newLocation);
		
		// Find the closest point to the block's drop point.
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 5; j++) {
    			if (location.distance(boardPoints[i][j]) < minDistance &&
    					boardPoints[i][j] != boardPoints[(int) oldX / 100][(int) oldY / 100]) {
    				minDistance = location.distance(boardPoints[i][j]);
    				newLocation = boardPoints[i][j];
    				newLocationX = i;
    				newLocationY = j;
    			}
			}
		}
		
		System.out.println("\nLocation = " + (int) newLocation.getX() / 100 + " : " + (int) newLocation.getY() /100);
		System.out.println("\nBlock in space: " + blockPositions[(int) newLocation.getX() / 100][(int) newLocation.getY() /100]);
		
		// Check to make sure new location is empty and there is a clear path to that space, if so update board.
		if (blockPositions[(int) newLocation.getX() / 100][(int) newLocation.getY() /100] == -1) {
			if (clearPathMovingLogic((int) (oldX / 100), (int) (oldY / 100), newLocationX, newLocationY, b.getBlockIdentifier())) {
				blockPositions[(int) (oldX / 100)][(int) (oldY / 100)] = EMPTY_SPACE;
				blockPositions[(int) newLocation.getX() / 100][(int) newLocation.getY() /100] = b.getBlockIdentifier();
				b.setPosition(newLocation);
	    		flag = 1;
			}
		}
		return flag;
    }
    
    /**
     * Makes it so blocks cannot skip over other blocks. There must be a clear path for the block to move to a space.
     * @param pathX is x-coordinate of the path a block can take.
     * @param pathY is y-coordinate of the path a block can take.
     * @param destinationX is the x-coordinate of the destination the block is traveling.
     * @param destinationY is the y-coordinate of the destination the block is traveling.
     * @return a boolean value that tells if the move is legal.
     */
    public boolean clearPathMovingLogic(int pathX, int pathY, int destinationX, int destinationY, int index) {
    	boolean flag1 = false;
    	boolean flag2 = false;

    	if (pathX == destinationX && pathY == destinationY) 
    		return true;
    	else if (pathX == destinationX && pathY < destinationY) {
    		if (blockPositions[pathX][pathY + 1] == -1 || blockPositions[pathX][pathY + 1] == index) 
    			return clearPathMovingLogic(pathX, pathY + 1, destinationX, destinationY, index);
    		else 
    			return false;
    	}
    	else if (pathX == destinationX && pathY > destinationY) {
    		if (blockPositions[pathX][pathY - 1] == -1 || blockPositions[pathX][pathY - 1] == -1) 
    			return clearPathMovingLogic(pathX, pathY - 1, destinationX, destinationY, index);
    		else 
    			return false;
    	}
    	else if (pathX < destinationX && pathY < destinationY) {
    		if (blockPositions[pathX][pathY + 1] == -1 || blockPositions[pathX][pathY + 1] == index) 
    			flag1 = clearPathMovingLogic(pathX, pathY + 1, destinationX, destinationY, index);
    		else 
    			flag1 = false;
    		
    		if (blockPositions[pathX + 1][pathY] == -1 || blockPositions[pathX + 1][pathY] == index) 
    			flag2 = clearPathMovingLogic(pathX + 1, pathY, destinationX, destinationY, index);
    		else 
    			flag2 = false;
    		
    		if (flag1 == false && flag2 == false) 
    			return false; 
    		else
    			return true;
    	}
    	else if (pathY == destinationY && pathX < destinationX) {
    		if (blockPositions[pathX + 1][pathY] == -1 || blockPositions[pathX + 1][pathY] == index) 
    			return clearPathMovingLogic(pathX + 1, pathY, destinationX, destinationY, index);
    		else 
    			return false;
    	}
    	else if (pathY == destinationY && pathX > destinationX) {
    		if (blockPositions[pathX - 1][pathY] == -1 || blockPositions[pathX - 1][pathY] == index) 
    			return clearPathMovingLogic(pathX - 1, pathY, destinationX, destinationY, index);
    		else 
    			return false;
    	}
    	else if (pathX < destinationX && pathY > destinationY) {
    		if (blockPositions[pathX][pathY - 1] == -1 || blockPositions[pathX][pathY - 1] == index) 
    			flag1 = clearPathMovingLogic(pathX, pathY - 1, destinationX, destinationY, index);
    		else 
    			flag1 = false;
    		
    		if (blockPositions[pathX + 1][pathY] == -1 || blockPositions[pathX + 1][pathY] == index) 
    			flag2 = clearPathMovingLogic(pathX + 1, pathY, destinationX, destinationY, index);
    		else 
    			flag2 = false;
    		
    		if (flag1 == false && flag2 == false) 
    			return false; 
    		else
    			return true;
    	}
    	else if (pathX > destinationX && pathY > destinationY) {
    		if (blockPositions[pathX][pathY - 1] == -1 || blockPositions[pathX][pathY - 1] == index) 
    			flag1 = clearPathMovingLogic(pathX, pathY - 1, destinationX, destinationY, index);
    		else 
    			flag1 = false;
    		
    		if (blockPositions[pathX - 1][pathY] == -1 || blockPositions[pathX - 1][pathY] == index) 
    			flag2 = clearPathMovingLogic(pathX - 1, pathY, destinationX, destinationY, index);
    		else 
    			flag2 = false;
    		
    		if (flag1 == false && flag2 == false) 
    			return false; 
    		else
    			return true;
    	}
    	else if (pathX > destinationX && pathY < destinationY) {
    		if (blockPositions[pathX][pathY + 1] == -1 || blockPositions[pathX][pathY + 1] == index) 
    			flag1 = clearPathMovingLogic(pathX, pathY + 1, destinationX, destinationY, index);
    		else 
    			flag1 = false;
    		
    		if (blockPositions[pathX - 1][pathY] == -1 || blockPositions[pathX - 1][pathY] == index) 
    			flag2 = clearPathMovingLogic(pathX - 1, pathY, destinationX, destinationY, index);
    		else 
    			flag2 = false;
    		
    		if (flag1 == false && flag2 == false) 
    			return false; 
    		else
    			return true;
    	}
    	else {
    		return false;
    	}
    }
}
