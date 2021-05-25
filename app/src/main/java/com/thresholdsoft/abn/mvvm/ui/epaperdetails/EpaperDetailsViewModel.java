package com.thresholdsoft.abn.mvvm.ui.epaperdetails;

import com.thresholdsoft.abn.mvvm.data.DataManager;
import com.thresholdsoft.abn.mvvm.ui.base.BaseViewModel;
import com.thresholdsoft.abn.mvvm.utils.rx.SchedulerProvider;

public class EpaperDetailsViewModel extends BaseViewModel<EpaperDetailsNavigator> {
    public EpaperDetailsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

//    public void onClickPages() {
//        getNavigator().onClickPages();
//    }
//
//    public void onClickPageClips() {
//        getNavigator().onClickPageClips();
//    }
//
//    public void onClickRightSlidePaper() {
//        getNavigator().onClickRightSlidePaper();
//    }
//
//    public void onClickLeftSlidePaper() {
//        getNavigator().onClickLeftSlidePaper();
//    }
}
