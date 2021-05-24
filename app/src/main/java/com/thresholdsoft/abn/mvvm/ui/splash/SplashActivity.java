
package com.thresholdsoft.abn.mvvm.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.thresholdsoft.abn.BR;
import com.thresholdsoft.abn.R;
import com.thresholdsoft.abn.databinding.ActivitySplashBinding;
import com.thresholdsoft.abn.mvvm.di.component.ActivityComponent;
import com.thresholdsoft.abn.mvvm.ui.base.BaseActivity;
import com.thresholdsoft.abn.mvvm.ui.main.MainActivity;


public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = MainActivity.newIntent(SplashActivity.this);
            startActivity(intent);
            finish();
        }, 2000);
//        mViewModel.startSeeding();
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }
}
