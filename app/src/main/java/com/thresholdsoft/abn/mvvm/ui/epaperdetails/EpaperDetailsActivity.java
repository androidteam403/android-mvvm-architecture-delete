package com.thresholdsoft.abn.mvvm.ui.epaperdetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.thresholdsoft.abn.BR;
import com.thresholdsoft.abn.R;
import com.thresholdsoft.abn.databinding.ActivityEpaperDetailsBinding;
import com.thresholdsoft.abn.mvvm.di.component.ActivityComponent;
import com.thresholdsoft.abn.mvvm.ui.base.BaseActivity;
import com.thresholdsoft.abn.mvvm.ui.epaperdetails.adapter.SelectedPaperAdapter;
import com.thresholdsoft.abn.mvvm.ui.main.ui.epapersfeed.adapter.EpaperFeedAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EpaperDetailsActivity extends BaseActivity<ActivityEpaperDetailsBinding, EpaperDetailsViewModel> implements EpaperDetailsNavigator {
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_epaper_details;
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    private ActivityEpaperDetailsBinding epaperDetailsBinding;
    private SelectedPaperAdapter selectedPaperAdapter;
    private int selectedItemPos = 0;
    private List<EpaperFeedAdapter.EPaperFeedModel> ePaperFeedModelList = new ArrayList<>();

    public static Intent newIntent(Context context, List<EpaperFeedAdapter.EPaperFeedModel> ePaperFeedModelList) {
        Intent intent = new Intent(context, EpaperDetailsActivity.class);
        intent.putExtra("ePaperList", (Serializable) ePaperFeedModelList);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.epaperDetailsBinding = getViewDataBinding();
        mViewModel.setNavigator(this);
        epaperDetailsBinding.setCallback(this);
        setUp();
    }

    private void setUp() {
        if (getIntent() != null) {
            ePaperFeedModelList = (List<EpaperFeedAdapter.EPaperFeedModel>) getIntent().getSerializableExtra("ePaperList");
            if (ePaperFeedModelList != null && ePaperFeedModelList.size() > 0) {
                for (int i = 0; i < ePaperFeedModelList.size(); i++) {
                    if (i == 0) {
                        ePaperFeedModelList.get(i).setSelected(true);
                    } else {
                        ePaperFeedModelList.get(i).setSelected(false);
                    }
                }
                Glide.with(getApplicationContext())
                        .load(ePaperFeedModelList.get(0).getNewsPaperImage())
                        .into(epaperDetailsBinding.paperImg);
                selectedPaperAdapter = new SelectedPaperAdapter(getApplicationContext(), ePaperFeedModelList, this);
                RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                epaperDetailsBinding.epaperSelectedRecycler.setLayoutManager(mLayoutManager1);
                epaperDetailsBinding.epaperSelectedRecycler.setItemAnimator(new DefaultItemAnimator());
                epaperDetailsBinding.epaperSelectedRecycler.setAdapter(selectedPaperAdapter);
                epaperDetailsBinding.paperPageNum.setText(1 + " of " + ePaperFeedModelList.size());
            }
        }
//        epaperDetailsBinding.pages.setOnClickListener(view -> {
//            epaperDetailsBinding.pages.setBackground(getResources().getDrawable(R.drawable.bg_selected_pages_pageclips));
//            epaperDetailsBinding.pages.setTextColor(getResources().getColor(R.color.white));
//            epaperDetailsBinding.pageClips.setBackground(getResources().getDrawable(R.drawable.bg_unselected_pages_pageclips));
//            epaperDetailsBinding.pageClips.setTextColor(getResources().getColor(R.color.iron));
//        });
//        epaperDetailsBinding.pageClips.setOnClickListener(view -> {
//            epaperDetailsBinding.pageClips.setBackground(getResources().getDrawable(R.drawable.bg_selected_pages_pageclips));
//            epaperDetailsBinding.pageClips.setTextColor(getResources().getColor(R.color.white));
//            epaperDetailsBinding.pages.setBackground(getResources().getDrawable(R.drawable.bg_unselected_pages_pageclips));
//            epaperDetailsBinding.pages.setTextColor(getResources().getColor(R.color.iron));
//        });
    }

    @Override
    public void onClickPages() {
        epaperDetailsBinding.pages.setBackground(getResources().getDrawable(R.drawable.bg_selected_pages_pageclips));
        epaperDetailsBinding.pages.setTextColor(getResources().getColor(R.color.white));
        epaperDetailsBinding.pageClips.setBackground(getResources().getDrawable(R.drawable.bg_unselected_pages_pageclips));
        epaperDetailsBinding.pageClips.setTextColor(getResources().getColor(R.color.iron));
    }

    @Override
    public void onClickPageClips() {
        epaperDetailsBinding.pageClips.setBackground(getResources().getDrawable(R.drawable.bg_selected_pages_pageclips));
        epaperDetailsBinding.pageClips.setTextColor(getResources().getColor(R.color.white));
        epaperDetailsBinding.pages.setBackground(getResources().getDrawable(R.drawable.bg_unselected_pages_pageclips));
        epaperDetailsBinding.pages.setTextColor(getResources().getColor(R.color.iron));
    }

    @Override
    public void onItemClick(int pos, List<EpaperFeedAdapter.EPaperFeedModel> ePaperFeedModelLists) {
        if (ePaperFeedModelList != null && ePaperFeedModelList.size() > 0) {
            for (int i = 0; i < ePaperFeedModelList.size(); i++) {
                if (i == pos) {
                    ePaperFeedModelList.get(i).setSelected(true);
                    Glide.with(getApplicationContext())
                            .load(ePaperFeedModelList.get(i).getNewsPaperImage())
                            .into(epaperDetailsBinding.paperImg);
                    epaperDetailsBinding.paperPageNum.setText(i + 1 + " of " + ePaperFeedModelList.size());
                    selectedItemPos = i;
                } else {
                    ePaperFeedModelList.get(i).setSelected(false);
                }
            }
            selectedPaperAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClickRightSlidePaper() {
        if (ePaperFeedModelList != null && ePaperFeedModelList.size() > 0) {
            if (selectedItemPos != ePaperFeedModelList.size()) {
                int pos = -1;
                for (int i = 0; i < ePaperFeedModelList.size(); i++) {
                    if (i == selectedItemPos + 1) {
                        ePaperFeedModelList.get(i).setSelected(true);
                        Glide.with(getApplicationContext())
                                .load(ePaperFeedModelList.get(i).getNewsPaperImage())
                                .into(epaperDetailsBinding.paperImg);
                        epaperDetailsBinding.paperPageNum.setText(i + 1 + " of " + ePaperFeedModelList.size());
                        pos = i;
                    } else {
                        ePaperFeedModelList.get(i).setSelected(false);
                    }
                }
                if (pos != -1) {
                    selectedItemPos = pos;
                }
                selectedPaperAdapter.notifyDataSetChanged();
            }
//        Toast.makeText(this, "hiii", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClickLeftSlidePaper() {
        if (ePaperFeedModelList != null && ePaperFeedModelList.size() > 0) {
            if (selectedItemPos != 0) {
                int pos = -1;
                for (int i = 0; i < ePaperFeedModelList.size(); i++) {
                    if (i == selectedItemPos - 1) {
                        ePaperFeedModelList.get(i).setSelected(true);
                        Glide.with(getApplicationContext())
                                .load(ePaperFeedModelList.get(i).getNewsPaperImage())
                                .into(epaperDetailsBinding.paperImg);
                        epaperDetailsBinding.paperPageNum.setText(i + 1 + " of " + ePaperFeedModelList.size());
                        pos = i;
                    } else {
                        ePaperFeedModelList.get(i).setSelected(false);
                    }
                }
                if (pos != -1) {
                    selectedItemPos = pos;
                }
                selectedPaperAdapter.notifyDataSetChanged();
            }
//        Toast.makeText(this, "hellooooo", Toast.LENGTH_SHORT).show();
        }
    }
}
