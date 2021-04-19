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
        Backendless.initApp(this, "41E22A64-D1A4-EDA7-FF47-681725D28B00", "9AE22388-90EC-4B97-B4E3-6E72F92778F1");
    }

    public static Context getContext() {
        return context;
    }

    public static App getApp() {
        return app;
    }
}
