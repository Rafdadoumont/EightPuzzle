package application;

import model.Node;
import model.Puzzle;
import model.algorithms.AlgorithmEnum;
import model.algorithms.AlgorithmFactory;
import model.algorithms.AlgorithmStrategy;

import java.util.List;

public class EightPuzzleMain {
    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();
        int[][] board = {{8, 7, 1},
                         {3, 5, 2},
                         {0, 4, 6}};

        if (puzzle.isSolvable(board)) {
            AlgorithmFactory factory = new AlgorithmFactory();
            AlgorithmStrategy algorithm = factory.createAlgorithm(AlgorithmEnum.A_STAR);
            algorithm.solve(board);
        } else {
            System.out.println("Puzzle not solvable");
        }
    }
}
