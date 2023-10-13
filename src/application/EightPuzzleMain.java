package application;

import model.Puzzle;
import model.algorithms.AlgorithmEnum;
import model.algorithms.AlgorithmFactory;
import model.algorithms.AlgorithmStrategy;

public class EightPuzzleMain {
    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();


        // 14 depth
        int [][] board = {{1, 7, 2},
                          {6, 0, 3},
                          {4, 5, 8}};


//        int[][] board = {{7, 3, 2},
//                         {6, 8, 1},
//                         {0, 5, 4}};

         //Hardest
//        int[][] board = {{8, 6, 7},
//                         {2, 5, 4},
//                         {3, 0, 1}};

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
