package com.cpt.klotski;

import java.awt.Point;

/**
 * 
 * @author Chuck
 *
 */
public class KlotskiBoard {      
    private static KlotskiBlock[] blocks;
    
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

    KlotskiBoard() {
        blocks = new KlotskiBlock[NUMBER_OF_BLOCKS];
        
        //one by one blocks
        blocks[SMALL_SQUARE_1] = new KlotskiBlock("Small Square", COLUMN_FOUR, ROW_FIVE);  
        blocks[SMALL_SQUARE_2] = new KlotskiBlock("Small Square", COLUMN_TWO, ROW_FOUR);
        blocks[SMALL_SQUARE_3] = new KlotskiBlock("Small Square", COLUMN_THREE, ROW_FOUR);
        blocks[SMALL_SQUARE_4] = new KlotskiBlock("Small Square", COLUMN_ONE, ROW_FIVE);
        
        //one by two blocks 
        blocks[VERTICAL_BLOCK_1] = new KlotskiBlock("Vertical Rectangle", COLUMN_ONE, ROW_ONE);          
        blocks[VERTICAL_BLOCK_2] = new KlotskiBlock("Vertical Rectangle", COLUMN_ONE, ROW_THREE);         
        blocks[VERTICAL_BLOCK_3] = new KlotskiBlock("Vertical Rectangle", COLUMN_FOUR, ROW_ONE);       
        blocks[VERTICAL_BLOCK_4] = new KlotskiBlock("Vertical Rectangle", COLUMN_FOUR, ROW_THREE);  
        
        //two by one block 
        blocks[HORIZONTAL_BLOCK] = new KlotskiBlock("Horizontal Rectangle", COLUMN_TWO, ROW_THREE); 
        
        //two by two block        
        blocks[BIG_SQUARE] = new KlotskiBlock("Big Square", COLUMN_TWO, ROW_ONE); 
    }
    
    public KlotskiBlock[] getBlocks() {
    	return blocks;
    }
    
    public int setBlockPosition(KlotskiBlock b, Point p) {
    	//TODO
    	return 1;
    }
}
