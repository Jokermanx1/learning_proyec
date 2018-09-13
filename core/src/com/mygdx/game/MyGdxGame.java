package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mygdx.game.screens.gamescreen.MainGameScreen;
import com.mygdx.game.screens.menu.MainMenu;

public class MyGdxGame extends Game {

	private Screen gameScreen;

	@Override
	public void create () {
		OwlAssets.load();
		while(!OwlAssets.manager.update()){

		}
		gameScreen= new MainMenu(this);
		setScreen(gameScreen);
	}
	public void startGame(String action){
		if(action.equals("main")){
			gameScreen.dispose();
			//lauching game screen
            gameScreen= new MainGameScreen(this);
			setScreen(gameScreen);
		}
	}
	@Override
	public void dispose () {
		gameScreen.dispose();
		System.exit(0);
		Gdx.app.exit();
	}
}
