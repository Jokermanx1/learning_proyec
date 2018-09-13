package com.mygdx.game.screens.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class MenuButton extends Actor{

	public String action;
	private MainMenu menu;
	Texture texture;
	BitmapFont font;


	protected static final int WIDTH = 250;
	protected static final int HEIGHT = 80;
	public MenuButton(String act, MainMenu m,int x, int y){
		this.action=act;
		this.menu=m;
        //texture = (Texture)OwlAssets.manager.get("buttons/"+action+".png");



		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
				Gdx.files.internal("bitwise.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 82;
		parameter.characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.!'()";
		//e.g. abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.!'()>?:
		// These characters should not repeat!

		font = generator.generateFont(parameter);
		font.setColor((float)0.14, 0, (float)0.82, 1);
		generator.dispose();



        setWidth(WIDTH);
        setHeight(HEIGHT);
        setBounds(x, y, getWidth(), getHeight());
        setTouchable(Touchable.enabled);
        setVisible(true);
        addListener(new InputListener() {
        	/**
        	 * adding listener for button clicked
        	 */
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                //Gdx.app.debug(TestGame.TAG, "TestActor.touchDown()");
            	menu.makeAction(action);
                return true;  // must return true for touchUp event to occur
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            	
            }
            /**
             * detection enter mouse in button area
             */
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
				font.setColor((float)0.14, 22, (float)0.82, 1);
        	}
            /**
             * detection exit mouse from button area
             */
            public void exit (InputEvent event, float x, float y, int pointer, Actor fromActor) {
				font.setColor((float)0.14, 0, (float)0.82, 1);
        	}
        });
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
		//batch.draw(texture, getX(), getY());
		font.draw(batch, action, getX(), getY()+this.getHeight());
	}
}
