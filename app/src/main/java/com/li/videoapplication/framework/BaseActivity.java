package com.li.videoapplication.framework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    protected final String action = this.getClass().getName();
    protected final String tag = this.getClass().getSimpleName();

    public abstract int getContentView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppManager.getInstance().addActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
    }

    @Override
    public void onDestroy() {
        AppManager.getInstance().removeActivity(this);
        super.onDestroy();
    }
}
