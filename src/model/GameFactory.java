package model;

import java.io.Console;
import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameFactory {

    public Game generateRandomGame(int dimension) {
        List<List<Tile>> board = new ArrayList<>();
        List<Integer> uniqueValues = new ArrayList<>();

        for (int i = 0; i <= Math.pow(dimension, 2) - 1; i++) {
            uniqueValues.add(i);
        }

        Collections.shuffle(uniqueValues);

        for (int i = 0; i < dimension; i++) {
            List<Tile> boardRow = new ArrayList<>();
            for (int j = 0; j < dimension; j++) {
                Tile tile = new Tile(uniqueValues.get(i * dimension + j));
                boardRow.add(tile);
            }
            board.add(boardRow);
        }
        return new Game(new Board(board));
    }

}
