package nice.com.nice_template.ui.main;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;

import nice.com.nice_template.R;
import nice.com.nice_template.background.ConfigValue;
import nice.com.nice_template.background.JICHEShareModel;
import nice.com.nice_template.background.ShareUtil;
import nice.com.nice_template.core.AbstractActivity;
import nice.com.nice_template.ui.webview.NiceJavaScriptInterface;
import nice.com.nice_template.ui.webview.NiceWebChromeClient;
import nice.com.nice_template.ui.webview.NiceWebviewClient;
import nice.com.nice_template.ui.webview.WebViewSettingUtil;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

/**
 * Created by nice on 16/4/13.
 */

@EActivity(R.layout.activity_webview)
public class ActivityWebView extends AbstractActivity {


    @Extra
    String desc;

    @Extra
    String url;

    @Extra
    JICHEShareModel share;


    @ViewById(R.id.webiew)
    WebView webView;

    NiceJavaScriptInterface javaScriptInterface;
    NiceWebChromeClient webChromeClient;
    NiceWebviewClient webviewClient;


    @AfterViews
    void init() {

        if (share != null&&!TextUtils.isEmpty(share.getShare_url())) {
            setTitleRightImageButton(R.drawable.icon_wechat_timeline, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ShareUtil shareUtil = new ShareUtil();
                    shareUtil.shareToWeChat(ActivityWebView.this,share.getShare_title(),share.getShare_desc(),share.getShare_url(),share.getShare_pic(),true);
                }
            });

            setTitleRightImageButtonTwo(R.drawable.icon_wechat_session, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ShareUtil shareUtil = new ShareUtil();
                    shareUtil.shareToWeChat(ActivityWebView.this, share.getShare_title(), share.getShare_desc(), share.getShare_url(), share.getShare_pic(), false);
                }
            });
        }

        initWebView();

        if (!TextUtils.isEmpty(desc)) {
            webView.loadDataWithBaseURL(null, desc, "text/html", "utf-8", null);
        }

        if (!TextUtils.isEmpty(url)) {
            webView.loadUrl(url);
        }
    }

    private void initWebView() {
        javaScriptInterface = new NiceJavaScriptInterface(this, webView);
        webChromeClient = new NiceWebChromeClient(this);
        webviewClient = new NiceWebviewClient(this);

        WebViewSettingUtil.Builder builder = new WebViewSettingUtil.Builder();
        builder.setWebView(webView).setJavaScriptInterface(javaScriptInterface).setWebChromeClient(webChromeClient).setWebClient(webviewClient);
        WebViewSettingUtil.initWebViewSetting(builder);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ConfigValue.kHTML_JS_LOGIN_REQUEST_CODE && resultCode == RESULT_OK) {
            if (javaScriptInterface != null) {
                javaScriptInterface.loginSucessAndPostUserInfo();
            }
        }
    }

    @Override
    protected void onClickBack() {
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (webView != null) {
            webView.onResume();
        }
    }
}
