package com.li.videoapplication.framework;


import android.app.Application;
import android.util.Log;

/**
 * 基本应用程序
 */
public abstract class BaseApplication extends Application {

    protected final String action = this.getClass().getName();
    protected final String tag = this.getClass().getSimpleName();

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d(tag, "onCreate");
		AppManager.getInstance().setApplication(this);
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
		Log.d(tag, "onTerminate");
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		Log.d(tag, "onLowMemory");
	}
}
