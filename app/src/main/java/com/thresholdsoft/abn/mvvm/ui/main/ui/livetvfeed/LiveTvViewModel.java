package com.thresholdsoft.abn.mvvm.ui.main.ui.livetvfeed;

import com.thresholdsoft.abn.mvvm.data.DataManager;
import com.thresholdsoft.abn.mvvm.ui.base.BaseViewModel;
import com.thresholdsoft.abn.mvvm.ui.main.ui.newsfeed.NewsFeedNavigator;
import com.thresholdsoft.abn.mvvm.utils.rx.SchedulerProvider;

public class LiveTvViewModel extends BaseViewModel<LiveTvNavigator> {
    public LiveTvViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
