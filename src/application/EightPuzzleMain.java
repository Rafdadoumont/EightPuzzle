package application;

import model.Puzzle;
import model.algorithms.AlgorithmEnum;
import model.algorithms.AlgorithmFactory;
import model.algorithms.AlgorithmStrategy;

public class EightPuzzleMain {
    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();
        int[][] board = {{6, 7, 3},
                         {2, 4, 8},
                         {1, 5, 0}};

        if (puzzle.isSolvable(board)) {
            AlgorithmFactory factory = new AlgorithmFactory();
            AlgorithmStrategy algorithm = factory.createAlgorithm(AlgorithmEnum.A_STAR);
            algorithm.solve(board);
        } else {
            System.out.println("Puzzle not solvable");
        }
    }
}
