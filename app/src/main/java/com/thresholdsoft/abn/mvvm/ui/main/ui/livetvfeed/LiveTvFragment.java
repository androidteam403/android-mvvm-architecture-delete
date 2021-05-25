package com.thresholdsoft.abn.mvvm.ui.main.ui.livetvfeed;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.thresholdsoft.abn.BR;
import com.thresholdsoft.abn.R;
import com.thresholdsoft.abn.databinding.FragmentLiveTvBinding;
import com.thresholdsoft.abn.mvvm.di.component.FragmentComponent;
import com.thresholdsoft.abn.mvvm.ui.base.BaseFragment;

public class LiveTvFragment extends BaseFragment<FragmentLiveTvBinding, LiveTvViewModel>
        implements LiveTvNavigator {
    public static final String TAG = "LiveTvFragment";

    private FragmentLiveTvBinding fragmentLiveTvBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_live_tv;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentLiveTvBinding = getViewDataBinding();
        setUp();
    }

    private void setUp() {
        String myYouTubeVideoUrl = "https://www.youtube.com/embed/IKj_cj51_W0";

        String dataUrl =
                "<html>" +"<iframe width=\"100%\" height=\"100%\" src=\""+myYouTubeVideoUrl+"\" frameborder=\"0\" allowfullscreen/>" +"</html>";


        WebSettings webSettings = fragmentLiveTvBinding.mWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        fragmentLiveTvBinding.mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        fragmentLiveTvBinding.mWebView.getSettings().setLoadWithOverviewMode(true);
        fragmentLiveTvBinding.mWebView.getSettings().setUseWideViewPort(true);
        fragmentLiveTvBinding.mWebView.loadData(dataUrl, "text/html", "utf-8");
    }


//    private void setUp() {
//        newsFeedModelList = new ArrayList<>();
//        NewsFeedAdapter.NewsFeedModel newsFeedModel = new NewsFeedAdapter.NewsFeedModel();
//        newsFeedModel.setHeading("కరోనా నియంత్రణపై సీఎం జగన్ సమీక్ష");
//        newsFeedModel.setTime("an hour ago");
//        newsFeedModelList.add(newsFeedModel);
//        newsFeedModel = new NewsFeedAdapter.NewsFeedModel();
//        newsFeedModel.setHeading("రఘురామ పాదాలకు గాయాలున్నట్టు నిర్ధారణ.. విచారణ వాయిదా");
//        newsFeedModel.setTime("1 hour ago");
//        newsFeedModelList.add(newsFeedModel);
//        newsFeedModel = new NewsFeedAdapter.NewsFeedModel();
//        newsFeedModel.setHeading("ఇది పరీక్షా సమయం");
//        newsFeedModel.setTime("1 hour ago");
//        newsFeedModelList.add(newsFeedModel);
//        newsFeedModel = new NewsFeedAdapter.NewsFeedModel();
//        newsFeedModel.setHeading("కరోనా నియంత్రణపై సీఎం జగన్ సమీక్ష");
//        newsFeedModel.setTime("2 hour ago");
//        newsFeedModelList.add(newsFeedModel);
//        newsFeedModel = new NewsFeedAdapter.NewsFeedModel();
//        newsFeedModel.setHeading("రఘురామ పాదాలకు గాయాలున్నట్టు నిర్ధారణ.. విచారణ వాయిదా");
//        newsFeedModel.setTime("3 hour ago");
//        newsFeedModelList.add(newsFeedModel);
//        newsFeedModel = new NewsFeedAdapter.NewsFeedModel();
//        newsFeedModel.setHeading("ఇది పరీక్షా సమయం");
//        newsFeedModel.setTime("3 hour ago");
//        newsFeedModelList.add(newsFeedModel);
//        newsFeedModel = new NewsFeedAdapter.NewsFeedModel();
//        newsFeedModel.setHeading("రఘురామ పాదాలకు గాయాలున్నట్టు నిర్ధారణ.. విచారణ వాయిదా");
//        newsFeedModel.setTime("4 hour ago");
//        newsFeedModelList.add(newsFeedModel);
//        newsFeedModel = new NewsFeedAdapter.NewsFeedModel();
//        newsFeedModel.setHeading("కరోనా నియంత్రణపై సీఎం జగన్ సమీక్ష");
//        newsFeedModel.setTime("4 hour ago");
//        newsFeedModelList.add(newsFeedModel);
//        newsFeedModel = new NewsFeedAdapter.NewsFeedModel();
//        newsFeedModel.setHeading("ఇది పరీక్షా సమయం");
//        newsFeedModel.setTime("5 hour ago");
//        newsFeedModelList.add(newsFeedModel);
//
//        newsFeedAdapter = new NewsFeedAdapter(getContext(), newsFeedModelList, this);
//        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL);
//        newsFeedBinding.newsFeedRecyclerview.addItemDecoration(dividerItemDecoration);
//        newsFeedBinding.newsFeedRecyclerview.setLayoutManager(mLayoutManager1);
//        newsFeedBinding.newsFeedRecyclerview.setItemAnimator(new DefaultItemAnimator());
//        newsFeedBinding.newsFeedRecyclerview.setAdapter(newsFeedAdapter);
//    }

}