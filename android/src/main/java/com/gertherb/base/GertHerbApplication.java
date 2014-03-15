package com.gertherb.base;

import android.app.Application;

import com.gertherb.BuildConfig;
import com.novoda.notils.logger.analyse.StrictModeManager;

public class GertHerbApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        StrictModeManager.ON = BuildConfig.DEBUG;
        StrictModeManager.initializeStrictMode();
    }

}
