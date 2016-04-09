package com.li.videoapplication.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.li.videoapplication.R;
import com.li.videoapplication.data.ChatRoom;
import com.li.videoapplication.data.User;
import com.li.videoapplication.framework.TBaseActivity;
import com.li.videoapplication.utils.RongIMHelper;

import butterknife.Bind;
import butterknife.OnClick;
import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation;

public class MainActivity extends TBaseActivity {

    @Bind(R.id.mainUserId)
    EditText mainUserId;

    @Bind(R.id.mainId)
    EditText mainId;

    public String getMainUserId() {
        if (mainUserId.getText() == null)
            return "";
        return mainUserId.getText().toString().trim();
    }

    public String getMainId() {
        if (mainId.getText() == null)
            return "";
        return mainId.getText().toString().trim();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("融云聊天");
        mainUserId.setText(User.A.USER_ID);
        mainId.setText(ChatRoom.A.ID);

        RongIMHelper.setUserInfoProvider();
    }

    @OnClick({R.id.mainPrivateChat,
            R.id.mainConversationList,
            R.id.mainSubConversationList,
            R.id.mainConversation})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.mainPrivateChat:
                privateChat();
                break;

            case R.id.mainConversationList:
                conversationList();
                break;

            case R.id.mainSubConversationList:
                subConversationList();
                break;

            case R.id.mainConversation:
                conversation();
                break;
        }
    }

    private void privateChat() {

        if (RongIM.getInstance() != null) {
            RongIM.getInstance().startPrivateChat(this,
                    getMainUserId(),
                    "打你又怎样");
        }
    }

    private void conversationList() {

        if (RongIM.getInstance() != null) {
            RongIM.getInstance().startConversationList(this);
        }
    }

    private void subConversationList() {

        if (RongIM.getInstance() != null) {
            RongIM.getInstance().startSubConversationList(this,
                    Conversation.ConversationType.GROUP);
        }
    }

    private void conversation() {

        if (RongIM.getInstance() != null) {
            RongIM.getInstance().startConversation(this,
                    Conversation.ConversationType.CHATROOM,
                    getMainId(),
                    null);
        }
    }
}
