package com.kalyandechiraju.hackernews.viewmodel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.kalyandechiraju.hackernews.HackerNews;
import com.kalyandechiraju.hackernews.model.News;
import com.kalyandechiraju.hackernews.service.NewsAPI;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kalyandechiraju on 28/10/17.
 */

public class NewsViewModel extends BaseViewModel {
    private static final String TAG = NewsViewModel.class.getName();

    @Inject
    NewsAPI newsAPI;

    public NewsViewModel(Context context) {
        ((HackerNews) context).getNetworkComponent().inject(this);
    }

    public void downloadNews(String query) {
        newsAPI.getNews(query).enqueue(new Callback<News>() {
            @Override
            public void onResponse(@NonNull Call<News> call, @NonNull Response<News> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(@NonNull Call<News> call, @NonNull Throwable t) {

            }
        });
    }
}
