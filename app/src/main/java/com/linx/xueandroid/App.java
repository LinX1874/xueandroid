package com.linx.xueandroid;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.orhanobut.hawk.Hawk;
import com.zhouyou.http.EasyHttp;

/**
 * 描述：
 * 作者：LinX
 * 创建时间：2018/6/11 17:18
 */
public class App extends Application {

    public static App mInstance;

    @Override
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        Hawk.init(this).build();
        EasyHttp.init(this);//默认初始化

        EasyHttp.getInstance()
                .setBaseUrl("http://www.wanandroid.com/")
                .setReadTimeOut(10 * 1000)
                .setWriteTimeOut(10 * 1000)
                .setConnectTimeout(10 * 1000);
    }

    public static App getInstance() {
        return mInstance;
    }
}
