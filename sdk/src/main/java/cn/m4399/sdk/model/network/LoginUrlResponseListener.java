package cn.m4399.sdk.model.network;

import com.android.volley.VolleyError;

/**
 * Created by 4399-1126 on 2016/2/4.
 */
public interface LoginUrlResponseListener {
    void onSucceed(String result);

    void onFailed(VolleyError error);
}
