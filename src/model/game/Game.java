package model.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private final int dimension;

    public Game(Board board) {
        this.board = board;
        dimension = board.getDimension();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getDimension() { return dimension;}

    public List<Board> getSuccessors() {
        List<Board> successors = new ArrayList<>();

        int[] coordinatesZero = board.getCoordinates(0);
        int x = coordinatesZero[0];
        int y = coordinatesZero[1];

        // To
        if (y > 0 && y <= dimension) {
            successors.add(new Board(board.getTiles()).swapTiles(x, y, x, y - 1));
        }
        // Right
        if (0 <= x && x < dimension) {
            successors.add(new Board(board.getTiles()).swapTiles(x, y, x + 1, y));
        }
        // Bottom
        if (0 <= y && y < dimension) {
            successors.add(new Board(board.getTiles()).swapTiles(x, y, x, y + 1));
        }
        // Left
        if (x > 0 && x <= dimension) {
            successors.add(new Board(board.getTiles()).swapTiles(x, y, x - 1, y));
        }

        return successors;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Tile[] row: board.getTiles()) {
            for (Tile tile: row) {
                stringBuilder.append(tile.getValue()).append(" ");
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
