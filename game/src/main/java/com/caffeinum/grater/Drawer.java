package com.caffeinum.grater;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


public class Drawer implements GLSurfaceView.Renderer {


	Triangle mTriangle;

	private final float[] mMVPMatrix = new float[16];
	private final float[] mProjectionMatrix = new float[16];
	private final float[] mViewMatrix = new float[16];
	private float[] mRotationMatrix = new float[16];

	@Override
	public void onDrawFrame ( GL10 gl ) {
		gl.glClear( GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT );

		Matrix.setLookAtM(mViewMatrix, 0, 0, 0, -3, 0f, 0f, 0f, 0f, 1.0f, 0.0f);

		Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);

		mTriangle.draw(mMVPMatrix);
	}

	@Override
	public void onSurfaceChanged ( GL10 gl, int width, int height ) {
		gl.glViewport( 0, 0, width, height );


		float ratio = ( float ) width / height;
/*
		gl.glMatrixMode( GL10.GL_PROJECTION );
		gl.glLoadIdentity();
		gl.glFrustumf( -ratio, ratio, -1, 1, 1, 10 );*/
		Matrix.frustumM(mProjectionMatrix, 0, -ratio, ratio, -1, 1, 3, 7);
	}

	@Override
	public void onSurfaceCreated ( GL10 gl, EGLConfig config ) {
		gl.glClearColor( 0.0f, 0.0f, 0.0f, 1.0f );

		mTriangle = new Triangle();

	}
}