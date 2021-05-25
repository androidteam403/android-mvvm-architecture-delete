package com.thresholdsoft.abn.mvvm.ui.epaperdetails.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.thresholdsoft.abn.R;
import com.thresholdsoft.abn.databinding.AdapterSelectedPaperBinding;
import com.thresholdsoft.abn.mvvm.ui.epaperdetails.EpaperDetailsNavigator;
import com.thresholdsoft.abn.mvvm.ui.main.ui.epapersfeed.adapter.EpaperFeedAdapter;

import java.util.List;

public class SelectedPaperAdapter extends RecyclerView.Adapter<SelectedPaperAdapter.ViewHolder> {
    private Context context;
    private List<EpaperFeedAdapter.EPaperFeedModel> ePaperFeedModelList;
    private EpaperDetailsNavigator mListener;

    public SelectedPaperAdapter(Context context, List<EpaperFeedAdapter.EPaperFeedModel> ePaperFeedModelList, EpaperDetailsNavigator mListener) {
        this.context = context;
        this.ePaperFeedModelList = ePaperFeedModelList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterSelectedPaperBinding selectedPaperBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.adapter_selected_paper, parent, false);
        return new SelectedPaperAdapter.ViewHolder(selectedPaperBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EpaperFeedAdapter.EPaperFeedModel ePaperFeedModel = ePaperFeedModelList.get(position);
        Glide.with(context)
                .load(ePaperFeedModel.getNewsPaperImage())
                .into(holder.selectedPaperBinding.ePaperImg);
        if (ePaperFeedModel.isSelected()) {
            holder.selectedPaperBinding.parent.setBackground(context.getResources().getDrawable(R.drawable.bg_selected_paper_list));
        } else {
            holder.selectedPaperBinding.parent.setBackground(context.getResources().getDrawable(R.drawable.bg_unselected_paper_list));
        }
        holder.itemView.setOnClickListener(view -> {
            if (mListener != null) {
                mListener.onItemClick(position, ePaperFeedModelList);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ePaperFeedModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AdapterSelectedPaperBinding selectedPaperBinding;

        public ViewHolder(@NonNull AdapterSelectedPaperBinding selectedPaperBinding) {
            super(selectedPaperBinding.getRoot());
            this.selectedPaperBinding = selectedPaperBinding;
        }
    }
}
