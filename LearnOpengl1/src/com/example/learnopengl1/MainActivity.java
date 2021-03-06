package com.example.learnopengl1;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
	private GLSurfaceView glSurfaceView;
	private boolean renderSet = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new GLSurfaceView(this);
        final ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo ci = am.getDeviceConfigurationInfo();
        final boolean es2support = ci.reqGlEsVersion>=0x20000;
        if(!es2support)
        	Toast.makeText(getApplicationContext(), "Sorry this device doesnt support opengl es 2", Toast.LENGTH_SHORT).show();
        else{
        	glSurfaceView.setEGLContextClientVersion(2);
        	glSurfaceView.setEGLConfigChooser(8,8,8,8,16,0);
        	glSurfaceView.setRenderer(new OpenglRenderer());
        	renderSet = true;
        }
        
        setContentView(glSurfaceView);
        	
    }
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(renderSet){
			glSurfaceView.onResume();
		}
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if(renderSet){
			glSurfaceView.onPause();
		}
	}
}
