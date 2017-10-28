package com.kalyandechiraju.hackernews.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kalyandechiraju on 28/10/17.
 */

@Module
public class AppModule {
    private Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Context provideAppContext() {
        return this.mApplication;
    }
}
