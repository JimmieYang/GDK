package cn.m4399.sdk.model.persist;


import android.content.Context;

import cn.m4399.sdk.User;
import cn.m4399.sdk.utils.JsonUtil;
import cn.m4399.sdk.utils.PreferencesUtil;

/**
 * Created by 4399-0833 on 2016/2/3.
 * 持久层:需要保存的数据
 */
public class LoginRecord {

    public User getLoggedUser(Context context) {
        String userInfoStr = PreferencesUtil.getUserInfo(context, PreferencesUtil.USER);
        if (userInfoStr != null && !userInfoStr.equals("")) {
            User user = new User(userInfoStr);
            return user;
        }
        return null;
    }

    public String getLoggerdUsers(Context context) {
        String names = PreferencesUtil.getUserInfo(context, PreferencesUtil.USER_NAMES);
        return names;
    }

    public void saveUserInfo(String result, Context context) {
        String userInfo = JsonUtil.getJsonResult(result);
        if (userInfo != null && !userInfo.equals("")) {
            PreferencesUtil.saveUserInfo(context, PreferencesUtil.USER, userInfo);
            User user = new User(userInfo);
            PreferencesUtil.saveNames(context, user.getUsername());
        }
    }
}
