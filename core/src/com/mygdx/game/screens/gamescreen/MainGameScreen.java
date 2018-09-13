package com.mygdx.game.screens.gamescreen;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.screens.gamescreen.controlls.KeyboardListener;
import com.mygdx.game.screens.gamescreen.controlls.UnitController;
import com.mygdx.game.screens.gamescreen.entities.Block;
import com.mygdx.game.screens.gamescreen.entities.Unit;
import com.mygdx.game.settings.Constants;

import static com.mygdx.game.settings.Constants.CAMERA_SMOOTHING;
import static com.mygdx.game.settings.Constants.GRAVITY;

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
    private Stage stage;
    private Unit unit;
    private SpriteBatch batch;



    private InputMultiplexer multiplexor;
    private InputProcessor mouseListener,keyboardListener;
    private UnitController unitController;

    public MainGameScreen(MyGdxGame game){
        /*
        STARTING VARIABLES
        window variables
         */
        this.game = game;
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        /**
         * Camera block, for now useless
         */
        camera = new OrthographicCamera();
        /*
        camera = new OrthographicCamera(30, 30 * (h / w));

        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();

        /**
         *
         *
         */


        /*
        creating worlds
         */
        world = new World(new Vector2(0,GRAVITY),true);

        //box2d
        b2dr = new Box2DDebugRenderer();

        batch = new SpriteBatch();

        stage = new Stage();
        for(int i=0;i<25;i++) {
            Block block = new Block(world, 32, 32, -32, i*16);
            stage.addActor(block);
        }
        for(int i=0;i<50;i++) {
            Block block = new Block(world, 32, 32, i*32, 16);

            stage.addActor(block);
        }
        for(int i=0;i<15;i++) {
            Block block = new Block(world, 32, 32, 100+i*32, 132);

            stage.addActor(block);
        }

        /*
        creating unit
         */
        unit = new Unit(world, 32, 32, 100+32, 250);

        stage.addActor(unit);



        /*
        starting controllers
         */
        unitController = new UnitController(this, unit);
        keyboardListener=new KeyboardListener(unitController);
        multiplexor = new InputMultiplexer();
        multiplexor.addProcessor(keyboardListener);
        Gdx.input.setInputProcessor(multiplexor);

    }

    /**
     * Called when this screen becomes the current screen for a .
     */
    @Override
    public void show() {

    }

    /**
     * will be called before anithing in the render
     * here should be actualizated everithing
     * @param delta
     */
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

        Gdx.graphics.setTitle(Constants.TITLE + " -- FPS: " + Gdx.graphics.getFramesPerSecond());
        update(delta);
        //Gdx.gl.glClearColor((float)0.14, 0, (float)0.66, 1);;
        Gdx.gl.glClearColor((float)0, 0, (float)0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //b2dr.render(world,batch.getProjectionMatrix());
        //camera.position.lerp(new Vector3(unit.getPosition(), camera.position.z), CAMERA_SMOOTHING);
        //camera.update();
        batch.begin();
        //b2dr.render(world,camera.combined);
        b2dr.render(world,batch.getProjectionMatrix());
        batch.end();

        stage.act();
        stage.draw();
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
        world.dispose();
        b2dr.dispose();
    }
}
