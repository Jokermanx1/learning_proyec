package com.mygdx.game.screens.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.OwlAssets;

public class MainMenu  implements Screen {
	protected OrthographicCamera camera;
	private Stage stage;
	private MenuButton StartGame, exit,main;
	MyGdxGame developmentTest;
	public MainMenu(MyGdxGame developmentTest){
		camera = new OrthographicCamera();
		this.developmentTest = developmentTest;
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		//OwlAssets.load();
		while(!OwlAssets.manager.update()){
			
		}
		stage = new Stage();
		main = new MenuButton("main", this, Gdx.graphics.getWidth()/2-MenuButton.WIDTH/2, 240);
		exit = new MenuButton("exit", this, Gdx.graphics.getWidth()/2-MenuButton.WIDTH/2, 170);

		stage.addActor(main);
		stage.addActor(exit);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor((float)0.14, 0, (float)0.46, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act();
		stage.draw();
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
		//OwlAssets.dispose();
	}
	public void startGame(String action) {
		// TODO Auto-generated method stub
		developmentTest.startGame(action);
	}
	
	public void makeAction(String action){
		if(action.equals("exit")){
            developmentTest.dispose();
		}else {
			startGame(action);
		}
	} 
}
