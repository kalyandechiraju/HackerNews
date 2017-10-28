package com.kalyandechiraju.hackernews.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.kalyandechiraju.hackernews.HackerNews;
import com.kalyandechiraju.hackernews.adapter.NewsAdapter;
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

    private ObservableField<News> newsData = new ObservableField<>();
    private ObservableField<Boolean> isDataLoaded = new ObservableField<>(true);
    private ObservableField<Boolean> didErrorOccur = new ObservableField<>(false);

    private NewsAdapter newsAdapter;
    private Context context;

    @Inject
    NewsAPI newsAPI;

    public NewsViewModel(Context context) {
        ((HackerNews) context).getNetworkComponent().inject(this);
        this.context = context;
    }

    public void downloadNews(String query) {
        isDataLoaded.set(false);
        newsAPI.getNews(query).enqueue(new Callback<News>() {
            @Override
            public void onResponse(@NonNull Call<News> call, @NonNull Response<News> response) {
                if (response.isSuccessful()) {
                    newsData.set(response.body());
                    newsAdapter.setData(newsData.get().getHits());
                    Log.d(TAG, response.body().toString());
                } else {
                    Log.e(TAG, "Error downloading news");
                    didErrorOccur.set(true);
                }
                isDataLoaded.set(true);
            }

            @Override
            public void onFailure(@NonNull Call<News> call, @NonNull Throwable t) {
                isDataLoaded.set(true);
                didErrorOccur.set(true);
                Log.e(TAG, "Error", t);
            }
        });
    }

    public ObservableField<News> getNewsData() {
        return newsData;
    }

    public ObservableField<Boolean> getIsDataLoaded() {
        return isDataLoaded;
    }

    public ObservableField<Boolean> getDidErrorOccur() {
        return didErrorOccur;
    }

    public void setNewsAdapter(NewsAdapter newsAdapter) {
        this.newsAdapter = newsAdapter;
    }
}
