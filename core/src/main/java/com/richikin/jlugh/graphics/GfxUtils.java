package com.richikin.jlugh.graphics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface GfxUtils
{
    void splitRegion( TextureRegion srcRegion, int frameWidth, int frameHeight, TextureRegion[] destinationFrames );

    void drawRect( int x, int y, int width, int height, int thickness, Color color );

    void drawRect( int x, int y, int width, int height, int thickness );
}
