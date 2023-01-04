package com.richikin.jlugh.desktop;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.richikin.jlugh.LughMain;

public class DesktopLauncher
{
    public static void main(String[] args)
    {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Lugh Utils Library";
        config.width = 800;
        config.height = 480;
        config.vSyncEnabled = true;
        config.foregroundFPS = 60;

        new LwjglApplication(new LughMain(), config);
    }
}
