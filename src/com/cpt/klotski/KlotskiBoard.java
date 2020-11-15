package com.cpt.klotski;

import java.awt.Point;

/**
 * 
 * @author Chuck
 *
 */
public class KlotskiBoard {      
    private static KlotskiBlock[] blocks;
    private static int[][] boardPositions;
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
        
        boardPositions = new int[COLUMNS][ROWS];
        boardPositions[COLUMN_FOUR / 100][ROW_FIVE / 100] = blocks[SMALL_SQUARE_1].getBlockIdentifier();
        boardPositions[COLUMN_TWO / 100][ROW_FOUR / 100] = blocks[SMALL_SQUARE_2].getBlockIdentifier();
        boardPositions[COLUMN_THREE / 100][ROW_FOUR / 100] = blocks[SMALL_SQUARE_3].getBlockIdentifier();
        boardPositions[COLUMN_ONE / 100][ROW_FIVE / 100] = blocks[SMALL_SQUARE_4].getBlockIdentifier();
        boardPositions[COLUMN_ONE / 100][ROW_ONE / 100] = blocks[VERTICAL_BLOCK_1].getBlockIdentifier();
        boardPositions[COLUMN_ONE / 100][ROW_TWO / 100] = blocks[VERTICAL_BLOCK_1].getBlockIdentifier();
        boardPositions[COLUMN_ONE / 100][ROW_THREE / 100] = blocks[VERTICAL_BLOCK_2].getBlockIdentifier();
        boardPositions[COLUMN_ONE / 100][ROW_FOUR / 100] = blocks[VERTICAL_BLOCK_2].getBlockIdentifier();
        boardPositions[COLUMN_FOUR / 100][ROW_ONE / 100] = blocks[VERTICAL_BLOCK_3].getBlockIdentifier();
        boardPositions[COLUMN_FOUR / 100][ROW_TWO / 100] = blocks[VERTICAL_BLOCK_3].getBlockIdentifier();
        boardPositions[COLUMN_FOUR / 100][ROW_THREE / 100] = blocks[VERTICAL_BLOCK_4].getBlockIdentifier();
        boardPositions[COLUMN_FOUR / 100][ROW_FOUR / 100] = blocks[VERTICAL_BLOCK_4].getBlockIdentifier();
        boardPositions[COLUMN_TWO / 100][ROW_THREE / 100] = blocks[HORIZONTAL_BLOCK].getBlockIdentifier();
        boardPositions[COLUMN_THREE / 100][ROW_THREE / 100] = blocks[HORIZONTAL_BLOCK].getBlockIdentifier();
        boardPositions[COLUMN_TWO / 100][ROW_ONE / 100] = blocks[BIG_SQUARE].getBlockIdentifier();
        boardPositions[COLUMN_TWO / 100][ROW_TWO / 100] = blocks[BIG_SQUARE].getBlockIdentifier();
        boardPositions[COLUMN_THREE / 100][ROW_ONE / 100] = blocks[BIG_SQUARE].getBlockIdentifier();
        boardPositions[COLUMN_THREE / 100][ROW_TWO / 100] = blocks[BIG_SQUARE].getBlockIdentifier();
        boardPositions[COLUMN_TWO / 100][ROW_FIVE / 100] = EMPTY_SPACE;
        boardPositions[COLUMN_THREE / 100][ROW_FIVE / 100] = EMPTY_SPACE;
        printBoardPositions();
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
    public int[][] getBoardPositionS() {
    	return boardPositions;
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
    	
    	flag = movingLogic(b.getBlockType());
    	
    	if (flag == 1) {
    		
    	}
    	else if (flag == -1) {
    		b.setPosition(b.getPosition());
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
    			if (boardPositions[j][i] != -1) {
    				System.out.print(boardPositions[j][i] + "  ");
    			}
    			else {
    				System.out.print(boardPositions[j][i] + " ");
    			}
    		}
    		System.out.print("|");
    		System.out.println();
    	}
    }
    
    private int movingLogic(String blockType) {
    	
    	switch (blockType) {
    	case "Small Square":
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
    	
    	return -1;
    }
}
