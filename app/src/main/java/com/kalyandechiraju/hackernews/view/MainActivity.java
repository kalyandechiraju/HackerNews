package com.kalyandechiraju.hackernews.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kalyandechiraju.hackernews.HackerNews;
import com.kalyandechiraju.hackernews.R;
import com.kalyandechiraju.hackernews.viewmodel.NewsViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    NewsViewModel newsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((HackerNews) getApplication()).getViewModelComponent().inject(this);

        newsViewModel.downloadNews("premier league");
    }
}
