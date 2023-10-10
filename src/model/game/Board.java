package model.game;

import model.Node;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Board implements Node, Comparable<Board> {
    private final int N;
    private Tile[][] tiles;

    public Board(Tile[][] tiles) {
        N = tiles.length;
        this.tiles = tiles;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public int getDimension() {
        return N;
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public int[] getCoordinates(int value) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (value == this.getTile(x, y).getValue()) {
                    return new int[]{x, y};
                }
            }
        }
        return null;
    }

    public boolean isGoal() {
        Tile[][] tiles = {{new Tile(1), new Tile(2), new Tile(3)},
                        {new Tile(4), new Tile(5), new Tile(6)},
                        {new Tile(7), new Tile(8), new Tile(0)}};
        Board goalBoard = new Board(tiles);

        return compareTo(goalBoard) == 0;
    }

    public Board swapTiles(int x1, int y1, int x2, int y2) {
        Board board = this.copyOf();
        Tile tile1 = this.getTile(x1, y1);
        Tile tile2 = this.getTile(x2, y2);

        board.tiles[x1][y1] = tile2;
        board.tiles[x2][y2] = tile1;
        return board;
    }

    public Board copyOf() {
        return new Board(Arrays.copyOf(tiles, tiles.length));
    }

    @Override
    public int getHeuristic() {
        int manhattanDistanceSum = 0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int value = this.getTile(x, y).getValue();
                    if (value != 0) {
                        int targetX = (value - 1) / N;
                        int targetY = (value - 1) % N;
                        int dx = x - targetX;
                        int dy = y - targetY;
                        manhattanDistanceSum += Math.abs(dx) + Math.abs(dy);
                    }
            }
        }
        return manhattanDistanceSum;
    }


    @Override
    public int compareTo(Board other) {
        int dimension = this.getDimension();
        int dimensionOther = other.getDimension();

        if (dimension != dimensionOther) {
            return 1;
        }

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (this.getTile(i, j).getValue() != other.getTile(i, j).getValue()) {
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Tile[] row: tiles) {
            for (Tile tile: row) {
                stringBuilder.append(tile.getValue()).append(" ");
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
