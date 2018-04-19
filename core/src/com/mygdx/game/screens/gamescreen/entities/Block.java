package com.mygdx.game.screens.gamescreen.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.OwlAssets;

public class Block extends Actor{
    Body body;
    Texture texture;
    public Block(World world,int w, int h,int x, int y){
        BodyDef bdef = new BodyDef();
        bdef.position.set(x,y);
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bdef);
        PolygonShape sh = new PolygonShape();
        sh.setAsBox(w/2,h/2);
        FixtureDef fxd = new FixtureDef();
        fxd.shape = sh;
        body.createFixture(fxd);
        this.setWidth(w);
        this.setHeight(h);
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
        this.setX(body.getPosition().x-this.getWidth()/2);
        this.setY(body.getPosition().y-this.getHeight()/2);
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
