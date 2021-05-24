package com.thresholdsoft.abn.mvvm.ui.main.dialog;

import com.thresholdsoft.abn.mvvm.ui.main.ui.model.NewsAreaCategoryModel;

public interface DropDownNavigator {

    void dismissDialog();

    void onItemClick(NewsAreaCategoryModel newsAreaCategoryModel);
}
