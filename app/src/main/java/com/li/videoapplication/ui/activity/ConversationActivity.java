package com.li.videoapplication.ui.activity;

import android.os.Bundle;

import com.li.videoapplication.R;
import com.li.videoapplication.framework.TBaseActivity;

public class ConversationActivity extends TBaseActivity {

    @Override
    public int getContentView() {
        return R.layout.activity_conversation;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("会话列表");
    }
}
