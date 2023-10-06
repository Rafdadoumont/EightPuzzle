package model;

import java.util.List;

public class Board {
    private int N;
    private List<List<Tile>> tiles;


    public Board(List<List<Tile>> tiles) {
        N = tiles.size();
        this.tiles = tiles;
    }

    public List<List<Tile>> getTiles() {
        return tiles;
    }

    public void setTiles(List<List<Tile>> tiles) {
        this.tiles = tiles;
    }

    public int getDimension() {
        return N;
    }

    public Tile getTile(int x, int y) {
        return tiles.get(x).get(y);
    }

    public boolean isGoal() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (getTile(i, j).getValue() != (i * N + j)) {
                    return false;
                }
            }
        }
        return true;
    };
}
