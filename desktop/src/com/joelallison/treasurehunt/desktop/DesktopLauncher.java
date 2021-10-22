package com.joelallison.treasurehunt.desktop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.joelallison.treasurehunt.treasureHunt;



public class DesktopLauncher extends ApplicationAdapter {

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Treasure Hunt";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new treasureHunt(), config);
	}
}
