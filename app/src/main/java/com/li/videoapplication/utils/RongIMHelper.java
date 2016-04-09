package com.li.videoapplication.utils;


import android.net.Uri;
import android.util.Log;

import com.li.videoapplication.data.User;

import io.rong.imkit.RongIM;
import io.rong.imlib.model.UserInfo;

public class RongIMHelper {

    public static final String TAG = RongIMHelper.class.getSimpleName();

    public static void setUserInfoProvider() {

        RongIM.setUserInfoProvider(new RongIM.UserInfoProvider() {

            @Override
            public UserInfo getUserInfo(String userId) {
                Log.d(TAG, "getUserInfo/userId=" + userId);
                UserInfo userInfo = null;
                if (userId.equals(User.A.USER_ID))
                    userInfo = new UserInfo(User.A.USER_ID, User.A.NAME, Uri.parse(User.A.PORTRAIT_URI));
                else if (userId.equals(User.B.USER_ID))
                    userInfo = new UserInfo(User.B.USER_ID, User.B.NAME, Uri.parse(User.B.PORTRAIT_URI));
                return userInfo;
            }

        }, true);
    }

    public static void refreshUserInfoCache(final String id, final String name, final String portraitUri) {
        UserInfo userInfo = new UserInfo(id, name, Uri.parse(portraitUri));
        RongIM.getInstance().refreshUserInfoCache(userInfo);
    }
}
