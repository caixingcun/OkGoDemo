package com.chonghao.okgodemo;

import android.app.Application;
import android.content.Context;

import com.lzy.okgo.OkGo;

/**
 * desc:
 */

public class App extends Application {

   public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        OkGo.getInstance().init(this);
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}
