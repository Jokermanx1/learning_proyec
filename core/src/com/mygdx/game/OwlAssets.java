package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class OwlAssets {
	public static final AssetManager manager = new AssetManager();

	public static final String block = "block.png";
	public static void load(){
		manager.load(block,Texture.class);
	}

	public static void dispose(){
		manager.dispose();
	}
}
