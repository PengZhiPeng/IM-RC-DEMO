package com.li.videoapplication.framework;

import android.app.Service;

/**
 * 基本服务
 */
public abstract class BaseService extends Service {
	
	protected final String action = this.getClass().getName();
	protected final String tag = this.getClass().getSimpleName();
    
    @Override
    public void onCreate() {
    	super.onCreate();
        AppManager.getInstance().addService(this);
    }
    
    @Override
    public void onDestroy() {
        AppManager.getInstance().removeService(this);
    	super.onDestroy();
    }
}
