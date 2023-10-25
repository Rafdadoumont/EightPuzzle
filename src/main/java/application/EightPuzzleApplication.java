package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.BoardGenerator;
import model.Puzzle;
import model.algorithms.AlgorithmEnum;
import model.algorithms.AlgorithmFactory;
import model.algorithms.AlgorithmStrategy;

import java.io.IOException;
import java.net.URL;

public class EightPuzzleApplication extends Application {
    enum Mode {
        CONSOLE, JAVAFX
    }
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/TreeView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Eight Puzzle");
        stage.initStyle(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Mode mode = Mode.CONSOLE;

        switch (mode) {
            case CONSOLE:
                Puzzle puzzle = new Puzzle();
                BoardGenerator boardGenerator = new BoardGenerator();
                byte[][] board = boardGenerator.generate(20);

                if (puzzle.isSolvable(board)) {
                    AlgorithmFactory factory = new AlgorithmFactory();
                    AlgorithmStrategy algorithm = factory.createAlgorithm(AlgorithmEnum.A_STAR);
                    try {
                        algorithm.solve(board);
                    } catch (OutOfMemoryError e) {
                        System.err.println("Out of memory");
                    }
                } else {
                    System.out.println("Puzzle not solvable");
                }

            break;
                case JAVAFX: launch(args);
            break;
            }
    }
}