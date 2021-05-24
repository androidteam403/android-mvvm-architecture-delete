package com.thresholdsoft.abn.mvvm.ui.main.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thresholdsoft.abn.R;
import com.thresholdsoft.abn.databinding.DialogRateUsBinding;
import com.thresholdsoft.abn.mvvm.MvvmApp;
import com.thresholdsoft.abn.mvvm.di.component.DaggerDialogComponent;
import com.thresholdsoft.abn.mvvm.di.component.DialogComponent;
import com.thresholdsoft.abn.mvvm.di.module.DialogModule;
import com.thresholdsoft.abn.mvvm.ui.base.BaseDialog;
import com.thresholdsoft.abn.mvvm.ui.main.MainNavigator;
import com.thresholdsoft.abn.mvvm.ui.main.adapter.DropdownAdapter;
import com.thresholdsoft.abn.mvvm.ui.main.ui.model.NewsAreaCategoryModel;

import java.util.List;

import javax.inject.Inject;


public class DropDownDialog extends BaseDialog implements DropDownNavigator {

    private static final String TAG = "DropDownDialog";
    private List<NewsAreaCategoryModel> newsAreaCategoryModelList;
    private DropdownAdapter dropdownAdapter;
    private MainNavigator mainNavigator;
    @Inject
    RateUsViewModel mRateUsViewModel;

    public static DropDownDialog newInstance() {
        DropDownDialog fragment = new DropDownDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    public void setDropDownList(List<NewsAreaCategoryModel> newsAreaCategoryModelList, MainNavigator mainNavigator) {
        this.newsAreaCategoryModelList = newsAreaCategoryModelList;
        this.mainNavigator = mainNavigator;
    }

    @Override
    public void dismissDialog() {
        dismissDialog(TAG);
    }

    @Override
    public void onItemClick(NewsAreaCategoryModel newsAreaCategoryModel) {
        for (int i = 0; i < newsAreaCategoryModelList.size(); i++) {
            if (newsAreaCategoryModelList.get(i).getName().equals(newsAreaCategoryModel.getName())) {
                newsAreaCategoryModelList.get(i).setCheck(true);
            } else {
                newsAreaCategoryModelList.get(i).setCheck(false);
            }
        }
        dropdownAdapter.notifyDataSetChanged();
        mainNavigator.onDismisDropDownDialog(newsAreaCategoryModel.getName());
        dismiss();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DialogRateUsBinding binding = DataBindingUtil.inflate(inflater, R.layout.dialog_rate_us, container, false);
        View view = binding.getRoot();

        performDependencyInjection(getBuildComponent());

        binding.setViewModel(mRateUsViewModel);
        getDialog().setCanceledOnTouchOutside(true);
        mRateUsViewModel.setNavigator(this);
        showList(binding);
        return view;
    }

    public void showList(DialogRateUsBinding binding) {
        dropdownAdapter = new DropdownAdapter(getContext(), newsAreaCategoryModelList, this);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL);
        binding.dropdownList.addItemDecoration(dividerItemDecoration);
        binding.dropdownList.setLayoutManager(mLayoutManager1);
        binding.dropdownList.setItemAnimator(new DefaultItemAnimator());
        binding.dropdownList.setAdapter(dropdownAdapter);
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    private DialogComponent getBuildComponent() {
        return DaggerDialogComponent.builder()
                .appComponent(((MvvmApp) (getContext().getApplicationContext())).appComponent)
                .dialogModule(new DialogModule(this))
                .build();
    }

    private void performDependencyInjection(DialogComponent buildComponent) {
        buildComponent.inject(this);
    }
}
