package model.states;

import model.Game;

public class GoalState implements GameState{
    @Override
    public void start(StateContext context) {
        throw new RuntimeException("Game is finished");
    }

    @Override
    public void end(StateContext context) {
        throw new RuntimeException("Game is finished");
    }
}
