package com.richikin.jlugh.graphics.camera;

import com.badlogic.gdx.math.Vector3;
import com.richikin.jlugh.maths.SimpleVec3F;

public interface IGameCamera
{
    void setPosition( SimpleVec3F _position, float _zoom );

    void setPosition( SimpleVec3F _position, float _zoom, boolean _shake );

    Vector3 getPosition();

    void setPosition( SimpleVec3F _position );

    void updatePosition( float targetX, float targetY );

    void lerpTo( SimpleVec3F _position, float _speed );

    void lerpTo( SimpleVec3F _position, float _speed, float _zoom, boolean _shake );

    void updateZoom( float _targetZoom, float _speed );

    void resizeViewport( int _width, int _height, boolean _centerCamera );

    float getCameraZoom();

    void setCameraZoom( float _zoom );

    void setZoomDefault( float _zoom );

    float getDefaultZoom();

    void reset();

    void debug();
}
