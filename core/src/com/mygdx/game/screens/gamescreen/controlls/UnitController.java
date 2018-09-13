package com.mygdx.game.screens.gamescreen.controlls;

import com.badlogic.gdx.Screen;
import com.mygdx.game.screens.gamescreen.entities.Unit;

/**
 * class who will take contoll about unit
 * and can pass this control to another clases or listeners
 */
public class UnitController{
    Screen game;
    Unit unit;
    public UnitController(Screen game, Unit unit){
        this.game=game;
        this.unit=unit;
    }
    public void jump(){
        unit.jump();
    }
    public void startMovingRight(){
        unit.startMovingRight();
    }
    public void stopMovingRight(){
        unit.stopMovingRight();
    }
    public void startMovingLeft(){
        unit.startMovingLeft();
    }
    public void left(){
        unit.left();
    }
}
