package com.thresholdsoft.abn.mvvm.ui.main.ui.epapersfeed;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thresholdsoft.abn.BR;
import com.thresholdsoft.abn.R;
import com.thresholdsoft.abn.databinding.FragmentEpaperFeedBinding;
import com.thresholdsoft.abn.mvvm.di.component.FragmentComponent;
import com.thresholdsoft.abn.mvvm.ui.base.BaseFragment;
import com.thresholdsoft.abn.mvvm.ui.epaperdetails.EpaperDetailsActivity;
import com.thresholdsoft.abn.mvvm.ui.main.ui.epapersfeed.adapter.EpaperFeedAdapter;

import java.util.ArrayList;
import java.util.List;

public class EPaperFeedFragment extends BaseFragment<FragmentEpaperFeedBinding, EPaperFeedViewModel>
        implements EPaperFeedNavigator {
    public static final String TAG = "EpaperFeedFragment";

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_epaper_feed;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    private FragmentEpaperFeedBinding epaperFeedBinding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        epaperFeedBinding = getViewDataBinding();
        setUp();
    }

    private void setUp() {
        epaperFeedBinding.setIsMainEdition(true);
        List<EpaperFeedAdapter.EPaperFeedModel> ePaperFeedModelList = new ArrayList<>();
        EpaperFeedAdapter.EPaperFeedModel ePaperFeedModel = new EpaperFeedAdapter.EPaperFeedModel();
        ePaperFeedModel.setNewsPaperImage("https://d2na0fb6srbte6.cloudfront.net/read/imageapi/coverforissue/2169381/newspaper/300");
        ePaperFeedModel.setNewPapreName("Hyderabad");
        ePaperFeedModelList.add(ePaperFeedModel);

        ePaperFeedModel = new EpaperFeedAdapter.EPaperFeedModel();
        ePaperFeedModel.setNewsPaperImage("https://d2na0fb6srbte6.cloudfront.net/read/imageapi/coverforissue/789781/newspaper/300");
        ePaperFeedModel.setNewPapreName("Andhra Pradesh");
        ePaperFeedModelList.add(ePaperFeedModel);

        ePaperFeedModel = new EpaperFeedAdapter.EPaperFeedModel();
        ePaperFeedModel.setNewsPaperImage("https://d2na0fb6srbte6.cloudfront.net/read/imageapi/coverforissue/1490339/newspaper/300");
        ePaperFeedModel.setNewPapreName("Telangana");
        ePaperFeedModelList.add(ePaperFeedModel);

        ePaperFeedModel = new EpaperFeedAdapter.EPaperFeedModel();
        ePaperFeedModel.setNewsPaperImage("https://d2na0fb6srbte6.cloudfront.net/read/imageapi/coverforissue/789781/newspaper/300");
        ePaperFeedModel.setNewPapreName("Navya Daily");
        ePaperFeedModelList.add(ePaperFeedModel);

        ePaperFeedModel = new EpaperFeedAdapter.EPaperFeedModel();
        ePaperFeedModel.setNewsPaperImage("https://d2na0fb6srbte6.cloudfront.net/read/imageapi/coverforissue/2169381/newspaper/300");
        ePaperFeedModel.setNewPapreName("Sunday Magzine");
        ePaperFeedModelList.add(ePaperFeedModel);

        EpaperFeedAdapter epaperFeedAdapter = new EpaperFeedAdapter(getContext(), ePaperFeedModelList, this);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL);
        epaperFeedBinding.epaperFeedRecyclerview.addItemDecoration(dividerItemDecoration);
        epaperFeedBinding.epaperFeedRecyclerview.setLayoutManager(mLayoutManager1);
        epaperFeedBinding.epaperFeedRecyclerview.setItemAnimator(new DefaultItemAnimator());
        epaperFeedBinding.epaperFeedRecyclerview.setAdapter(epaperFeedAdapter);
    }

    @Override
    public void onItemClickParer(List<EpaperFeedAdapter.EPaperFeedModel> ePaperFeedModelList) {
        startActivity(EpaperDetailsActivity.newIntent(getContext(), ePaperFeedModelList));
    }
}
