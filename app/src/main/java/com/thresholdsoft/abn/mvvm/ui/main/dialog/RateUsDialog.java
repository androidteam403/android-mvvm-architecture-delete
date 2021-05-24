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

import java.util.List;

import javax.inject.Inject;


public class RateUsDialog extends BaseDialog implements RateUsCallback {

    private static final String TAG = "RateUsDialog";
    private List<String> dropDownListItems;
    private MainNavigator mainNavigator;
    @Inject
    RateUsViewModel mRateUsViewModel;

    public static RateUsDialog newInstance() {
        RateUsDialog fragment = new RateUsDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    public void setDropDownList(List<String> dropDownListItems, MainNavigator mainNavigator) {
        this.dropDownListItems = dropDownListItems;
        this.mainNavigator = mainNavigator;
    }

    @Override
    public void dismissDialog() {
        dismissDialog(TAG);
    }

    @Override
    public void onItemClick(String name) {
        mainNavigator.onDismisDropDownDialog(name);
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
        DropdownAdapter dropdownAdapter = new DropdownAdapter(getContext(), dropDownListItems, this);
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
