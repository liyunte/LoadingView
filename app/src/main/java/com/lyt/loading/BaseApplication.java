package com.lyt.loading;

import android.app.Application;

import com.lyt.loading.library.Loading;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Loading.initILoading(new LoadViewAdapter());
    }


}
