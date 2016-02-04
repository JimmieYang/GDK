package cn.m4399.sdk.model.network;


import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import cn.m4399.sdk.constance.Const;
import cn.m4399.sdk.model.entity.Device;
import cn.m4399.sdk.model.persist.LoginRecord;
import cn.m4399.sdk.utils.JsonUtil;
import cn.m4399.sdk.utils.NetWorkUtil;
import cn.m4399.sdk.utils.SystemUtils;

/**
 * Created by 4399-0833 on 2016/2/3.
 */
public class LoginUrlRequest {

    public void getVolleyResponse(final Context context, final LoginUrlResponseListener listener) {
        RequestQueue mQueue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(
                Request.Method.POST, Const.HTTP_URL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String result = JsonUtil.getJsonResult(response);
                        listener.onSucceed(result);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onFailed(error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                LoginParams entity = LoginUrlRequest.this.getLoginParams(context);
                params.put(Const.STATE, entity.getState());
                params.put(Const.DEVICE, entity.getDevice());
                params.put(Const.TOPBAR, entity.getTopbar());
                params.put(Const.USERNAMES, entity.getUsernames());
                return params;
            }
        };
        request.setRetryPolicy( // 设置网络超时和重试参数
                new DefaultRetryPolicy(
                        10000,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,//默认最大尝试次数
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
                )
        );
        mQueue.add(request);
    }

    private LoginParams getLoginParams(Context context) {
        LoginParams params = new LoginParams();
        params.setDevice(getDevice(context));
        params.setState("");
        params.setTopbar("false");
        params.setUsernames(new LoginRecord().getLoggerdUsers(context));
        return params;
    }

    private String getDevice(Context context) {
        Device device = new Device();
        device.setDevice_identifier(SystemUtils.getDeviceIdentifier(context));
        device.setScreen_resolution(SystemUtils.getResolution(context));
        device.setDevice_model(SystemUtils.getDeviceModel());
        device.setSystem_version(SystemUtils.getSystemVersion());
        device.setImsi(SystemUtils.getImsi(context));
        device.setPhone(SystemUtils.getPhone(context));
        device.setNetwork_type(NetWorkUtil.getNetWorkType(context));
        return device.parse();
    }

    public static class LoginParams {
        private String state;
        private String topbar;
        private String device;
        private String usernames;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getTopbar() {
            return topbar;
        }

        public void setTopbar(String topbar) {
            this.topbar = topbar;
        }

        public String getDevice() {
            return device;
        }

        public void setDevice(String device) {
            this.device = device;
        }

        public String getUsernames() {
            return usernames;
        }

        public void setUsernames(String usernames) {
            this.usernames = usernames;
        }
    }
}
