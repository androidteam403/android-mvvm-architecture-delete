package com.thresholdsoft.abn.mvvm.di.module;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.thresholdsoft.abn.mvvm.ViewModelProviderFactory;
import com.thresholdsoft.abn.mvvm.data.DataManager;
import com.thresholdsoft.abn.mvvm.ui.about.AboutViewModel;
import com.thresholdsoft.abn.mvvm.ui.base.BaseFragment;
import com.thresholdsoft.abn.mvvm.ui.feed.blogs.BlogAdapter;
import com.thresholdsoft.abn.mvvm.ui.feed.blogs.BlogViewModel;
import com.thresholdsoft.abn.mvvm.ui.feed.opensource.OpenSourceAdapter;
import com.thresholdsoft.abn.mvvm.ui.feed.opensource.OpenSourceViewModel;
import com.thresholdsoft.abn.mvvm.ViewModelProviderFactory;
import com.thresholdsoft.abn.mvvm.ui.main.ui.epapersfeed.EPaperFeedViewModel;
import com.thresholdsoft.abn.mvvm.ui.main.ui.newsfeed.NewsFeedViewModel;
import com.thresholdsoft.abn.mvvm.ui.main.ui.speednews.SpeedNewsViewModel;
import com.thresholdsoft.abn.mvvm.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/*
 * Author: rotbolt
 */

@Module
public class FragmentModule {

    private BaseFragment<?, ?> fragment;

    public FragmentModule(BaseFragment<?, ?> fragment) {
        this.fragment = fragment;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(fragment.getActivity());
    }

    @Provides
    AboutViewModel provideAboutViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        Supplier<AboutViewModel> supplier = () -> new AboutViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<AboutViewModel> factory = new ViewModelProviderFactory<>(AboutViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(AboutViewModel.class);
    }

    @Provides
    BlogAdapter provideBlogAdapter() {
        return new BlogAdapter(new ArrayList<>());
    }


    @Provides
    BlogViewModel provideBlogViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        Supplier<BlogViewModel> supplier = () -> new BlogViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<BlogViewModel> factory = new ViewModelProviderFactory<>(BlogViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(BlogViewModel.class);
    }

    @Provides
    OpenSourceAdapter provideOpenSourceAdapter() {
        return new OpenSourceAdapter();
    }

    @Provides
    OpenSourceViewModel provideOpenSourceViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        Supplier<OpenSourceViewModel> supplier = () -> new OpenSourceViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<OpenSourceViewModel> factory = new ViewModelProviderFactory<>(OpenSourceViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(OpenSourceViewModel.class);
    }

    @Provides
    NewsFeedViewModel provideNewsFeedViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        Supplier<NewsFeedViewModel> supplier = () -> new NewsFeedViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<NewsFeedViewModel> factory = new ViewModelProviderFactory<>(NewsFeedViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(NewsFeedViewModel.class);
    }

    @Provides
    SpeedNewsViewModel provideSpeedNewsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        Supplier<SpeedNewsViewModel> supplier = () -> new SpeedNewsViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<SpeedNewsViewModel> factory = new ViewModelProviderFactory<>(SpeedNewsViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(SpeedNewsViewModel.class);
    }

    @Provides
    EPaperFeedViewModel provideEpaperFeedViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        Supplier<EPaperFeedViewModel> supplier = () -> new EPaperFeedViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<EPaperFeedViewModel> factory = new ViewModelProviderFactory<>(EPaperFeedViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(EPaperFeedViewModel.class);
    }
}
