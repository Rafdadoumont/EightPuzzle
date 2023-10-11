package model;

public class Puzzle {

    public final int dimension = 3;

    /**
     * Checks if the given puzzle board is solvable using inversion counting.
     * <a href="https://www.geeksforgeeks.org/check-instance-8-puzzle-solvable/">...</a>
     *
     * @param board The puzzle board as a 2D array.
     * @return true if the puzzle is solvable, false otherwise.
     *
     */
    public boolean isSolvable(int[][] board) {
        int[] boardFlatten = new int[(int) Math.pow(dimension, 2)];
        int i = 0;

        for(int x = 0; x < dimension; x++)
            for(int y = 0; y < dimension; y++)
                boardFlatten[i++] = board[x][y];

        int invCount = getInversionCount(boardFlatten);

        return (invCount % 2 == 0);
    }

    /**
     * Calculates the inversion count for an array.
     *
     * @param array The flattened puzzle board represented as an array.
     * @return The inversion count.
     */
    private int getInversionCount(int[] array) {
        int inversionCount = 0;

        for (int i = 0; i < Math.pow(dimension, 2) - 1; i++)
            for (int j = i + 1; j < Math.pow(dimension, 2); j++)
                if (array[i] > 0 && array[j] > 0 && array[i] > array[j]) {
                    inversionCount++;
                }

        return inversionCount;
    }
}

