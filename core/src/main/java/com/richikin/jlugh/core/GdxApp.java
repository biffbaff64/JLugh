package com.richikin.jlugh.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.richikin.enums.StateID;
import com.richikin.jlugh.assets.Assets;
import com.richikin.jlugh.audio.AudioInterface;
import com.richikin.jlugh.config.ApplicationConfig;
import com.richikin.jlugh.config.Developer;
import com.richikin.jlugh.config.GdxSystem;
import com.richikin.jlugh.config.Settings;
import com.richikin.jlugh.entities.EntityData;
import com.richikin.jlugh.google.AdsController;
import com.richikin.jlugh.google.PlayServices;
import com.richikin.jlugh.google.PlayServicesData;
import com.richikin.jlugh.input.InputInterface;
import com.richikin.jlugh.logging.StateManager;
import com.richikin.jlugh.physics.aabb.AABBRenderer;

// ------------------------------------------------------------------
// Code
// ------------------------------------------------------------------

public class GdxApp
{
    // ---------------------------------------------
    protected static AdsController     adsController;
    protected static PlayServices      googleServices;
    protected static PlayServicesData  playServicesData;
    // ---------------------------------------------
    protected static Settings          settings;
    protected static Assets            assets;
    protected static ApplicationConfig appConfig;
    protected static Developer         developer;
    // ---------------------------------------------
    protected static SpriteBatch       spriteBatch;
    protected static Stage             stage;
    protected static AABBRenderer      aabbRenderer;
    // ---------------------------------------------
    protected static HighScoreUtils    highScoreUtils;
    protected static StateManager      appState;
    protected static AudioInterface    audio;
    protected static InputInterface    inputManager;
    protected static EntityData        entityData;

    // ------------------------------------------------
    // CODE
    // ------------------------------------------------

    public static void createObjects()
    {
        appState     = new StateManager( StateID._STATE_POWER_UP );
        spriteBatch  = new SpriteBatch();
        aabbRenderer = new AABBRenderer();
        entityData   = new EntityData();
    }

    // ------------------------------------------------
    //@formatter:off
    public static AdsController         getAdsController()      {   return adsController;       }
    public static PlayServices          getPlayServices()       {   return googleServices;      }
    public static PlayServicesData      getPlayServicesData()   {   return playServicesData;    }

    public static Settings              getSettings()           {   return settings;            }
    public static Assets                getAssets()             {   return assets;              }
    public static ApplicationConfig     getAppConfig()          {   return appConfig;           }
    public static AudioInterface        getAudio()              {   return audio;               }
    public static InputInterface        getInputManager()       {   return inputManager;        }
    public static HighScoreUtils        getHighScoreUtils()     {   return highScoreUtils;      }
    public static StateManager          getAppState()           {   return appState;            }
    public static EntityData            getEntityData()         {   return entityData;          }
    public static Developer             getDev()                {   return developer;           }

    public static Stage                 getStage()              {   return stage;               }
    public static SpriteBatch           getSpriteBatch()        {   return spriteBatch;         }
    public static AABBRenderer          getAABBRenderer()       {   return aabbRenderer;        }

    public static void  setAdsController( AdsController controller )    {   adsController = controller; }
    public static void  setPlayServices( PlayServices services )        {   googleServices = services;  }
    public static void  setPlayServicesData( PlayServicesData psData )  {   playServicesData = psData;  }
    public static void  setSettings( Settings _settings )               {   settings = _settings;       }
    public static void  setAppConfig( ApplicationConfig config )        {   appConfig = config;         }
    public static void  setAssets( Assets _assets )                     {   assets = _assets;           }
    public static void  setAudio( AudioInterface _audio )               {   audio = _audio;             }
    public static void  setInputManager( InputInterface manager )       {   inputManager = manager;     }
    public static void  setDeveloper( Developer dev )                   {   developer = dev;            }
    //@formatter:on
    // ------------------------------------------------

    public static void createStage( Viewport viewport )
    {
        stage = new Stage( viewport, getSpriteBatch() );
    }

    // ------------------------------------------------
    public static void tidy()
    {
        stage.dispose();
        spriteBatch.dispose();
        assets.dispose();
        settings.dispose();
        entityData.dispose();

        if ( GdxSystem.inst().isAndroidApp() )
        {
            googleServices.signOut();
        }

        adsController    = null;
        googleServices   = null;
        playServicesData = null;
        inputManager     = null;
        appState         = null;
        settings         = null;
        appConfig        = null;
        assets           = null;
        audio            = null;
        highScoreUtils   = null;
        entityData       = null;
        spriteBatch      = null;
        stage            = null;
        aabbRenderer     = null;
    }
}
