package com.cpt.klotski;

import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * 
 * @author Chuck
 *
 */
public class Klotski extends Application {
    private final String musicPath = "//Music//song2.MP3";
    private static KlotskiBoard mainBoard;
    private Stage stage;
    private Scene scene;
    private BlockDrag[] blockDrag;
    private static boolean mouseActive;
    private static int solveCalled = 0;
    private static SequentialTransition seqTransition, s;

    @Override
    public void start(Stage primaryStage) throws Exception {
        startGame(primaryStage);
    }

    public void startGame(Stage s) {
        stage = s;
        System.out.println("Start called...");
        enableMouse();
        // playMusic(musicPath);
        buildStage(stage);
        addListeners();
    }

    private static void playMusic(String s) {
        if (OperatingSystem.isWindows()) {
            s.replace('/', '\\');
        }
        try {
            PlayMusic.playMusic(s);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    private void buildStage(Stage stage) {
        Pane mainPane = new Pane();
        Pane blocksAndButtonsPane = new Pane();

        blocksAndButtonsPane.getChildren().add(buildBlocksPane());
        blocksAndButtonsPane.getChildren().add(0, buildButtonsPane());
        blocksAndButtonsPane.setLayoutX(40);
        blocksAndButtonsPane.setLayoutY(40);

        final String cssDefault = "-fx-border-color: blue;\n" + "-fx-border-width: 20;\n";
        mainPane.setStyle(cssDefault);
        mainPane.getChildren().add(blocksAndButtonsPane);

        Group root = new Group(mainPane);
        scene = new Scene(root);
        scene.setFill(Paint.valueOf("Black"));
        stage.setOnCloseRequest(e -> System.exit(0));
        stage.setTitle("Klotski");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.sizeToScene();
        stage.show();
    }

    private Pane buildBlocksPane() {
        Pane blocksPane = new Pane();

        mainBoard = new KlotskiBoard();
        for (KlotskiBlock block : mainBoard.getBlocks()) {
            blocksPane.getChildren().add(block.getRec());
        }

        return blocksPane;
    }

    private Pane buildButtonsPane() {
        Buttons buttons = new Buttons();
        Pane p = new Pane();

        p.setPrefSize(400, 100);
        p.relocate(0, 520);
        p.setBackground(
                new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));
        p.getChildren().add(buttons.getHBox());
        buttons.getHBox().relocate(50, 35);

        return p;
    }

    private void addListeners() {
        blockDrag = new BlockDrag[10];
        int i;
        for (i = 9; i >= 0; i--) {
            blockDrag[i] = new BlockDrag(mainBoard.getBlocks()[i], mainBoard, mouseActive);
        }
    }

    public boolean isMouseActive() {
        return mouseActive;
    }

    public static void disableMouse() {
        mouseActive = false;
    }

    public static void enableMouse() {
        mouseActive = true;
    }

    public void music() {
        if (PlayMusic.getMusicIsPlaying()) {
            PlayMusic.stop();
        } else {
            PlayMusic.play();
        }
    }

    public void quit() {
        Platform.exit();
        System.exit(0);
    }

    public void solve() {
        cleanup();
        solveCalled = 1;

        Platform.runLater(() -> {
            // fxThread is the JavaFX Application Thread after this call
            try {
                stage.close();
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
            startGame(stage);
        });
    }

    public void restart(Button restart) {
        cleanup();
        solveCalled = 0;
        enableMouse();
        Platform.runLater(() -> {
            try {
                stage = (Stage) restart.getScene().getWindow();
                stage.close();
                new Klotski().start(new Stage());
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }

    public void undo() {
        if (mouseActive) {
            mainBoard.undo();
            mainBoard.getUndoStack().printUndoStack();
        }
    }

    private void cleanup() {
        try {
            seqTransition.stop();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            s.stop();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
