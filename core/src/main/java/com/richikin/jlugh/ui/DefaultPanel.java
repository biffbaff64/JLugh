package com.richikin.jlugh.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.richikin.enums.StateID;
import com.richikin.jlugh.logging.NotImplementedException;
import com.richikin.jlugh.logging.StateManager;
import com.richikin.jlugh.maths.SimpleVec2F;
import com.richikin.jlugh.maths.Vec2F;
import com.richikin.jlugh.physics.Direction;

/**
 * Basic UI Panel class.
 * All other panels should extend this class.
 */
public abstract class DefaultPanel implements IUserInterfacePanel
{
    private static final int _DEFAULT_X_SIZE = 16;
    private static final int _DEFAULT_Y_SIZE = 16;

    private StateManager stateManager;
    private Vec2F        position;

    protected       TextureRegion textureRegion;
    protected       String        nameID;
    protected       boolean       isActive;
    protected final boolean       isImageDrawable;
    protected       Table         table;
    protected       Skin          skin;
    protected       ScrollPane    scrollPane;

    public DefaultPanel()
    {
        this.stateManager    = new StateManager();
        this.position        = new Vec2F();
        this.isActive        = false;
        this.isImageDrawable = false;
        this.nameID          = "unnamed";
    }

    @Override
    public void open()
    {
        setup();
    }

    @Override
    public void close()
    {
        dispose();
    }

    @Override
    public boolean update()
    {
        return false;
    }

    @Override
    public void draw( SpriteBatch spriteBatch )
    {
    }

    @Override
    public boolean nameExists( String _nameID )
    {
        return _nameID.equals( this.nameID );
    }

    @Override
    public int getWidth()
    {
        return textureRegion.getRegionWidth();
    }

    @Override
    public int getHeight()
    {
        return textureRegion.getRegionHeight();
    }

    @Override
    public Vec2F getPosition()
    {
        return position;
    }

    @Override
    public void setPosition( float x, float y )
    {
        position.x = x;
        position.y = y;
    }

    @Override
    public String getNameID()
    {
        return nameID;
    }

    @Override
    public void setNameID( String _name )
    {
        this.nameID = _name;
    }

    @Override
    public boolean getActiveState()
    {
        return isActive;
    }

    @Override
    public void activate()
    {
        isActive = true;
    }

    @Override
    public void deactivate()
    {
        isActive = false;
    }

    @Override
    public StateID getState()
    {
        return stateManager.peek();
    }

    @Override
    public void setState( StateID _state )
    {
        stateManager.set( _state );
    }


    // -------------------------------------------------------------------
    // Empty methods from IDefaultPanel interface
    @Override
    public void initialise( TextureRegion _region, String _nameID, Object... args )
    {
        throw new NotImplementedException( "ERROR - method not implemented!" );
    }

    @Override
    public void set( SimpleVec2F xy, SimpleVec2F distance, Direction direction, SimpleVec2F speed )
    {
        throw new NotImplementedException( "ERROR - method not implemented!" );
    }

    @Override
    public void setup()
    {
        throw new NotImplementedException( "ERROR - method not implemented!" );
    }

    @Override
    public void populateTable()
    {
        throw new NotImplementedException( "ERROR - method not implemented!" );
    }

    @Override
    public void setPauseTime( final int _time )
    {
        throw new NotImplementedException( "ERROR - method not implemented!" );
    }

    @Override
    public void forceZoomOut()
    {
        throw new NotImplementedException( "ERROR - method not implemented!" );
    }

    // -------------------------------------------------------------------
    // From Disposable Interface
    @Override
    public void dispose()
    {
        stateManager  = null;
        position      = null;
        textureRegion = null;
        nameID        = null;
        skin          = null;

        if ( table != null )
        {
            table.clear();
            table.addAction( Actions.removeActor() );
            table = null;
        }

        if ( scrollPane != null )
        {
            scrollPane.clear();
            scrollPane.addAction( Actions.removeActor() );
            scrollPane = null;
        }
    }
}
