package cn.m4399.sdk.view;


import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import cn.m4399.sdk.constance.Const;

/**
 * TODO: document your custom view class.
 */
public class LoginWebView extends WebView {
    private ProgressBar mPb;

    public LoginWebView(Context context) {
        super(context);
        init(context);
    }

    public LoginWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void setProgressBar(ProgressBar pb) {
        this.mPb = pb;
    }

    private void init(Context context) {
        // 嵌入JavaScript代码,获取webView的内容
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);

        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setSupportZoom(true);
        getSettings().setBuiltInZoomControls(true);
        setWebViewClient(new LoginWebClient());
    }

    private class LoginWebClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            mPb.setVisibility(VISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (url.startsWith(Const.START_WITH_URL)) {
                view.loadUrl(Const.JAVESCRIP_METHOD);
            }
            mPb.setVisibility(GONE);
        }
    }
}
