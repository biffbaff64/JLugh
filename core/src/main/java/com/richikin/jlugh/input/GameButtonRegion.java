package com.richikin.jlugh.input;

import com.badlogic.gdx.graphics.Color;
import com.richikin.jlugh.config.StandardSettings;
import com.richikin.jlugh.core.GdxApp;
import com.richikin.jlugh.maths.shapes.Box;

public class GameButtonRegion extends Switch
{
    private final Box region;

    public GameButtonRegion( int x, int y, int width, int height )
    {
        super();

        this.region = new Box( x, y, width, height );
    }

    public boolean contains( int x, int y )
    {
        return ( region.contains( x, y ) );
    }

    public void draw()
    {
        if ( GdxApp.getDev().isDevMode()
            && GdxApp.getSettings().isEnabled( StandardSettings._BUTTON_BOXES ) )
        {
            GdxApp.getAABBRenderer().drawRect( region.x, region.y, region.width, region.height, 2, Color.WHITE );
        }
    }

    @Override
    public Type getType()
    {
        return Type._BUTTON_REGION;
    }
}
