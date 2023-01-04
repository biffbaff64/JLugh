package com.richikin.jlugh.physics.aabb;

import com.richikin.jlugh.physics.CollisionObject;

public interface AABBCollisionCallback
{
    void onPositiveCollision( CollisionObject cobjHitting );

    void onNegativeCollision();
}
