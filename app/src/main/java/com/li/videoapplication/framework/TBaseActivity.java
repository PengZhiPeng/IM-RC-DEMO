package com.li.videoapplication.framework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.li.videoapplication.ui.toast.ToastHelper;

public abstract class TBaseActivity extends BaseActivity {

    private Handler handler = new Handler();

    protected void toastShort(final String text) {
        post(new Runnable() {
            @Override
            public void run() {

                ToastHelper.s(text);
            }
        });
    }

    protected void toastLong(final String text) {
        post(new Runnable() {
            @Override
            public void run() {

                ToastHelper.l(text);
            }
        });
    }

    protected void log(String msg) {
        Log.i(tag, msg);
    }

    protected Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (handler != null)
            handler.removeCallbacksAndMessages(null);
    }

    protected void post(Runnable r) {
        if (handler != null)
            handler.post(r);
    }

    protected void startActivity( Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
