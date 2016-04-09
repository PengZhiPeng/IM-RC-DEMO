package com.li.videoapplication.ui.activity;

import android.os.Bundle;
import android.widget.EditText;

import com.li.videoapplication.R;
import com.li.videoapplication.data.User;
import com.li.videoapplication.framework.TBaseActivity;

import butterknife.Bind;
import butterknife.OnClick;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class LoginActivity extends TBaseActivity {

    @Bind(R.id.loginToken)
    EditText loginToken;

    public String getLoginToken() {
        if (loginToken.getText() == null)
            return "";
        log("token=" + loginToken.getText().toString().trim());
        return loginToken.getText().toString().trim();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("登录");
        loginToken.setText(User.A.TOKEN);
    }

    @OnClick(R.id.loginLogin)
    public void onClick() {
        connent();
    }

    private void connent() {
        log("1");
        if (getLoginToken().isEmpty())
            toastShort("Token不能为空");
        new Thread(new Runnable() {
            @Override
            public void run() {

                log("2");
                RongIM.connect(getLoginToken(), new RongIMClient.ConnectCallback() {

                    @Override
                    public void onTokenIncorrect() {
                        log("onTokenIncorrect");
                    }

                    @Override
                    public void onSuccess(String s) {
                        log("onSuccess");
                        post(new Runnable() {
                            @Override
                            public void run() {
                                log("3");
                                startActivity(MainActivity.class);
                            }
                        });
                    }

                    @Override
                    public void onError(RongIMClient.ErrorCode errorCode) {
                        log("onError/errorCode=" + errorCode.getMessage());
                    }
                });
            }
        }).start();
    }
}
