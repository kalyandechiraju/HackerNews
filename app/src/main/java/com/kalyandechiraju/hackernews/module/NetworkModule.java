package com.kalyandechiraju.hackernews.module;

import com.kalyandechiraju.hackernews.Constants;
import com.kalyandechiraju.hackernews.service.NewsAPI;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kalyandechiraju on 28/10/17.
 */

@Module
public class NetworkModule {
    private static final String NAMED_BASE_URL = "NAMED_BASE_URL";

    @Provides
    @Named(NAMED_BASE_URL)
    String provideBaseUrlString() {
        return Constants.BASE_URL;
    }

    @Provides
    @Singleton
    Converter.Factory provideGsonConverter() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Converter.Factory converter, @Named(NAMED_BASE_URL) String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converter)
                .build();
    }

    @Provides
    @Singleton
    NewsAPI provideNewsAPI(Retrofit retrofit) {
        return retrofit.create(NewsAPI.class);
    }
}
