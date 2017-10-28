package com.kalyandechiraju.hackernews.component;

import com.kalyandechiraju.hackernews.module.NetworkModule;
import com.kalyandechiraju.hackernews.viewmodel.NewsViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kalyandechiraju on 28/10/17.
 */

@Singleton
@Component(modules = {NetworkModule.class})
public interface NetworkComponent {
    void inject(NewsViewModel viewModel);
}

