package model.states;

import model.Game;

public interface GameState {
    void start(StateContext context);

    void end(StateContext context);


}
