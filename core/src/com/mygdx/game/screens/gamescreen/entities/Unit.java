package com.mygdx.game.screens.gamescreen.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.OwlAssets;
import com.mygdx.game.settings.Constants;
import com.mygdx.game.settings.Constants.MOVING_STATES;

import static com.mygdx.game.settings.Constants.*;

public class Unit extends ActorWithPhysics{
    Texture texture;
    MOVING_STATES state;
    public Unit(World world, int width, int height, int x, int y){
        super(width, height,x,y);

        BodyDef bdef = new BodyDef();
        bdef.position.set(x/ PPM,y/ PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        setBody(world.createBody(bdef));
        PolygonShape sh = new PolygonShape();
        sh.setAsBox(width/2/ PPM,height/2/ PPM);
        FixtureDef fxd = new FixtureDef();
        fxd.shape = sh;
        getBody().createFixture(fxd);
        state = MOVING_STATES.STOPPED;

        texture = (Texture) OwlAssets.manager.get("photo.jpg");

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
        if(Math.abs(this.body.getLinearVelocity().x)<MAX_SPEED) {
            if (state == MOVING_STATES.MOVING_RIGHT) {
                this.body.applyLinearImpulse(new Vector2(ACELERATION / PPM, 0), this.getBody().getPosition(), true);
            }
            if (state == MOVING_STATES.MOVING_LEFT) {
                this.body.applyLinearImpulse(new Vector2(-ACELERATION / PPM, 0), this.getBody().getPosition(), true);
            }
        }
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

    /**
     * make unit jump, no arguments
     */
    public void jump(){
        this.body.applyLinearImpulse(new Vector2(0f,JUMP/PPM),this.getBody().getPosition(),true);
    }

    /**
     * make unit move right a bit, no arguments
     */
    public void right(){
        this.body.applyLinearImpulse(new Vector2(ACELERATION/PPM,0),this.getBody().getPosition(),true);
    }

    /**
     * make unit move right bit a bit, no arguments
     */
    public void startMovingRight(){
        state = MOVING_STATES.MOVING_RIGHT;
    }
    /**
     * will stop adding velocity to unit
     */
    public void stopMovingRight(){
        state = MOVING_STATES.STOPPED;
    }
    /**
     * make unit move right bit a bit, no arguments
     */
    public void startMovingLeft(){
        state = MOVING_STATES.MOVING_LEFT;
    }
    /**
     * will stop adding velocity to unit
     */
    public void stopMovingLeft(){
        state = MOVING_STATES.STOPPED;
    }
    /**
     * make unit move right a bit, no arguments
     */
    public void left(){
        this.body.applyLinearImpulse(new Vector2(-ACELERATION/PPM,0),this.getBody().getPosition(),true);
    }

    public Vector2 getPosition(){
        return new Vector2(body.getPosition().x * PPM, body.getPosition().y * PPM);
    }
}
