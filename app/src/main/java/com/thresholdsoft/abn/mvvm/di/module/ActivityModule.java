package com.thresholdsoft.abn.mvvm.di.module;


import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;

import com.thresholdsoft.abn.mvvm.ViewModelProviderFactory;
import com.thresholdsoft.abn.mvvm.data.DataManager;
import com.thresholdsoft.abn.mvvm.ui.base.BaseActivity;
import com.thresholdsoft.abn.mvvm.ui.epaperdetails.EpaperDetailsViewModel;
import com.thresholdsoft.abn.mvvm.ui.feed.FeedPagerAdapter;
import com.thresholdsoft.abn.mvvm.ui.feed.FeedViewModel;
import com.thresholdsoft.abn.mvvm.ui.login.LoginViewModel;
import com.thresholdsoft.abn.mvvm.ui.main.MainViewModel;
import com.thresholdsoft.abn.mvvm.ui.splash.SplashViewModel;
import com.thresholdsoft.abn.mvvm.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/*
 * Author: rotbolt
 */

@Module
public class ActivityModule {
    private BaseActivity<?, ?> activity;

    public ActivityModule(BaseActivity<?, ?> activity) {
        this.activity = activity;
    }

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter() {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    FeedViewModel provideFeedViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        Supplier<FeedViewModel> supplier = () -> new FeedViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<FeedViewModel> factory = new ViewModelProviderFactory<>(FeedViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(FeedViewModel.class);
    }

    @Provides
    MainViewModel provideMainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        Supplier<MainViewModel> supplier = () -> new MainViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<MainViewModel> factory = new ViewModelProviderFactory<>(MainViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(MainViewModel.class);
    }

    @Provides
    LoginViewModel provideLoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        Supplier<LoginViewModel> supplier = () -> new LoginViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<LoginViewModel> factory = new ViewModelProviderFactory<>(LoginViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(LoginViewModel.class);
    }

    @Provides
    SplashViewModel provideSplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        Supplier<SplashViewModel> supplier = () -> new SplashViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<SplashViewModel> factory = new ViewModelProviderFactory<>(SplashViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(SplashViewModel.class);
    }
    @Provides
    EpaperDetailsViewModel provideEpaperDetailsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        Supplier<EpaperDetailsViewModel> supplier = () -> new EpaperDetailsViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<EpaperDetailsViewModel> factory = new ViewModelProviderFactory<>(EpaperDetailsViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(EpaperDetailsViewModel.class);
    }
}
