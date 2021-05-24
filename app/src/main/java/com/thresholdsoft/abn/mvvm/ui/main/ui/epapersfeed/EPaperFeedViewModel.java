package com.thresholdsoft.abn.mvvm.ui.main.ui.epapersfeed;

import com.thresholdsoft.abn.mvvm.data.DataManager;
import com.thresholdsoft.abn.mvvm.ui.base.BaseViewModel;
import com.thresholdsoft.abn.mvvm.utils.rx.SchedulerProvider;

public class EPaperFeedViewModel extends BaseViewModel<EPaperFeedNavigator> {
    public EPaperFeedViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}