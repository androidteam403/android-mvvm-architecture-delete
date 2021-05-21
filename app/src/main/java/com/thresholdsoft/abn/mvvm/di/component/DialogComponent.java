package com.thresholdsoft.abn.mvvm.di.component;

import com.thresholdsoft.abn.mvvm.di.module.DialogModule;
import com.thresholdsoft.abn.mvvm.ui.main.rating.RateUsDialog;
import com.thresholdsoft.abn.mvvm.di.scope.DialogScope;

import dagger.Component;

/*
 * Author: rotbolt
 */

@DialogScope
@Component(modules = DialogModule.class, dependencies = AppComponent.class)
public interface DialogComponent {

    void inject(RateUsDialog dialog);

}
