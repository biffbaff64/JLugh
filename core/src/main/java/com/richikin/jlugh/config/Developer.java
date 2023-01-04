package com.richikin.jlugh.config;

import com.richikin.enums.StateID;

public interface Developer
{
    void setTempDeveloperSettings();

    void setDeveloperModeState();

    void setDevMode( boolean _state );

    void setGodMode( boolean _state );

    void setAndroidOnDesktop( boolean _state );

    boolean isAndroidOnDesktop();

    boolean isDevMode();

    boolean isGodMode();

    void setDeveloperPanelState( StateID state );

    StateID getDeveloperPanelState();

    void configReport();
}
