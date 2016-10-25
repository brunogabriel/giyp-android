package com.giyp.dagger.component;

import com.giyp.dagger.module.AppModule;
import com.giyp.dagger.module.NetModule;
import com.giyp.view.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by brunogabriel on 25/10/16.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity mainActivity);
}
