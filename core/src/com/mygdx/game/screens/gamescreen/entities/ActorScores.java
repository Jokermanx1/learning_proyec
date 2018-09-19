package com.mygdx.game.screens.gamescreen.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mygdx.game.screens.gamescreen.MainGameScreen;
import com.mygdx.game.screens.menu.MainMenu;

public class ActorScores extends Actor {
    BitmapFont font;
    MainGameScreen gamescreen;


    protected static final int WIDTH = 250;
    protected static final int HEIGHT = 80;
    public ActorScores(MainGameScreen gamescreen){
        this.gamescreen = gamescreen;
        setX(gamescreen.getScreenWidth()-50);
        setY(gamescreen.getScreenHeight()-25);
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
                Gdx.files.internal("bitwise.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 32;
        parameter.characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.!'()";
        //e.g. abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.!'()>?:
        // These characters should not repeat!

        font = generator.generateFont(parameter);
        font.setColor((float)0.14, 0, (float)0.82, 1);
        generator.dispose();



        setWidth(WIDTH);
        setHeight(HEIGHT);
        setBounds(getX(), getY(), getWidth(), getHeight());
        setTouchable(Touchable.enabled);
        setVisible(true);
    }

    /**
     *
     */
    @Override
    public void act(float delta) {
        // TODO Auto-generated method stub
        super.act(delta);
    }

    /**
     * draving button
     */
    public void draw(Batch batch, float parentAlpha){
        font.draw(batch, Integer.toString(gamescreen.getCoins()), getX(), getY());
    }

}
