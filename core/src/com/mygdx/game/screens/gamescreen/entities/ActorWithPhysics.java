package com.mygdx.game.screens.gamescreen.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.OwlAssets;
import com.mygdx.game.screens.gamescreen.MainGameScreen;
import com.mygdx.game.settings.Constants;
import static com.mygdx.game.settings.Constants.PPM;

/**
 * Basic class extending Actor class with properties of body
 * need World object for interract with it
 * At start all objects are Static Bodyes
 * Basic constructor need
 * world
 * width
 * height
 * x position
 * y position
 * Texture name
 *
 * Texture manager is set for this project
 *
 */
public class ActorWithPhysics extends Actor {


    protected Body body;
    protected World world;
    Texture texture;
    MainGameScreen gamescreen;
    public ActorWithPhysics(MainGameScreen gamescreen, World world, int width, int height, int x, int y){
        this.world = world;
        this.gamescreen =gamescreen;
        this.setWidth(width);
        this.setHeight(height);
    }
    public ActorWithPhysics(int width, int height, int x, int y){
        this.setWidth(width);
        this.setHeight(height);
    }

    /**
     * Updates the actor based on time. Typically this is called each frame by {@link Stage#act(float)}.
     * <p>
     * The default implementation calls {@link Action#act(float)} on each action and removes actions that are complete.
     *
     * @param delta Time in seconds since the last frame.
     */
    @Override
    public void act(float delta) {
        super.act(delta);
        this.setX(getBody().getPosition().x*PPM-this.getWidth()/2);
        this.setY(getBody().getPosition().y*PPM-this.getHeight()/2);
    }

    /**
     * Draws the actor. The batch is configured to draw in the parent's coordinate system.
     * {@link Batch#draw(TextureRegion, float, float, float, float, float, float, float, float, float)
     * This draw method} is convenient to draw a rotated and scaled TextureRegion. {@link Batch#begin()} has already been called on
     * the batch. If {@link Batch#end()} is called to draw without the batch then {@link Batch#begin()} must be called before the
     * method returns.
     * <p>
     * The default implementation does nothing.
     *
     * @param batch
     * @param parentAlpha Should be multiplied with the actor's alpha, allowing a parent's alpha to affect all children.
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
