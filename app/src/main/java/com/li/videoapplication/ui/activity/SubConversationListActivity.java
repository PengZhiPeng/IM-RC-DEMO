package com.li.videoapplication.ui.activity;

import android.net.Uri;
import android.os.Bundle;

import com.li.videoapplication.R;
import com.li.videoapplication.framework.TBaseActivity;

import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;

public class SubConversationListActivity extends TBaseActivity {

    @Override
    public int getContentView() {
        return R.layout.activity_subconversationlist;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("聚合会话列表");
    }
}
