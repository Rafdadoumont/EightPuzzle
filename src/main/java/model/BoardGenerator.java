package model;

/**
 * The BoardGenerator class generates a 2D array representing a board based on the specified depth of the solution.
 */
public class BoardGenerator {

    /**
     * Constructs a new BoardGenerator.
     */
    public BoardGenerator() {
    }

    /**
     * Generates a 2D array representing a board based on the specified depth of the solution.
     *
     * @param depth the depth determining the configuration of the board
     * @return a 2D array representing the generated board
     */
    public byte[][] generate(int depth) {
        return switch (depth) {
            case 14 -> new byte[][]{{1, 7, 2}, {6, 0, 3}, {4, 5, 8}};
            case 18 -> new byte[][]{{7, 3, 0}, {8, 4, 2}, {6, 1, 5}};
            case 20 -> new byte[][]{{1, 3, 0} , {8, 7, 2}, {4, 5, 6}};
            case 31 -> new byte[][]{{8, 6, 7}, {2, 5, 4}, {3, 0, 1}};
            default -> new byte[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        };
    }
}
