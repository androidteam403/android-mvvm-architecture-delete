package com.thresholdsoft.abn.mvvm.di.component;

import com.thresholdsoft.abn.mvvm.di.module.ActivityModule;
import com.thresholdsoft.abn.mvvm.di.scope.ActivityScope;
import com.thresholdsoft.abn.mvvm.ui.epaperdetails.EpaperDetailsActivity;
import com.thresholdsoft.abn.mvvm.ui.feed.FeedActivity;
import com.thresholdsoft.abn.mvvm.ui.login.LoginActivity;
import com.thresholdsoft.abn.mvvm.ui.main.MainActivity;
import com.thresholdsoft.abn.mvvm.ui.splash.SplashActivity;

import dagger.Component;

/*
 * Author: rotbolt
 */

@ActivityScope
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {

    void inject(FeedActivity activity);

    void inject(LoginActivity activity);

    void inject(MainActivity activity);

    void inject(SplashActivity activity);

    void inject(EpaperDetailsActivity activity);

}
