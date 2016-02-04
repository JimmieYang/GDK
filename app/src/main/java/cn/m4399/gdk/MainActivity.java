package cn.m4399.gdk;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import cn.m4399.sdk.LoginHelper;
import cn.m4399.sdk.LoginListener;
import cn.m4399.sdk.LoginResult;
import cn.m4399.sdk.User;

public class MainActivity extends AppCompatActivity {
    private LoginHelper mLoginHelper;
    private ImageView mView;
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mView = (ImageView) findViewById(R.id.img);
        mText = (TextView) findViewById(R.id.showtext);

        mLoginHelper = LoginHelper.getInstance();
        User user = mLoginHelper.getLoggedUser(this);
        if (user != null) {
            showInfo(user);
        }
    }

    public void onLoginButtonClicked(View view) {
        mLoginHelper.login(this, new LoginListener() {
            @Override
            public void onLoginFinished(final LoginResult result) {
                if (result != null && result.isSuccess()) {
                    showInfo(result.getUser());
                }
            }
        });
    }

    private void showInfo(User user) {
        RequestQueue mQueue = Volley.newRequestQueue(this);
        ImageRequest request = new ImageRequest(user.getAvatar_middle(), new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                mView.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mView.setImageResource(R.mipmap.ic_launcher);
            }
        });
        mQueue.add(request);

        StringBuffer sb = new StringBuffer();
        sb.append(isNotEmpty(user.getUsername()) ? user.getUsername() + "\n" : "");
        sb.append(isNotEmpty(user.getNick()) ? user.getNick() + "\n" : "");
        sb.append(isNotEmpty(user.getBindedphone()) ? user.getBindedphone() : "");
        mText.setText(sb.toString());
    }

    private boolean isNotEmpty(String str) {
        if (str != null && !str.equals(""))
            return true;
        else
            return false;
    }
}
