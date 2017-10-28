package com.kalyandechiraju.hackernews;

import android.app.Application;

import com.kalyandechiraju.hackernews.component.DaggerNetworkComponent;
import com.kalyandechiraju.hackernews.component.DaggerViewModelComponent;
import com.kalyandechiraju.hackernews.component.NetworkComponent;
import com.kalyandechiraju.hackernews.component.ViewModelComponent;
import com.kalyandechiraju.hackernews.module.AppModule;
import com.kalyandechiraju.hackernews.module.NetworkModule;
import com.kalyandechiraju.hackernews.module.ViewModelModule;

/**
 * Created by kalyandechiraju on 28/10/17.
 */

public class HackerNews extends Application {
    private NetworkComponent networkComponent;
    private ViewModelComponent viewModelComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (networkComponent == null) {
            networkComponent = DaggerNetworkComponent.builder()
                    .networkModule(new NetworkModule())
                    .build();
        }

        if (viewModelComponent == null) {
            viewModelComponent = DaggerViewModelComponent.builder()
                    .viewModelModule(new ViewModelModule())
                    .appModule(new AppModule(this))
                    .build();
        }
    }

    public NetworkComponent getNetworkComponent() {
        return networkComponent;
    }

    public ViewModelComponent getViewModelComponent() {
        return viewModelComponent;
    }
}
