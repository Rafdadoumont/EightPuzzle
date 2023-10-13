package model;

public class BoardGenerator {

    public BoardGenerator() {
    }

    public int[][] generate(int depth) {
        return switch (depth) {
            case 14 -> new int[][]{{1, 7, 2}, {6, 0, 3}, {4, 5, 8}};
            case 31 -> new int[][]{{8, 6, 7}, {2, 5, 4}, {3, 0, 1}};
            default -> new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        };
    }
}
