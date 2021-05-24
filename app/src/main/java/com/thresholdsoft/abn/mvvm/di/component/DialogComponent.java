package com.thresholdsoft.abn.mvvm.di.component;

import com.thresholdsoft.abn.mvvm.di.module.DialogModule;
import com.thresholdsoft.abn.mvvm.ui.main.dialog.DropDownDialog;
import com.thresholdsoft.abn.mvvm.di.scope.DialogScope;

import dagger.Component;

/*
 * Author: rotbolt
 */

@DialogScope
@Component(modules = DialogModule.class, dependencies = AppComponent.class)
public interface DialogComponent {

    void inject(DropDownDialog dialog);

}
