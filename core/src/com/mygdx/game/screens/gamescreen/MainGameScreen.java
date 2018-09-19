package com.mygdx.game.screens.gamescreen;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.screens.gamescreen.controlls.KeyboardListener;
import com.mygdx.game.screens.gamescreen.controlls.LearningContactListener;
import com.mygdx.game.screens.gamescreen.controlls.UnitController;
import com.mygdx.game.screens.gamescreen.entities.ActorScores;
import com.mygdx.game.screens.gamescreen.entities.Block;
import com.mygdx.game.screens.gamescreen.entities.Coin;
import com.mygdx.game.screens.gamescreen.entities.Unit;
import com.mygdx.game.settings.Constants;

import static com.mygdx.game.settings.Constants.*;

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
    public OrthographicCamera camera;
    Box2DDebugRenderer b2dr;
    private Stage stage;
    private Unit unit;
    private int coins;
    private float screenWidth;
    private float screenHeight;
    ActorScores score;

    private InputMultiplexer multiplexor;
    private InputProcessor mouseListener,keyboardListener;
    private UnitController unitController;

    public MainGameScreen(MyGdxGame game){
        /*
        STARTING VARIABLES
        window variables
         */
        this.game = game;
        setScreenWidth(Gdx.graphics.getWidth());
        setScreenHeight(Gdx.graphics.getHeight());
        setCoins(0);
        /**
         * Camera block, for now useless
         */

        camera = new OrthographicCamera(WIDTH_RATIO,HEIGHT_RATIO);
        camera.position.set(50, 350, camera.position.z);
        camera.update();

        /*
        creating worlds
         */
        world = new World(new Vector2(0,GRAVITY),true);

        //adding contact listener to world
        world.setContactListener(new LearningContactListener());
        //box2d
        b2dr = new Box2DDebugRenderer();

        stage = new Stage();
        for(int i=-100;i<255;i++) {
            Block block = new Block(this,world, 32, 32, -32, i*16);
            stage.addActor(block);
        }
        for(int i=0;i<250;i++) {
            Block block = new Block(this,world, 32, 32, i*32, 16);

            stage.addActor(block);
        }
        for(int i=0;i<15;i++) {
            Block block = new Block(this,world, 32, 32, 100+i*32, 132);

            stage.addActor(block);
        }
        for(int i=7;i<12;i=i+2) {
            Coin coin = new Coin(this,world, 32, 32, i*32, 222);
            stage.addActor(coin);
        }
        /*
        creating unit
         */
        unit = new Unit(world, 32, 32, 100+32, 250);
        stage.addActor(unit);
        score = new ActorScores(this);

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
        stage.act();
        camera.position.lerp(new Vector3(unit.getPosition(), 0), CAMERA_SMOOTHING);
        camera.update();
        stage.getViewport().setCamera(camera);
        stage.draw();
        SpriteBatch batch = new SpriteBatch();

        batch.begin();
        score.draw(batch,delta);
        batch.end();
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

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
    public void addCoins(){
        coins++;
    }

    public float getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(float screenWidth) {
        this.screenWidth = screenWidth;
    }

    public float getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(float screenHeight) {
        this.screenHeight = screenHeight;
    }
}
