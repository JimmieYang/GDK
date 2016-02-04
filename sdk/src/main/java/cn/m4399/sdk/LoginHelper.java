package cn.m4399.sdk;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.VolleyError;

import cn.m4399.sdk.control.LoginActivity;
import cn.m4399.sdk.model.network.LoginUrlRequest;
import cn.m4399.sdk.model.network.LoginUrlResponseListener;
import cn.m4399.sdk.model.persist.LoginRecord;

/**
 * Created by 4399-0833 on 2016/2/3.
 */
public class LoginHelper {
    private LoginListener listener;
    private static LoginHelper instance = new LoginHelper();

    private LoginHelper() {
    }

    public LoginListener getListener() {
        return listener;
    }

    public static LoginHelper getInstance() {
        return instance;
    }

    public void login(final Activity activity, LoginListener listener) {
        this.listener = listener;
        LoginUrlRequest request = new LoginUrlRequest();
        request.getVolleyResponse(activity, new LoginUrlResponseListener() {
            @Override
            public void onSucceed(String result) {
                Intent intent = new Intent(activity, LoginActivity.class);
                intent.putExtra("LOGIN_URL", result);
                activity.startActivity(intent);
            }

            @Override
            public void onFailed(VolleyError error) {
                Toast.makeText(activity, "获取登录页面失败...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public User getLoggedUser(Context context) {
        LoginRecord record = new LoginRecord();
        return record.getLoggedUser(context);
    }
}
