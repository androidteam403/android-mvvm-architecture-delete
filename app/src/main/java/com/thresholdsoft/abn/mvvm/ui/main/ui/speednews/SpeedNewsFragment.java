package com.thresholdsoft.abn.mvvm.ui.main.ui.speednews;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.thresholdsoft.abn.BR;
import com.thresholdsoft.abn.R;
import com.thresholdsoft.abn.databinding.FragmentSpeedNewsBinding;
import com.thresholdsoft.abn.mvvm.di.component.FragmentComponent;
import com.thresholdsoft.abn.mvvm.ui.base.BaseFragment;

public class SpeedNewsFragment extends BaseFragment<FragmentSpeedNewsBinding, SpeedNewsViewModel>
        implements SpeedNewsNavigator {
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_speed_news;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }
    public static final String TAG = "SpeedNewsFragment";
    private FragmentSpeedNewsBinding speedNewsBinding;

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.speedNewsBinding = getViewDataBinding();
    }
}
