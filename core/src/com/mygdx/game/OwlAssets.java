package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;

public class OwlAssets {
	public static final AssetManager manager = new AssetManager();
	
	public static void load(){
	}

	public static void dispose(){
		manager.dispose();
	}
}
