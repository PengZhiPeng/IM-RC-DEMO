package com.li.videoapplication.ui.activity;

import android.os.Bundle;

import com.li.videoapplication.R;
import com.li.videoapplication.framework.TBaseActivity;

import io.rong.imkit.fragment.ConversationFragment;

public class PrivateChatActivity extends TBaseActivity {

    @Override
    public int getContentView() {
        return R.layout.activity_privatechat;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("单聊");

        ConversationFragment conversationFragment = (ConversationFragment) getSupportFragmentManager()
                .findFragmentById(R.id.conversation);
        if (conversationFragment != null) {

        }
    }
}
