package com.mygdx.game.screens.gamescreen.controlls;

import com.badlogic.gdx.physics.box2d.*;

public class LearningContactListener implements ContactListener {
    static int num = 0;
    /**
     * Starts when 2 fixtures start to collide
     * @param contact
     */
    @Override
    public void beginContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();
        if(fa.getUserData()!=null&&fa.getUserData().equals("coin")){
            fa.getBody().setUserData("DELETED");
        }
    }

    /**
     * Starts when 2 fixtures stop to collide
     * @param contact
     */
    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
