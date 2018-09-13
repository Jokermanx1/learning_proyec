package com.mygdx.game.screens.gamescreen.controlls;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.mygdx.game.screens.gamescreen.entities.Unit;

public class KeyboardListener extends InputAdapter {
    UnitController controller;
    public KeyboardListener(UnitController controller){
        this.controller = controller;
    }
    @Override
    public boolean keyDown(int keycode) {
        switch(keycode){
            case Input.Keys.RIGHT:
                controller.startMovingRight();
                break;
            case Input.Keys.LEFT:
                controller.startMovingLeft();
                break;

        }
        return true;
    }
    @Override
    public boolean keyUp(int keycode) {
        switch(keycode){
            case Input.Keys.RIGHT:
                controller.stopMovingRight();
                break;
            case Input.Keys.SPACE:
                controller.jump();
                break;
            case Input.Keys.UP:
                controller.jump();
                break;
            case Input.Keys.LEFT:
                controller.left();
                break;

        }
        return true;
    }
}
