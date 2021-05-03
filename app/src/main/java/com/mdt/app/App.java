package com.mdt.app;

import android.app.Application;
import android.content.Context;

import com.backendless.Backendless;

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
        Backendless.initApp(this, "784C9380-873E-42F2-8C30-9243CFD9DF3B", "93C223C5-E022-4D0D-81F7-3AC9A9B0F389");
    }
    public static Context getContext() {
        return context;
    }

    public static App getApp() {
        return app;
    }
}
