package com.giyp.dagger.module;

import android.app.Application;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by brunogabriel on 25/10/16.
 */

@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }
}
