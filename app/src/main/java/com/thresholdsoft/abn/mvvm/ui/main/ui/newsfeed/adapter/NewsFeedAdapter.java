package com.thresholdsoft.abn.mvvm.ui.main.ui.newsfeed.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.thresholdsoft.abn.R;
import com.thresholdsoft.abn.databinding.AdapterNewsFeedBinding;
import com.thresholdsoft.abn.mvvm.ui.main.ui.newsfeed.NewsFeedNavigator;

import java.util.List;


public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.ViewHolder> {
    private Context context;
    private List<NewsFeedModel> newsFeedModelList;
    private NewsFeedNavigator newsFeedNavigator;

    public NewsFeedAdapter(Context context, List<NewsFeedModel> newsFeedModelList, NewsFeedNavigator newsFeedNavigator) {
        this.context = context;
        this.newsFeedModelList = newsFeedModelList;
        this.newsFeedNavigator = newsFeedNavigator;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterNewsFeedBinding newsFeedBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.adapter_news_feed, parent, false);
        return new NewsFeedAdapter.ViewHolder(newsFeedBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsFeedModel newsFeedModel = newsFeedModelList.get(position);
        holder.newsFeedBinding.setModel(newsFeedModel);
    }

    @Override
    public int getItemCount() {
        return newsFeedModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AdapterNewsFeedBinding newsFeedBinding;

        public ViewHolder(@NonNull AdapterNewsFeedBinding newsFeedBinding) {
            super(newsFeedBinding.getRoot());
            this.newsFeedBinding = newsFeedBinding;
        }
    }

    public static class NewsFeedModel {
        public String heading;
        public String time;

        public String getHeading() {
            return heading;
        }

        public void setHeading(String heading) {
            this.heading = heading;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
