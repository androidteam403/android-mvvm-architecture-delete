package com.thresholdsoft.abn.mvvm.di.component;

import com.thresholdsoft.abn.mvvm.di.module.FragmentModule;
import com.thresholdsoft.abn.mvvm.di.scope.FragmentScope;
import com.thresholdsoft.abn.mvvm.ui.about.AboutFragment;
import com.thresholdsoft.abn.mvvm.ui.feed.blogs.BlogFragment;
import com.thresholdsoft.abn.mvvm.ui.feed.opensource.OpenSourceFragment;
import com.thresholdsoft.abn.mvvm.ui.main.ui.epapersfeed.EPaperFeedFragment;
import com.thresholdsoft.abn.mvvm.ui.main.ui.livetvfeed.LiveTvFragment;
import com.thresholdsoft.abn.mvvm.ui.main.ui.newsfeed.NewsFeedFragment;
import com.thresholdsoft.abn.mvvm.ui.main.ui.speednews.SpeedNewsFragment;

import dagger.Component;

/*
 * Author: rotbolt
 */

@FragmentScope
@Component(modules = FragmentModule.class, dependencies = AppComponent.class)
public interface FragmentComponent {
    void inject(BlogFragment fragment);

    void inject(OpenSourceFragment fragment);

    void inject(AboutFragment fragment);

    void inject(NewsFeedFragment newsFeedFragment);

    void inject(SpeedNewsFragment speedNewsFragment);

    void inject(EPaperFeedFragment ePaperFeedFragment);

    void inject(LiveTvFragment liveTvFragment);

}
