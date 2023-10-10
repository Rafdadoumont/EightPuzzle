package model.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameFactory {

    public Game generateRandomGame(int dimension) {
        Tile[][] board = new Tile[dimension][dimension];
        List<Integer> uniqueValues = new ArrayList<>();

        for (int i = 0; i <= Math.pow(dimension, 2) - 1; i++) {
            uniqueValues.add(i);
        }

        Collections.shuffle(uniqueValues);

        for (int i = 0; i < dimension; i++) {
            Tile[] boardRow = new Tile[dimension];
            for (int j = 0; j < dimension; j++) {
                Tile tile = new Tile(uniqueValues.get(i * dimension + j));
                boardRow[j] = tile;
            }
            board[i] = boardRow;
        }
        return new Game(new Board(board));
    }

    public Game generateCustomGame(int[][] tiles) {
        int dimension = tiles.length;
        if (tiles.length != tiles[0].length) {
            return null;
        }

        Tile[][] board = new Tile[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            Tile[] boardRow = new Tile[dimension];
            for (int j = 0; j < dimension; j++) {
                Tile tile = new Tile(tiles[i][j]);
                boardRow[j] = tile;
            }
            board[i] = boardRow;
        }

        return new Game(new Board(board));

    }

}
