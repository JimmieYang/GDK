package cn.m4399.sdk.control;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import cn.m4399.sdk.LoginHelper;
import cn.m4399.sdk.LoginResult;
import cn.m4399.sdk.R;
import cn.m4399.sdk.constance.Const;
import cn.m4399.sdk.model.network.LoginResponse;
import cn.m4399.sdk.view.LoginWebView;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private LoginWebView mView;
    private Button mBtn;
    private ProgressBar mPb;

    LoginHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        String data = getIntent().getStringExtra("LOGIN_URL");
        findViews();
        init(data);
    }

    private void findViews() {
        mView = (LoginWebView) findViewById(R.id.webview);
        mBtn = (Button) findViewById(R.id.web_back_btn);
        mPb = (ProgressBar) findViewById(R.id.pb);
    }

    private void init(String url) {
        mBtn.setOnClickListener(this);
        helper = LoginHelper.getInstance();
        LoginResponse response = new LoginResponse(this);
        response.setListener(helper.getListener());
        mView.addJavascriptInterface(response, Const.JAVESCRIP_METHOD_NAME);
        mView.setProgressBar(mPb);
        mView.loadUrl(url);
    }

    @Override
    public void onClick(View v) {
        if (mView != null && mView.canGoBack()) {
            mView.goBack();
        } else {
            LoginResult result = new LoginResult();
            result.setSuccess(false);
            result.setMessage("登录失败...");
            helper.getListener().onLoginFinished(result);
            finish();
        }
    }
}
