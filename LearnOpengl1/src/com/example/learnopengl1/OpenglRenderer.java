package com.example.learnopengl1;


import static android.opengl.GLES20.glClear;
import static android.opengl.GLES20.glClearColor;
import static android.opengl.GLES20.glViewport;
import static android.opengl.GLES20.GL_COLOR_BUFFER_BIT;

import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.opengl.GLSurfaceView.Renderer;

public class OpenglRenderer implements Renderer{
	private static final int POSITION_COMPONENT_COUNT = 2;
	private static final int BYTES_PER_FLOAT = 2;
	private final FloatBuffer vertexData = null;
	
	public OpenglRenderer() {
		super();
		float[] tableVerticesWithTriangles = {
				//Triangle 1
				0f, 0f,
				9f, 14f,
				0f, 14f,
				//Triangle 2
				0f, 0f,
				9f, 0f,
				9f, 14f,
				// Line 1
				0f, 7f,
				9f, 7f,
				// Mallets
				4.5f, 2,
				4.5f, 12f
		};
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		glViewport(0, 0, width, height);
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		glClear(GL_COLOR_BUFFER_BIT);
	}

}
