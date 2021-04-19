package com.mdt.app;

import android.app.Application;
import android.content.Context;

import khangtran.preferenceshelper.PreferencesHelper;

public class App extends Application {

    private static Context context;
    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        app = this;
        PreferencesHelper.initHelper(this);
    }

    public static Context getContext() {
        return context;
    }

    public static App getApp() {
        return app;
    }
}
