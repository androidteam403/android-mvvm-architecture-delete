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
import com.thresholdsoft.abn.mvvm.ui.main.dialog.RateUsCallback;

import java.util.List;

public class DropdownAdapter extends RecyclerView.Adapter<DropdownAdapter.ViewHolder> {
    private Context context;
    private List<String> getDropDownList;
    private RateUsCallback rateUsCallback;

    public DropdownAdapter(Context context, List<String> getDropDownList, RateUsCallback rateUsCallback) {
        this.context = context;
        this.getDropDownList = getDropDownList;
        this.rateUsCallback = rateUsCallback;
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
        String name = getDropDownList.get(position);
        holder.dropdownBinding.setName(name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rateUsCallback != null) {
                    rateUsCallback.onItemClick(name);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return getDropDownList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AdapterDropdownBinding dropdownBinding;

        public ViewHolder(@NonNull AdapterDropdownBinding dropdownBinding) {
            super(dropdownBinding.getRoot());
            this.dropdownBinding = dropdownBinding;
        }
    }
}
