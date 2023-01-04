package com.richikin.jlugh.config;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.Array;
import com.richikin.enums.ScreenID;
import com.richikin.jlugh.core.GdxApp;
import com.richikin.jlugh.graphics.GfxData;
import com.richikin.jlugh.input.Switch;
import com.richikin.jlugh.input.controllers.ControllerPos;
import com.richikin.jlugh.input.controllers.ControllerType;
import com.richikin.jlugh.logging.Trace;
import com.richikin.jlugh.ui.Scene2DUtils;

public class GdxSystem
{
    // -------------------------------------------------------
    private static final GdxSystem instance = new GdxSystem();

    public boolean                 isShuttingMainScene;        // Game over, back to menu screen
    public boolean                 forceQuitToMenu;            // Quit to main menu, forced via pause mode for example.
    public boolean                 gamePaused;                 // TRUE / FALSE Game Paused flag
    public boolean                 camerasReady;               // TRUE when all cameras have been created.
    public boolean                 shutDownActive;             // TRUE if game is currently processing EXIT request.
    public boolean                 entitiesExist;              // Set true when all entities have been created
    public boolean                 controllersFitted;          // TRUE if external controllers are fitted/connected.
    public boolean                 gameButtonsReady;           // TRUE When all game buttons have been defined
    public ScreenID                currentScreenID;            // ID of the currently active screeen
    public String                  currentController;          // The name of the controller being used
    public ControllerPos           virtualControllerPos;       // Virtual (on-screen) joystick position (LEFT or RIGHT)
    public Array< ControllerType > availableInputs;            // ...
    public Switch                  systemBackButton;           // ...
    public ImageButton             backButton;                 // ...

    // -------------------------------------------------------

    public static GdxSystem inst()
    {
        return instance;
    }

    public void setup()
    {
        isShuttingMainScene = false;
        forceQuitToMenu     = false;
        gamePaused          = false;
        camerasReady        = false;
        shutDownActive      = false;
        entitiesExist       = false;
        controllersFitted   = false;
        gameButtonsReady    = false;
        currentController   = "None";
        availableInputs     = new Array<>();

        if ( isDesktopApp() )
        {
            Gdx.graphics.setWindowedMode( GfxData._DESKTOP_WIDTH, GfxData._DESKTOP_HEIGHT );
        }

        virtualControllerPos = ControllerPos._HIDDEN;

        GdxApp.getAppConfig().setControllerTypes();

        systemBackButton = new Switch();
    }

    public void exit()
    {
        Trace.checkPoint();

        availableInputs.clear();
        availableInputs = null;

        currentController    = null;
        virtualControllerPos = null;
        systemBackButton     = null;

        backButton.addAction( Actions.removeActor() );
        backButton = null;

        Gdx.app.exit();
    }

    /**
     * @return TRUE if the app is running on Desktop
     */
    public boolean isDesktopApp()
    {
        return ( Gdx.app.getType() == Application.ApplicationType.Desktop );
    }

    /**
     * @return TRUE if the app is running on Android
     */
    public boolean isAndroidApp()
    {
        return ( Gdx.app.getType() == Application.ApplicationType.Android );
    }

    /**
     * @return TRUE If an external controller is fitted
     */
    public boolean isControllerFitted()
    {
        return controllersFitted;
    }

    public void addBackButton( String _default, String _pressed )
    {
        Scene2DUtils scene2DUtils = new Scene2DUtils();

        backButton = scene2DUtils.addButton( _default, _pressed, 0, 0 );
    }

    public void showAndEnableBackButton()
    {
        if ( backButton != null )
        {
            backButton.setVisible( true );
            backButton.setDisabled( false );
        }
    }

    public void hideAndDisableBackButton()
    {
        if ( backButton != null )
        {
            backButton.setVisible( false );
            backButton.setDisabled( true );
        }
    }
}
