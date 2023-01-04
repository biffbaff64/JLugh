package com.richikin.jlugh.physics;

import com.badlogic.gdx.math.Rectangle;
import com.richikin.enums.GraphicID;
import com.richikin.enums.TileID;
import com.richikin.jlugh.entities.IEntityComponent;

public interface ICollideUtils
{
    CollisionObject newObject();

    CollisionObject newObject( Rectangle rectangle );

    CollisionObject newObject( int x, int y, int width, int height, GraphicID graphicID );

    void tidy();

    boolean canCollide( IEntityComponent entity, IEntityComponent target );

    boolean filter( short theEntityFlag, short theCollisionBoxFlag );

    TileID getMarkerTileOn( int x, int y );

    int getXBelow( IEntityComponent spriteObj );

    int getYBelow( IEntityComponent spriteObj );

    CollisionObject getBoxHittingTop( IEntityComponent spriteObject );

    CollisionObject getBoxHittingBottom( IEntityComponent spriteObject );

    CollisionObject getBoxHittingLeft( IEntityComponent spriteObject );

    CollisionObject getBoxHittingRight( IEntityComponent spriteObject );
}
