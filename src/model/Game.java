package model;

import model.states.StateContext;

import java.util.List;

public class Game {

    private Board board;
    private final StateContext context;

    public Game(Board board) {
        this.board = board;
        context = new StateContext();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public StateContext getContext() {
        return context;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (List<Tile> row: board.getTiles()) {
            for (Tile tile: row) {
                stringBuilder.append(tile.getValue()).append(" ");
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
