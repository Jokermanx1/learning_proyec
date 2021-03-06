package com.mygdx.game.settings;

public final class Constants {
    public final static Boolean DEBUG = true;
    public final static String TITLE = "Runner";
    //Size of the windows
    public final static int WIDTH = 960;
    public final static int HEIGHT = 680;
    //Size of the camera. They don't need to be the same. The bigger the size of the camera is, the farther the
    // character will be
    public final static float WIDTH_RATIO = WIDTH*1f;
    public final static float HEIGHT_RATIO = HEIGHT*1f;

    public final static float GRAVITY = -9.8f;
    public final static float PPM = 100f;
    public final static float ACELERATION = 20f;
    public final static float F_SPEED = 30f;
    public final static float MAX_SPEED = 300f;
    public final static float JUMP = 500f;
    public final static float CAMERA_SMOOTHING = 0.3f;

    public enum MOVING_STATES { MOVING_RIGHT, MOVING_LEFT,STOPPED}


    /**
     * COLLISION FILTERS
     */
    public final static short BIT_GROUND = 2;
    public final static short BIT_CHARACTER = 4;
    public final static short BIT_PLATROFORM = 8;
    public final static short BIT_COIN = 16;
    public final static short BIT_FULL = 255;
}
