package com.kalyandechiraju.hackernews.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kalyandechiraju.hackernews.databinding.NewsItemBinding;
import com.kalyandechiraju.hackernews.model.Hit;

import java.util.List;

/**
 * Created by kalyandechiraju on 28/10/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<Hit> data;
    private LayoutInflater mLayoutInflater;
    private Context context;

    public NewsAdapter(List<Hit> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public void setData(List<Hit> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(parent.getContext());
        }
        NewsItemBinding newsItemBinding = NewsItemBinding.inflate(mLayoutInflater, parent, false);
        return new ViewHolder(newsItemBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (data != null) {
            final Hit hit = data.get(position);
            String author = "Author: " + hit.getAuthor();
            holder.bind(hit.getTitle(), author);

            holder.getNewsItemBinding().getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("CLICK: ", hit.getTitle() + " clicked");
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(hit.getUrl()));
                    context.startActivity(browserIntent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (data == null) {
            return 0;
        }
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private NewsItemBinding newsItemBinding;

        public ViewHolder(NewsItemBinding newsItemBinding) {
            super(newsItemBinding.getRoot());
            this.newsItemBinding = newsItemBinding;
        }

        public void bind(String title, String author) {
            newsItemBinding.setTitle(title);
            newsItemBinding.setAuthor(author);
        }

        public NewsItemBinding getNewsItemBinding() {
            return newsItemBinding;
        }
    }
}
