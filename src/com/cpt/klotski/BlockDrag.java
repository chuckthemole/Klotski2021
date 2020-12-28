package com.cpt.klotski;

import java.awt.Point;
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
    final int RIGHT_BORDER_FIRST_COLUMN = 100;
    final int BOTTOM_BORDER_FIRST_ROW = 100;

    private int x;
    private int y;

    /**
     * 
     * @param b is a block on the klotskiBoard
     * @param klotskiBoard is the current KlotskiBoard object
     */
    BlockDrag(KlotskiBlock b, KlotskiBoard klotskiBoard, boolean mouseActive) {
        b.getRec().setCursor(Cursor.HAND);

        b.getRec().xProperty().addListener((Observable, oldValue, newValue) -> {
            // System.out.println("X position changed from <" + oldValue + "> to <" + newValue +
            // ">");
            x = newValue.intValue();
        });

        b.getRec().yProperty().addListener((Observable, oldValue, newValue) -> {
            // System.out.println("Y position changed from <" + oldValue + "> to <" + newValue +
            // ">");
            y = newValue.intValue();
        });

        b.getRec().setOnMouseDragged(e -> {
            double blockXBorder = RIGHT_WALL - b.getRec().getWidth();
            double blockYBorder = BOTTOM_WALL - b.getRec().getHeight();
            // Point2D currentPointer = new Point2D(e.getX(), e.getY());
            // Rectangle bound = new Rectangle(400,500);

            b.getRec().toFront();

            if (mouseActive) {
                // Right and left border walls
                if (b.getRec().getX() >= blockXBorder && e.getX() > blockXBorder) {
                    b.getRec().setX(blockXBorder);
                } else if (b.getRec().getX() <= LEFT_WALL && e.getX() < RIGHT_BORDER_FIRST_COLUMN) {
                    b.getRec().setX(LEFT_WALL);
                } else {
                    b.getRec().setX(e.getX() - (b.getRec().getWidth() / 2));
                }

                // Top and bottom border walls
                if (b.getRec().getY() >= blockYBorder && e.getY() > blockYBorder) {
                    b.getRec().setY(blockYBorder);
                } else if (b.getRec().getY() <= TOP_WALL && e.getY() < BOTTOM_BORDER_FIRST_ROW) {
                    b.getRec().setY(TOP_WALL);
                } else {
                    b.getRec().setY(e.getY() - (b.getRec().getHeight() / 2));
                }
            }
            e.consume();
        });

        b.getRec().setOnMouseReleased(e -> {
            klotskiBoard.setBlockPosition(b, new Point((int) (e.getX() - b.getWidth() / 2),
                    (int) (e.getY() - b.getHeight() / 2)));
            x = (int) b.getPosition().getX();
            y = (int) b.getPosition().getY();
            b.getRec().toBack();
            klotskiBoard.printBoardPositions();
        });
    }

    public void setX(int value) {
        x = value;
    }

    public void setY(int value) {
        y = value;
    }
}
