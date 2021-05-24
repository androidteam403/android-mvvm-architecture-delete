package com.thresholdsoft.abn.mvvm.ui.main.ui.newsfeed;

import com.thresholdsoft.abn.mvvm.data.DataManager;
import com.thresholdsoft.abn.mvvm.ui.base.BaseViewModel;
import com.thresholdsoft.abn.mvvm.utils.rx.SchedulerProvider;

public class NewsFeedViewModel extends BaseViewModel<NewsFeedNavigator> {
    public NewsFeedViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
