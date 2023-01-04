package com.richikin.enums;

public enum StateID
{
    _STATE_MAIN_MENU,
    _STATE_SETTINGS_SCREEN,
    _STATE_DEVELOPER_MENU_SCREEN,
    _STATE_CREDITS_SCREEN,
    _STATE_LOADING_SCREEN,
    _STATE_LEVEL_SELECT_SCREEN,
    _STATE_EXIT_SCREEN,
    _STATE_HISCORE_SCREEN,
    _STATE_ACHIEVEMENTS_SCREEN,
    _STATE_STATS_SCREEN,
    _STATE_PRIVACY_POLICY_SCREEN,
    _STATE_ENDGAME_SCREEN,

    _STATE_MENU_UPDATE,
    _STATE_SETUP,
    _STATE_GET_READY,
    _STATE_GAME,
    _STATE_PREPARE_GAME_OVER_MESSAGE,
    _STATE_GAME_FINISHED,
    _STATE_GAME_OVER,
    _STATE_END_GAME,
    _STATE_PAUSED,
    _STATE_PREPARE_LEVEL_RETRY,
    _STATE_LEVEL_RETRY,
    _STATE_PREPARE_LEVEL_FINISHED,
    _STATE_LEVEL_FINISHED,
    _STATE_DEV_RESTART_LEVEL1,
    _STATE_PLAY_ADVERT,
    _STATE_NEW_HISCORE,
    _STATE_YES_NO_DIALOG,

    _STATE_MESSAGE_PANEL,
    _STATE_DEVELOPER_PANEL,
    _STATE_SETTINGS_PANEL,
    _STATE_WELCOME_PANEL,

    _STATE_PANEL_START, _STATE_PANEL_INTRO, _STATE_PANEL_UPDATE, _STATE_PANEL_CLOSE,

    _INACTIVE, _LIMBO, _INIT, _UPDATE, _CLOSE,

    _STATE_OPEN, _STATE_OPENING, _STATE_CLOSING, _STATE_CLOSED,

    _STATE_CLOSING_MAINSCENE,
    
    _STATE_TRIGGER_FADE_IN, _STATE_TRIGGER_FADE_OUT, _STATE_FADE_IN, _STATE_FADE_OUT,

    _STATE_FLASHING, _STATE_STEADY,

    _STATE_ENABLED, _STATE_DISABLED,

    _STATE_ZOOM_IN, _STATE_ZOOM_OUT,

    _STATE_POWER_UP, _STATE_POWER_DOWN,

    _STATE_BEGIN_STARTUP, _STATE_END_STARTUP,

    _STATE_DEBUG_HANG,
}
