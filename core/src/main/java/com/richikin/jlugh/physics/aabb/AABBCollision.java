package com.richikin.jlugh.physics.aabb;

import com.richikin.jlugh.physics.CollisionObject;

public interface AABBCollision
{
    boolean checkAABBBoxes( CollisionObject boxA );

    void dispose();
}
