package com.kalyandechiraju.hackernews.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kalyandechiraju.hackernews.HackerNews;
import com.kalyandechiraju.hackernews.R;
import com.kalyandechiraju.hackernews.adapter.NewsAdapter;
import com.kalyandechiraju.hackernews.databinding.ActivityMainBinding;
import com.kalyandechiraju.hackernews.viewmodel.NewsViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    NewsViewModel newsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        ((HackerNews) getApplication()).getViewModelComponent().inject(this);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setNewsViewModel(newsViewModel);

        RecyclerView recyclerView = findViewById(R.id.news_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NewsAdapter adapter = new NewsAdapter(null);
        recyclerView.setAdapter(adapter);

        newsViewModel.downloadNews("premier league");
        newsViewModel.setNewsAdapter(adapter);
    }
}
