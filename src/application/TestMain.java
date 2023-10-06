package application;

import model.Game;
import model.GameFactory;

public class TestMain {

    public static void main(String[] args) {

        GameFactory factory = new GameFactory();

        Game game = factory.generateRandomGame(3);

        System.out.println(game.toString());

    }

}
