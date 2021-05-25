package com.thresholdsoft.abn.mvvm.ui.main.ui.epapersfeed.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.thresholdsoft.abn.R;
import com.thresholdsoft.abn.databinding.AdapterEpaperfeedBinding;
import com.thresholdsoft.abn.mvvm.ui.main.ui.epapersfeed.EPaperFeedNavigator;

import java.io.Serializable;
import java.util.List;

public class EpaperFeedAdapter extends RecyclerView.Adapter<EpaperFeedAdapter.ViewHolder> {
    private Context context;
    private List<EpaperFeedAdapter.EPaperFeedModel> ePaperFeedModelList;
    //    private NewsFeedNavigator newsFeedNavigator;
    private EPaperFeedNavigator mListener;

    public EpaperFeedAdapter(Context context, List<EpaperFeedAdapter.EPaperFeedModel> ePaperFeedModelList, EPaperFeedNavigator mListener) {
        this.context = context;
        this.ePaperFeedModelList = ePaperFeedModelList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public EpaperFeedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterEpaperfeedBinding epaperfeedBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.adapter_epaperfeed, parent, false);
        return new EpaperFeedAdapter.ViewHolder(epaperfeedBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull EpaperFeedAdapter.ViewHolder holder, int position) {
        EpaperFeedAdapter.EPaperFeedModel ePaperFeedModel = ePaperFeedModelList.get(position);
//        holder.epaperfeedBinding.setModel(newsFeedModel);
        holder.epaperfeedBinding.image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_UP) {
                Animation slideUp = AnimationUtils.loadAnimation(context, R.anim.zoom_in);
                holder.epaperfeedBinding.image.startAnimation(slideUp);
                // Do what you want
//                    return true;
//                }
                return false;
            }
        });
        Glide.with(context)
                .load(ePaperFeedModel.newsPaperImage)
                .into(holder.epaperfeedBinding.image);

        holder.epaperfeedBinding.name.setText(ePaperFeedModel.getNewPapreName());
        holder.itemView.setOnClickListener(view -> {
            if (mListener != null) {
                mListener.onItemClickParer(ePaperFeedModelList);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ePaperFeedModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AdapterEpaperfeedBinding epaperfeedBinding;

        public ViewHolder(@NonNull AdapterEpaperfeedBinding epaperfeedBinding) {
            super(epaperfeedBinding.getRoot());
            this.epaperfeedBinding = epaperfeedBinding;
        }
    }

    public static class EPaperFeedModel implements Serializable {
        public String newsPaperImage;
        public String newPapreName;
        public boolean isSelected;

        public String getNewsPaperImage() {
            return newsPaperImage;
        }

        public void setNewsPaperImage(String newsPaperImage) {
            this.newsPaperImage = newsPaperImage;
        }

        public String getNewPapreName() {
            return newPapreName;
        }

        public void setNewPapreName(String newPapreName) {
            this.newPapreName = newPapreName;
        }

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }
    }
}
