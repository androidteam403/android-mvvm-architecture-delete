package com.thresholdsoft.abn.mvvm.ui.main.ui.newsfeed;

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
import com.thresholdsoft.abn.databinding.FragmentNewsFeedsBinding;
import com.thresholdsoft.abn.mvvm.di.component.FragmentComponent;
import com.thresholdsoft.abn.mvvm.ui.base.BaseFragment;
import com.thresholdsoft.abn.mvvm.ui.main.ui.newsfeed.adapter.NewsFeedAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewsFeedFragment extends BaseFragment<FragmentNewsFeedsBinding, NewsFeedViewModel>
        implements NewsFeedNavigator {
    public static final String TAG = "NewsFeedFragment";

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news_feeds;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    private FragmentNewsFeedsBinding newsFeedBinding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newsFeedBinding = getViewDataBinding();
        setUp();
    }

    private void setUp() {
        List<NewsFeedAdapter.NewsFeedModel> newsFeedModelList = new ArrayList<>();
        NewsFeedAdapter.NewsFeedModel newsFeedModel = new NewsFeedAdapter.NewsFeedModel();
        newsFeedModel.setHeading("కరోనా నియంత్రణపై సీఎం జగన్ సమీక్ష");
        newsFeedModel.setTime("an hour ago");
        newsFeedModelList.add(newsFeedModel);
        newsFeedModel = new NewsFeedAdapter.NewsFeedModel();
        newsFeedModel.setHeading("రఘురామ పాదాలకు గాయాలున్నట్టు నిర్ధారణ.. విచారణ వాయిదా");
        newsFeedModel.setTime("1 hour ago");
        newsFeedModelList.add(newsFeedModel);
        newsFeedModel = new NewsFeedAdapter.NewsFeedModel();
        newsFeedModel.setHeading("ఇది పరీక్షా సమయం");
        newsFeedModel.setTime("1 hour ago");
        newsFeedModelList.add(newsFeedModel);
        newsFeedModel = new NewsFeedAdapter.NewsFeedModel();
        newsFeedModel.setHeading("కరోనా నియంత్రణపై సీఎం జగన్ సమీక్ష");
        newsFeedModel.setTime("2 hour ago");
        newsFeedModelList.add(newsFeedModel);
        newsFeedModel = new NewsFeedAdapter.NewsFeedModel();
        newsFeedModel.setHeading("రఘురామ పాదాలకు గాయాలున్నట్టు నిర్ధారణ.. విచారణ వాయిదా");
        newsFeedModel.setTime("3 hour ago");
        newsFeedModelList.add(newsFeedModel);
        newsFeedModel = new NewsFeedAdapter.NewsFeedModel();
        newsFeedModel.setHeading("ఇది పరీక్షా సమయం");
        newsFeedModel.setTime("3 hour ago");
        newsFeedModelList.add(newsFeedModel);
        newsFeedModel = new NewsFeedAdapter.NewsFeedModel();
        newsFeedModel.setHeading("రఘురామ పాదాలకు గాయాలున్నట్టు నిర్ధారణ.. విచారణ వాయిదా");
        newsFeedModel.setTime("4 hour ago");
        newsFeedModelList.add(newsFeedModel);
        newsFeedModel = new NewsFeedAdapter.NewsFeedModel();
        newsFeedModel.setHeading("కరోనా నియంత్రణపై సీఎం జగన్ సమీక్ష");
        newsFeedModel.setTime("4 hour ago");
        newsFeedModelList.add(newsFeedModel);
        newsFeedModel = new NewsFeedAdapter.NewsFeedModel();
        newsFeedModel.setHeading("ఇది పరీక్షా సమయం");
        newsFeedModel.setTime("5 hour ago");
        newsFeedModelList.add(newsFeedModel);


        NewsFeedAdapter newsFeedAdapter = new NewsFeedAdapter(getContext(), newsFeedModelList, this);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL);
        newsFeedBinding.newsFeedRecyclerview.addItemDecoration(dividerItemDecoration);
        newsFeedBinding.newsFeedRecyclerview.setLayoutManager(mLayoutManager1);
        newsFeedBinding.newsFeedRecyclerview.setItemAnimator(new DefaultItemAnimator());
        newsFeedBinding.newsFeedRecyclerview.setAdapter(newsFeedAdapter);
    }
}
