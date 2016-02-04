package cn.m4399.sdk.model.network;


import android.app.Activity;
import android.content.Context;
import android.webkit.JavascriptInterface;

import cn.m4399.sdk.LoginListener;
import cn.m4399.sdk.LoginResult;
import cn.m4399.sdk.model.persist.LoginRecord;

/**
 * Created by 4399-0833 on 2016/2/3.
 */
public class LoginResponse {
    private Context context;
    private LoginListener listener;

    public LoginResponse(Context context) {
        this.context = context;
    }

    public void setListener(LoginListener listener) {
        this.listener = listener;
    }

    @JavascriptInterface
    public void getBodyContent(String result) {
        if (result != null && result != "" && result.startsWith("{")) {
            LoginRecord record = new LoginRecord();
            record.saveUserInfo(result, context);
            LoginResult loginResult = new LoginResult(result);
            loginResult.setSuccess(true);
            ((Activity) context).finish();
            listener.onLoginFinished(loginResult);
        }
    }
}
