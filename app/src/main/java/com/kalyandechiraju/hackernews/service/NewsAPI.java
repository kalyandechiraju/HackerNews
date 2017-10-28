package com.kalyandechiraju.hackernews.service;

import com.kalyandechiraju.hackernews.model.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kalyandechiraju on 28/10/17.
 */

public interface NewsAPI {

    @GET("search")
    Call<News> getNews(@Query("query") String searchQuery);

}
