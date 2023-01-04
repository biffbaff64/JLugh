package com.richikin.jlugh.entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Disposable;
import com.richikin.enums.ActionStates;
import com.richikin.enums.GraphicID;
import com.richikin.jlugh.physics.CollisionObject;
import com.richikin.jlugh.physics.box2d.PhysicsBody;

public interface IEntityComponent extends Disposable
{
    ActionStates getActionState();

    void setActionState( ActionStates action );

    /**
     * Gets the {@link PhysicsBody} attached to this sprite.
     */
    PhysicsBody getPhysicsBody();

    Rectangle getBodyBox();

    /**
     * Gets the current X position of the {@link PhysicsBody}
     * attached to this sprite.
     */
    float getBodyX();

    /**
     * Gets the current Y position of the {@link PhysicsBody}
     * attached to this sprite.
     */
    float getBodyY();

    void tidy( int index );

    short getBodyCategory();

    short getCollidesWith();

    int getSpriteNumber();

    int getLink();

    void setLink( int lnk );

    boolean isLinked();

    boolean isHittingSame();

    GraphicID getGID();

    GraphicID getType();

    void setDying();

    @Deprecated
    void setCollisionObject( float xPos, float yPos );

    @Deprecated
    CollisionObject getCollisionObject();
}
