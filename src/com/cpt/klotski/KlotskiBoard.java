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
        blockPositions[COLUMN_FOUR / 100][ROW_FIVE / 100] =
                blocks[SMALL_SQUARE_1].getBlockIdentifier();
        blockPositions[COLUMN_TWO / 100][ROW_FOUR / 100] =
                blocks[SMALL_SQUARE_2].getBlockIdentifier();
        blockPositions[COLUMN_THREE / 100][ROW_FOUR / 100] =
                blocks[SMALL_SQUARE_3].getBlockIdentifier();
        blockPositions[COLUMN_ONE / 100][ROW_FIVE / 100] =
                blocks[SMALL_SQUARE_4].getBlockIdentifier();
        blockPositions[COLUMN_ONE / 100][ROW_ONE / 100] =
                blocks[VERTICAL_BLOCK_1].getBlockIdentifier();
        blockPositions[COLUMN_ONE / 100][ROW_TWO / 100] =
                blocks[VERTICAL_BLOCK_1].getBlockIdentifier();
        blockPositions[COLUMN_ONE / 100][ROW_THREE / 100] =
                blocks[VERTICAL_BLOCK_2].getBlockIdentifier();
        blockPositions[COLUMN_ONE / 100][ROW_FOUR / 100] =
                blocks[VERTICAL_BLOCK_2].getBlockIdentifier();
        blockPositions[COLUMN_FOUR / 100][ROW_ONE / 100] =
                blocks[VERTICAL_BLOCK_3].getBlockIdentifier();
        blockPositions[COLUMN_FOUR / 100][ROW_TWO / 100] =
                blocks[VERTICAL_BLOCK_3].getBlockIdentifier();
        blockPositions[COLUMN_FOUR / 100][ROW_THREE / 100] =
                blocks[VERTICAL_BLOCK_4].getBlockIdentifier();
        blockPositions[COLUMN_FOUR / 100][ROW_FOUR / 100] =
                blocks[VERTICAL_BLOCK_4].getBlockIdentifier();
        blockPositions[COLUMN_TWO / 100][ROW_THREE / 100] =
                blocks[HORIZONTAL_BLOCK].getBlockIdentifier();
        blockPositions[COLUMN_THREE / 100][ROW_THREE / 100] =
                blocks[HORIZONTAL_BLOCK].getBlockIdentifier();
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
        } catch (Exception e) {
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
     * Moves a Klotski Block to a position if the move is a legal.
     * 
     * @param b block to move
     * @param p point to move the block
     * @return
     */
    public boolean setBlockPosition(KlotskiBlock b, Point p) {
        return movingLogic(b, p);
    }

    private boolean movingLogic(KlotskiBlock block, Point p) {
        switch (block.getBlockType()) {
            case "Small Square":
                return movingLogicSmallSquare(p, block);
            case "Vertical Rectangle":
                return movingLogicVerticalRectangle(p, block);
            case "Horizontal Rectangle":
                return movingLogicHorizontalRectangle(p, block);
            case "Big Square":
                return movingLogicBigSquare(p, block);
            default:
                System.out.println("No block type!");
                return false;
        }
    }

    private boolean movingLogicSmallSquare(Point p, KlotskiBlock b) {
        int oldX = (int) b.getPosition().getX() / 100;
        int oldY = (int) b.getPosition().getY() / 100;
        Point newLocation = closestPointAtDrop(new Point((int) p.getX(), (int) p.getY()));
        int newLocationX = (int) newLocation.getX();
        int newLocationY = (int) newLocation.getY();

        if (blockPositions[newLocationX][newLocationY] == EMPTY_SPACE) {
            b.setPosition(boardPoints[newLocationX][newLocationY]);
            blockPositions[oldX][oldY] = EMPTY_SPACE;
            blockPositions[newLocationX][newLocationY] = b.getBlockIdentifier();
            return true;
        }

        b.setPosition(boardPoints[oldX][oldY]);
        return false;
    }

    public boolean movingLogicVerticalRectangle(Point p, KlotskiBlock b) {
        int oldX = (int) b.getPosition().getX() / 100;
        int oldY = (int) b.getPosition().getY() / 100;
        Point newLocation = closestPointAtDrop(new Point((int) p.getX(), (int) p.getY()));
        int newLocationX = (int) newLocation.getX();
        int newLocationY = (int) newLocation.getY();

        if ((blockPositions[newLocationX][newLocationY] == EMPTY_SPACE &&
                blockPositions[newLocationX][newLocationY + 1] == b.getBlockIdentifier())
                ||
                (blockPositions[newLocationX][newLocationY] == b.getBlockIdentifier() &&
                        blockPositions[newLocationX][newLocationY + 1] == EMPTY_SPACE)
                ||
                (blockPositions[newLocationX][newLocationY] == EMPTY_SPACE &&
                        blockPositions[newLocationX][newLocationY + 1] == EMPTY_SPACE)) {

            b.setPosition(boardPoints[newLocationX][newLocationY]);
            blockPositions[oldX][oldY] = EMPTY_SPACE;
            blockPositions[oldX][oldY + 1] = EMPTY_SPACE;
            blockPositions[newLocationX][newLocationY] = b.getBlockIdentifier();
            blockPositions[newLocationX][newLocationY + 1] = b.getBlockIdentifier();
            return true;
        }

        b.setPosition(boardPoints[oldX][oldY]);
        return false;
    }

    public boolean movingLogicHorizontalRectangle(Point p, KlotskiBlock b) {
        int oldX = (int) b.getPosition().getX() / 100;
        int oldY = (int) b.getPosition().getY() / 100;
        Point newLocation = closestPointAtDrop(new Point((int) p.getX(), (int) p.getY()));
        int newLocationX = (int) newLocation.getX();
        int newLocationY = (int) newLocation.getY();

        if ((blockPositions[newLocationX][newLocationY] == EMPTY_SPACE &&
                blockPositions[newLocationX + 1][newLocationY] == b.getBlockIdentifier())
                ||
                (blockPositions[newLocationX][newLocationY] == b.getBlockIdentifier() &&
                        blockPositions[newLocationX + 1][newLocationY] == EMPTY_SPACE)
                ||
                (blockPositions[newLocationX][newLocationY] == EMPTY_SPACE &&
                        blockPositions[newLocationX + 1][newLocationY] == EMPTY_SPACE)) {

            b.setPosition(boardPoints[newLocationX][newLocationY]);
            blockPositions[oldX][oldY] = EMPTY_SPACE;
            blockPositions[oldX + 1][oldY] = EMPTY_SPACE;
            blockPositions[newLocationX][newLocationY] = b.getBlockIdentifier();
            blockPositions[newLocationX + 1][newLocationY] = b.getBlockIdentifier();
            return true;
        }

        b.setPosition(boardPoints[oldX][oldY]);
        return false;
    }

    public boolean movingLogicBigSquare(Point p, KlotskiBlock b) {
        int oldX = (int) b.getPosition().getX() / 100;
        int oldY = (int) b.getPosition().getY() / 100;
        Point newLocation = closestPointAtDrop(new Point((int) p.getX(), (int) p.getY()));
        int newLocationX = (int) newLocation.getX();
        int newLocationY = (int) newLocation.getY();

        if ((blockPositions[newLocationX][newLocationY] == EMPTY_SPACE &&
                blockPositions[newLocationX + 1][newLocationY] == EMPTY_SPACE &&
                blockPositions[newLocationX][newLocationY + 1] == b.getBlockIdentifier() &&
                blockPositions[newLocationX + 1][newLocationY + 1] == b.getBlockIdentifier())
                ||
                (blockPositions[newLocationX][newLocationY] == b.getBlockIdentifier() &&
                        blockPositions[newLocationX + 1][newLocationY] == b.getBlockIdentifier() &&
                        blockPositions[newLocationX][newLocationY + 1] == EMPTY_SPACE &&
                        blockPositions[newLocationX + 1][newLocationY + 1] == EMPTY_SPACE)
                ||
                (blockPositions[newLocationX][newLocationY] == EMPTY_SPACE &&
                        blockPositions[newLocationX][newLocationY + 1] == EMPTY_SPACE &&
                        blockPositions[newLocationX + 1][newLocationY] == b.getBlockIdentifier() &&
                        blockPositions[newLocationX + 1][newLocationY + 1] == b
                                .getBlockIdentifier())
                ||
                (blockPositions[newLocationX][newLocationY] == b.getBlockIdentifier() &&
                        blockPositions[newLocationX][newLocationY + 1] == b.getBlockIdentifier() &&
                        blockPositions[newLocationX + 1][newLocationY] == EMPTY_SPACE &&
                        blockPositions[newLocationX + 1][newLocationY + 1] == EMPTY_SPACE)) {

            b.setPosition(boardPoints[newLocationX][newLocationY]);
            blockPositions[oldX][oldY] = EMPTY_SPACE;
            blockPositions[oldX][oldY + 1] = EMPTY_SPACE;
            blockPositions[oldX + 1][oldY] = EMPTY_SPACE;
            blockPositions[oldX + 1][oldY + 1] = EMPTY_SPACE;
            blockPositions[newLocationX][newLocationY] = b.getBlockIdentifier();
            blockPositions[newLocationX][newLocationY + 1] = b.getBlockIdentifier();
            blockPositions[newLocationX + 1][newLocationY] = b.getBlockIdentifier();
            blockPositions[newLocationX + 1][newLocationY + 1] = b.getBlockIdentifier();

            return true;
        }

        b.setPosition(boardPoints[oldX][oldY]);
        return false;
    }

    private Point closestPointAtDrop(Point location) {
        int i, j;
        Point newLocation = boardPoints[0][0];
        double minDistance = location.distance(newLocation);
        int newLocationX = 0;
        int newLocationY = 0;

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 5; j++) {
                if (location.distance(boardPoints[i][j]) < minDistance) {
                    minDistance = location.distance(boardPoints[i][j]);
                    newLocation = boardPoints[i][j];
                    newLocationX = i;
                    newLocationY = j;
                }
            }
        }

        return new Point(newLocationX, newLocationY);
    }

    /**
     * Makes it so blocks cannot skip over other blocks. There must be a clear path for the block to
     * move to a space.
     * 
     */
    private boolean clearPathMovingLogic(KlotskiBlock b, Point destination) {
        if (b.getBlockType() == "Small Square") {

        } else if (b.getBlockType() == "Big Square") {

        } else if (b.getBlockType() == "Vertical Rectangle") {

        } else if (b.getBlockType() == "Horizontal Rectangle") {

        } else {
            System.out.println("Not a valid block!");
        }
        return false;
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
                } else {
                    System.out.print(blockPositions[j][i] + " ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
    }
}
