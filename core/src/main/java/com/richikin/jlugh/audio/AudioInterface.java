package com.richikin.jlugh.audio;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public interface AudioInterface
{
    void setup();

    void update();

    void playTune( boolean play );

    void playGameTune( boolean playTune );

    void playTitleTune( boolean playTune );

    void playHiScoreTune( boolean playTune );

    void startTune( int musicNumber, int volume, boolean looping );

    void startSound( int soundNumber );

    void tuneStop();

    int getMusicVolume();

    void setMusicVolume( int volume );

    int getFXVolume();

    void setFXVolume( int volume );

    void saveMusicVolume();

    void saveFXVolume();

    int getMusicVolumeSave();

    int getFXVolumeSave();

    int getDefaultMusicVolume();

    int getDefaultFXVolume();

    Sound[] getSoundsTable();

    Music[] getMusicTable();

    boolean isTunePlaying();

    @SuppressWarnings( "BooleanMethodIsAlwaysInverted" )
    boolean isTunePlaying( int tune );
}
