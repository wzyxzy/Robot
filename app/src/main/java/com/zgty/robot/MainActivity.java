package com.zgty.robot;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView robot_webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        setContentView(R.layout.activity_main);
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//设置横屏
        }
        initView();
    }

    @Override
    protected void onResume() {

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//保持屏幕常亮
        super.onResume();
    }

    @Override
    protected void onPause() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//软件在后台屏幕不需要常亮
        super.onPause();
    }

    private void initView() {
        robot_webview = (WebView) findViewById(R.id.robot_webview);
        robot_webview.setInitialScale(140);//设置缩放
        WebSettings settings = robot_webview.getSettings();
        settings.setJavaScriptEnabled(true);//设置js支持
        settings.setSupportZoom(true);//设置缩放支持
        settings.setDatabaseEnabled(true);//设置界面存储到数据库
        settings.setDomStorageEnabled(true);//设置界面支持缓存
        robot_webview.loadUrl("http://192.168.18.74:8080/robot/index");//设置网址
    }
}
