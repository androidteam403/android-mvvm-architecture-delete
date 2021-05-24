package com.thresholdsoft.abn.mvvm.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.thresholdsoft.abn.R;
import com.thresholdsoft.abn.databinding.AdapterDropdownBinding;
import com.thresholdsoft.abn.mvvm.ui.main.dialog.DropDownNavigator;
import com.thresholdsoft.abn.mvvm.ui.main.ui.model.NewsAreaCategoryModel;

import java.util.List;

public class DropdownAdapter extends RecyclerView.Adapter<DropdownAdapter.ViewHolder> {
    private Context context;
    private List<NewsAreaCategoryModel> newsAreaCategoryModelList;
    private DropDownNavigator dropDownNavigator;

    public DropdownAdapter(Context context, List<NewsAreaCategoryModel> newsAreaCategoryModelList, DropDownNavigator dropDownNavigator) {
        this.context = context;
        this.newsAreaCategoryModelList = newsAreaCategoryModelList;
        this.dropDownNavigator = dropDownNavigator;
    }

    @NonNull
    @Override
    public DropdownAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterDropdownBinding dropdownBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.adapter_dropdown, parent, false);
        return new DropdownAdapter.ViewHolder(dropdownBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DropdownAdapter.ViewHolder holder, int position) {
        NewsAreaCategoryModel newsAreaCategoryModel = newsAreaCategoryModelList.get(position);
        holder.dropdownBinding.setNewsAreaCategoryModel(newsAreaCategoryModel);
        holder.itemView.setOnClickListener(view -> {
            if (dropDownNavigator != null) {
                dropDownNavigator.onItemClick(newsAreaCategoryModel);
            }
        });

    }

    @Override
    public int getItemCount() {
        return newsAreaCategoryModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AdapterDropdownBinding dropdownBinding;

        public ViewHolder(@NonNull AdapterDropdownBinding dropdownBinding) {
            super(dropdownBinding.getRoot());
            this.dropdownBinding = dropdownBinding;
        }
    }
}
