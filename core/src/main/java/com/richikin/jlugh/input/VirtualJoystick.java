package com.richikin.jlugh.input;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.richikin.jlugh.core.GdxApp;
import com.richikin.jlugh.physics.Dir;

public class VirtualJoystick
{
    private static final float PAD_X      = 10;
    private static final float PAD_Y      = 10;
    private static final float PAD_WIDTH  = 240;
    private static final float PAD_HEIGHT = 240;

    private Touchpad touchpad;

    public VirtualJoystick()
    {
    }

    public void create()
    {
        Skin touchpadSkin = new Skin();
        touchpadSkin.add("background", new Texture("touch_background.png"));
        touchpadSkin.add("ball", new Texture("joystick_ball.png"));

        Touchpad.TouchpadStyle touchpadStyle = new Touchpad.TouchpadStyle();

        Drawable touchBackground = touchpadSkin.getDrawable("background");
        Drawable touchKnob       = touchpadSkin.getDrawable("ball");

        touchpadStyle.background = touchBackground;
        touchpadStyle.knob       = touchKnob;

        touchpad = new Touchpad(1, touchpadStyle);
        touchpad.setBounds(PAD_X, PAD_Y, PAD_WIDTH, PAD_HEIGHT);
        touchpad.setResetOnTouchUp(true);

        GdxApp.getStage().addActor(touchpad);

        hide();
    }

    public void update()
    {
        switch ( evaluateJoypadDirection() )
        {
            case _UP:
                break;
            case _DOWN:
                break;
            case _LEFT:
                break;
            case _RIGHT:
                break;
            case _UP_LEFT:
                break;
            case _UP_RIGHT:
                break;
            case _DOWN_LEFT:
                break;
            case _DOWN_RIGHT:
                break;
            default:
                break;
        }
    }

    public void show()
    {
        if (touchpad != null)
        {
            touchpad.addAction(Actions.show());
        }
    }

    public void hide()
    {
        if (touchpad != null)
        {
            touchpad.addAction(Actions.hide());
        }
    }

    //@formatter:off
    public float    getXPercent() { return touchpad.getKnobPercentX();  }
    public float    getYPercent() { return touchpad.getKnobPercentY();  }
    public Touchpad getTouchpad() { return touchpad;                    }
    //@formatter:on

    private Dir evaluateJoypadDirection()
    {
        Dir joyDir;

        //
        // The default angle for joystick goes round anti-clockwise,
        // so modify so that the result is now clockwise.
        int angle = Math.abs((int) (InputUtils.getJoystickAngle() - 360));

        joyDir = DirectionMap.map[angle / 10].translated;

        GdxApp.getInputManager().setLastRegisteredDirection(joyDir);

        return joyDir;
    }

    public void removeTouchpad()
    {
        if (touchpad != null)
        {
            touchpad.addAction(Actions.removeActor());
            touchpad = null;
        }
    }
}
