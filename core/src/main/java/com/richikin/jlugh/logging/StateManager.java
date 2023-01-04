package com.richikin.jlugh.logging;

import com.richikin.enums.StateID;

public class StateManager
{
    private StateID currentState;

    public StateManager( StateID _state )
    {
        currentState = _state;
    }

    public StateManager()
    {
        currentState = StateID._INACTIVE;
    }

    public void set( StateID _state )
    {
        currentState = _state;
    }

    public StateID peek()
    {
        return currentState;
    }

    public boolean equalTo( StateID state )
    {
        return state.compareTo( peek() ) == 0;
    }

    public boolean after( StateID state )
    {
        return state.compareTo( peek() ) < 0;
    }
}
