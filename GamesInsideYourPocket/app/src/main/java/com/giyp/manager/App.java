package com.giyp.manager;

import android.app.Application;

import com.giyp.dagger.component.DaggerNetComponent;
import com.giyp.dagger.component.NetComponent;
import com.giyp.dagger.module.AppModule;
import com.giyp.dagger.module.NetModule;

/**
 * Created by brunogabriel on 25/10/16.
 */

public class App extends Application {

    private NetComponent mNetcomponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetcomponent = DaggerNetComponent.builder()
                //.appModule(new AppModule(this))
                .netModule(new NetModule("http://xmova-log.simova.ws/api/testconnection/"))
                .build();
    }

    public NetComponent getNetcomponent() {
        return mNetcomponent;
    }
}
