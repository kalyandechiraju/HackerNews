package com.kalyandechiraju.hackernews.module;

import android.content.Context;

import com.kalyandechiraju.hackernews.viewmodel.NewsViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kalyandechiraju on 28/10/17.
 */

@Module
public class ViewModelModule {
    @Provides
    @Singleton
    NewsViewModel provideNewsViewModel(Context context) {
        return new NewsViewModel(context);
    }
}
