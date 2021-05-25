package com.thresholdsoft.abn.mvvm.ui.main.ui.speednews;

import com.thresholdsoft.abn.mvvm.data.DataManager;
import com.thresholdsoft.abn.mvvm.ui.base.BaseViewModel;
import com.thresholdsoft.abn.mvvm.utils.rx.SchedulerProvider;

public class SpeedNewsViewModel extends BaseViewModel<SpeedNewsViewModel> {
    public SpeedNewsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
