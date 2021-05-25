package com.thresholdsoft.abn.mvvm.ui.epaperdetails;

import com.thresholdsoft.abn.mvvm.ui.main.ui.epapersfeed.adapter.EpaperFeedAdapter;

import java.util.List;

public interface EpaperDetailsNavigator {
    void onClickPages();

    void onClickPageClips();

    void onItemClick(int pos, List<EpaperFeedAdapter.EPaperFeedModel> ePaperFeedModelList);

    void onClickRightSlidePaper();

    void onClickLeftSlidePaper();
}
