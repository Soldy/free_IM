package com.free.skype;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.RenderProcessGoneDetail;

public class MainActivity extends AppCompatActivity {
    public WebView mWebView;
    public void initWebView(){
        mWebView = new WebView(this);
        WebSettings mSettings = mWebView.getSettings();
        mSettings.setLoadWithOverviewMode(false);
        mWebView.setPadding(0,0,0,0); 
        mSettings.setUseWideViewPort(false);
        mSettings.setSupportZoom(false);
        mSettings.setBuiltInZoomControls(false);
        mSettings.setDisplayZoomControls(false);
        mSettings.setJavaScriptEnabled(true);
        mSettings.setDomStorageEnabled(true);
        mWebView.setWebChromeClient(new WebChromeClient(){}); 
        mWebView.setWebViewClient(new WebViewClient() {
          public boolean onRenderProcessGone(
            WebView view,
            RenderProcessGoneDetail detail
          ){
            mWebView.destroy();
            initWebView();
            return true;
          }
        });
       
        mWebView.loadUrl("https://web.skype.com");
        setContentView(mWebView);
    }
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen splash = SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        initWebView();
    }
}
