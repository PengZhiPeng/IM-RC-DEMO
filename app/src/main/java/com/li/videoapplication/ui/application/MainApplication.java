package com.li.videoapplication.ui.application;

import com.li.videoapplication.framework.BaseApplication;
import com.li.videoapplication.utils.AppUtil;

import io.rong.imkit.RongIM;

/**
 * 应用:主应用程序
 */
public class MainApplication extends BaseApplication {

	@Override
	public void onCreate() {
		super.onCreate();

        if (getApplicationInfo().packageName.equals(AppUtil.getCurProcessName(getApplicationContext())))
            RongIM.init(this);
	}

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
