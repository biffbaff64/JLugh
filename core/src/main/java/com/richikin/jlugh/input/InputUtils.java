package com.richikin.jlugh.input;

import com.badlogic.gdx.math.Vector2;
import com.richikin.jlugh.config.GdxSystem;
import com.richikin.jlugh.core.GdxApp;
import com.richikin.jlugh.input.controllers.ControllerType;

public class InputUtils
{
    public static float getJoystickAngle()
    {
        return getJoystickVector().angleDeg();
    }

    public static Vector2 getJoystickVector()
    {
        float xPerc = GdxApp.getInputManager().getVirtualJoystick().getTouchpad().getKnobPercentX();
        float yPerc = GdxApp.getInputManager().getVirtualJoystick().getTouchpad().getKnobPercentY();

        Vector2 vector2 = new Vector2( xPerc, yPerc );

        return vector2.rotate90( -1 );
    }

    public static boolean isInputAvailable( ControllerType _inputType )
    {
        return GdxSystem.inst().availableInputs.contains( _inputType, true );
    }
}
