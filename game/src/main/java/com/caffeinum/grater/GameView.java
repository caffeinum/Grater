package com.caffeinum.grater;

import android.opengl.GLSurfaceView;;
import android.content.Context;

/**
 * Created by caffeinum on 3/21/14.
 */

public class GameView extends GLSurfaceView {

	private Drawer renderer;

	public GameView (Context context) {
		super(context);

		setEGLContextClientVersion(2);

		renderer = new Drawer();
		setRenderer(renderer);

		//setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

	}

    public void start() {
	    renderer = new Drawer();
	    setRenderer(renderer);
    }

}