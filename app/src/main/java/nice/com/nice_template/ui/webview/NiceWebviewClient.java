package nice.com.nice_template.ui.webview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import nice.com.nice_template.core.AbstractActivity;


/**
 * Created by ${nice} on ${2016年04月29日14:09:09}.
 */
public class NiceWebviewClient extends WebViewClient {

    AbstractActivity activity;

    public NiceWebviewClient(AbstractActivity activity){
        this.activity = activity;

    }


    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.startsWith("http") || url.startsWith("https")) {
            return super.shouldOverrideUrlLoading(view, url);
        } else {
            if (activity != null) {
                try {
                    Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    activity.startActivity(in);
                }catch (Exception e){

                }
            }
            return true;
        }
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
//        BIUtil.onWebPageShow(url);
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
//        if (listener != null) {
//            listener.onLoadFailed();
//        }
    }

}
