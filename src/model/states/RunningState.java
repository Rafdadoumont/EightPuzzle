package model.states;

import model.Game;

public class RunningState implements GameState{

    @Override
    public void start(StateContext context) {
        throw new RuntimeException("Game is running");
    }

    @Override
    public void end(StateContext context) {
        context.setGameState(new GoalState());
    }
}
