package com.mygdx.game.screens.gamescreen.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.OwlAssets;
import com.mygdx.game.screens.gamescreen.MainGameScreen;

import static com.mygdx.game.settings.Constants.BIT_FULL;
import static com.mygdx.game.settings.Constants.BIT_GROUND;
import static com.mygdx.game.settings.Constants.PPM;

/**
 * class created for be clock in the game
 */
public class Block extends ActorWithPhysics{
    Texture texture;

    /**
     *
     * @param world wordld of the game
     * @param width of block block
     * @param height of block
     * @param x position in the game and world
     * @param y position in the game and world
     */
    public Block(MainGameScreen gamescreen,World world, int width, int height, int x, int y){
        super(gamescreen,world,width, height,x,y);

        BodyDef bdef = new BodyDef();
        bdef.position.set(x/ PPM,y/ PPM);
        bdef.type = BodyDef.BodyType.StaticBody;
        setBody(world.createBody(bdef));
        PolygonShape sh = new PolygonShape();
        sh.setAsBox(width/2/PPM,height/2/PPM);
        FixtureDef fxd = new FixtureDef();
        fxd.shape = sh;
        fxd.filter.categoryBits = BIT_GROUND;
        fxd.filter.maskBits = BIT_FULL;
        getBody().createFixture(fxd);
        texture = (Texture)OwlAssets.manager.get("block.png");
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
        batch.draw(texture, getX(), getY());
    }
}
