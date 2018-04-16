package com.mygdx.game.screens.gamescreen;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.MyGdxGame;

/**
 * Creating main game class
 * with all game mechanics
 * using assets from main asset class
 * things to use
 * scene
 * actors
 * box2d
 * bodys
 */
public class MainGameScreen implements Screen {
    private MyGdxGame game;
    private World world;
    protected OrthographicCamera camera;
    Box2DDebugRenderer b2dr;
    public MainGameScreen(MyGdxGame game){
        this.game = game;
        camera = new OrthographicCamera();
        world = new World(new Vector2(0,-9.81f),true);

        //box2d
        b2dr = new Box2DDebugRenderer();

        BodyDef bdef = new BodyDef();
        bdef.position.set(160,120);
        bdef.type = BodyDef.BodyType.StaticBody;
        Body body = world.createBody(bdef);

        PolygonShape sh = new PolygonShape();
        sh.setAsBox(50,5);

        FixtureDef fxd = new FixtureDef();
        fxd.shape = sh;
        body.createFixture(fxd);
    }

    /**
     * Called when this screen becomes the current screen for a .
     */
    @Override
    public void show() {

    }

    public void update(float delta) {
        world.step(delta,6,2);
    }
    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        update(delta);
        //Gdx.gl.glClearColor((float)0.14, 0, (float)0.66, 1);;
        Gdx.gl.glClearColor((float)0, 0, (float)0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        b2dr.render(world,camera.combined);
    }

    /**
     * @param width
     * @param height
     * @see ApplicationListener#resize(int, int)
     */
    @Override
    public void resize(int width, int height) {

    }

    /**
     * @see ApplicationListener#pause()
     */
    @Override
    public void pause() {

    }

    /**
     * @see ApplicationListener#resume()
     */
    @Override
    public void resume() {

    }

    /**
     * Called when this screen is no longer the current screen for a Game.
     */
    @Override
    public void hide() {

    }

    /**
     * Called when this screen should release all resources.
     */
    @Override
    public void dispose() {

    }
}
