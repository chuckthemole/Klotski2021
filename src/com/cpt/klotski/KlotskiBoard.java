package com.cpt.klotski;

/**
 * 
 * @author Chuck
 *
 */
public class KlotskiBoard {      
    private KlotskiBlock[] blocks;
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

    KlotskiBoard() {
        blocks = new KlotskiBlock[NUMBER_OF_BLOCKS];
        
        //one by one blocks
        blocks[SMALL_SQUARE_1] = new KlotskiBlock("Small Square", 300, 400);  
        blocks[SMALL_SQUARE_2] = new KlotskiBlock("Small Square", 100, 300);
        blocks[SMALL_SQUARE_3] = new KlotskiBlock("Small Square", 200, 300);
        blocks[SMALL_SQUARE_4] = new KlotskiBlock("Small Square", 0, 400);
        
        //one by two blocks 
        blocks[VERTICAL_BLOCK_1] = new KlotskiBlock("Vertical Rectangle", 0, 0);          
        blocks[VERTICAL_BLOCK_2] = new KlotskiBlock("Vertical Rectangle", 0, 200);         
        blocks[VERTICAL_BLOCK_3] = new KlotskiBlock("Vertical Rectangle", 300, 0);       
        blocks[VERTICAL_BLOCK_4] = new KlotskiBlock("Vertical Rectangle", 300, 200);  
        
        //two by one block 
        blocks[HORIZONTAL_BLOCK] = new KlotskiBlock("Horizontal Rectangle", 100, 200); 
        
        //two by two block        
        blocks[BIG_SQUARE] = new KlotskiBlock("Big Square", 100, 0); 
    }
    
    public KlotskiBlock[] getBlocks() {
    	return blocks;
    }
}
