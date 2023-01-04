package com.richikin.jlugh.config;

import com.badlogic.gdx.utils.Disposable;

public interface Settings extends Disposable
{
    void createPreferencesObject( String prefsName );

    boolean isEnabled( final String preference );

    boolean isDisabled( final String preference );

    void enable( final String preference );

    void disable( final String preference );

    void toggleState( final String preference );

    void resetToDefaults();

    void freshInstallCheck();

    com.badlogic.gdx.Preferences getPrefs();

    void debugReport();
}
