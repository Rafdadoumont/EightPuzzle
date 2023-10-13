package application;

import model.BoardGenerator;
import model.Puzzle;
import model.algorithms.AlgorithmEnum;
import model.algorithms.AlgorithmFactory;
import model.algorithms.AlgorithmStrategy;

public class EightPuzzleMain {
    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();
        BoardGenerator boardGenerator = new BoardGenerator();
        int[][] board = boardGenerator.generate(14);

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
    }
}
