package model.states;

public class StateContext {
    private GameState state;

    public StateContext() {
        state = new StartState();
    }

    public void setGameState(GameState state) {
        this.state = state;
    }

    public GameState getState() {
        return state;
    }
}
