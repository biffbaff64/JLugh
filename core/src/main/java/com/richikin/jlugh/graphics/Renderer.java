package com.richikin.jlugh.graphics;

import com.badlogic.gdx.utils.Disposable;
import com.richikin.enums.CamID;
import com.richikin.jlugh.graphics.camera.OrthoGameCamera;
import com.richikin.jlugh.graphics.camera.Zoom;
import com.richikin.jlugh.graphics.parallax.ParallaxBackground;
import org.jetbrains.annotations.NotNull;

public interface Renderer extends Disposable
{
    void createCameras();

    void render();

    void resizeCameras( int width, int height );

    void resetCameraZoom();

    void enableCamera( @NotNull CamID... cameraList );

    void enableAllCameras();

    void disableAllCameras();

    void disableLerping();

    OrthoGameCamera getHudGameCamera();

    OrthoGameCamera getOverlayCamera();

    OrthoGameCamera getSpriteGameCamera();

    OrthoGameCamera getTiledGameCamera();

    OrthoGameCamera getParallaxCamera();

    Zoom getGameZoom();

    Zoom getHudZoom();

    boolean isDrawingStage();

    ParallaxBackground getParallaxBackground();
}
