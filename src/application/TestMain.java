package application;

import model.game.Board;
import model.game.Game;
import model.game.GameFactory;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        GameFactory gameFactory = new GameFactory();

        Game game = gameFactory.generateRandomGame(3);

        System.out.println(game.toString());

        System.out.println(game.getBoard().getHeuristic());

        List<Board> successors = game.getSuccessors();

        for (Board board : successors) {
            System.out.println(board.toString());
        }
    }
}
