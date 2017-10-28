package com.kalyandechiraju.hackernews.component;

import com.kalyandechiraju.hackernews.module.AppModule;
import com.kalyandechiraju.hackernews.module.ViewModelModule;
import com.kalyandechiraju.hackernews.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kalyandechiraju on 28/10/17.
 */

@Singleton
@Component(modules = {ViewModelModule.class, AppModule.class})
public interface ViewModelComponent {
    void inject(MainActivity mainActivity);
}
