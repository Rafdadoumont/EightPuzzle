package model.states;

import model.Game;

public class StartState implements GameState{

    @Override
    public void start(StateContext context) {
        context.setGameState(new StartState());
    }

    @Override
    public void end(StateContext context) {
        throw new RuntimeException("Game not running");
    }
}
