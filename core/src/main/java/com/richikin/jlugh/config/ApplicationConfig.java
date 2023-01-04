package com.richikin.jlugh.config;

public interface ApplicationConfig
{
    void setup();

    void startApp();

    void closeStartup();

    boolean isStartupDone();

    boolean isUsingAshleyECS();

    boolean gameScreenActive();

    void setControllerTypes();

    boolean isUsingOnScreenControls();

    void freshInstallCheck();

    void pause();

    void unPause();
}
