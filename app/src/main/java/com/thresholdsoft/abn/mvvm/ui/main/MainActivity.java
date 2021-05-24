package com.thresholdsoft.abn.mvvm.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.thresholdsoft.abn.BR;
import com.thresholdsoft.abn.BuildConfig;
import com.thresholdsoft.abn.R;
import com.thresholdsoft.abn.databinding.ActivityMainBinding;
import com.thresholdsoft.abn.databinding.NavHeaderMainBinding;
import com.thresholdsoft.abn.mvvm.di.component.ActivityComponent;
import com.thresholdsoft.abn.mvvm.ui.about.AboutFragment;
import com.thresholdsoft.abn.mvvm.ui.base.BaseActivity;
import com.thresholdsoft.abn.mvvm.ui.login.LoginActivity;
import com.thresholdsoft.abn.mvvm.ui.main.dialog.DropDownDialog;
import com.thresholdsoft.abn.mvvm.ui.main.ui.model.NewsAreaCategoryModel;
import com.thresholdsoft.abn.mvvm.ui.main.dialog.RateUsDialog;
import com.thresholdsoft.abn.mvvm.ui.main.ui.epapersfeed.EPaperFeedFragment;
import com.thresholdsoft.abn.mvvm.ui.main.ui.newsfeed.NewsFeedFragment;
import com.thresholdsoft.abn.mvvm.ui.main.ui.speednews.SpeedNewsFragment;
import com.thresholdsoft.abn.mvvm.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator {

    private ActivityMainBinding mActivityMainBinding;
    private SwipePlaceHolderView mCardsContainerView;
    private DrawerLayout mDrawer;

    private NavigationView mNavigationView;
    private Toolbar mToolbar;

    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(AboutFragment.TAG);
        if (fragment == null) {
            super.onBackPressed();
        } else {
            onFragmentDetached(AboutFragment.TAG);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onFragmentDetached(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .remove(fragment)
                    .commitNow();
            unlockDrawer();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
//        switch (item.getItemId()) {
//            case R.id.action_cut:
//                return true;
//            case R.id.action_copy:
//                return true;
//            case R.id.action_share:
//                return true;
//            case R.id.action_delete:
//                return true;
//            default:
        return super.onOptionsItemSelected(item);
//        }
    }

    @Override
    public void openLoginActivity() {
        startActivity(LoginActivity.newIntent(this));
        finish();
    }

    @Override
    public void onClickNews() {
        bottomNavigationItemSelectionUnselectionHandling();
        mActivityMainBinding.news.setBackground(getResources().getDrawable(R.drawable.bottomnav_itemselected_bg));
        NewsFeedFragment newsFeedFragment = new NewsFeedFragment();
        loadFragment(newsFeedFragment, NewsFeedFragment.TAG);
    }

    @Override
    public void onClickLiveTv() {
        bottomNavigationItemSelectionUnselectionHandling();
        mActivityMainBinding.livetv.setBackground(getResources().getDrawable(R.drawable.bottomnav_itemselected_bg));
    }

    @Override
    public void onClickSpeedNews() {
        bottomNavigationItemSelectionUnselectionHandling();
        mActivityMainBinding.speedNews.setBackground(getResources().getDrawable(R.drawable.bottomnav_itemselected_bg));
        SpeedNewsFragment speedNewsFragment = new SpeedNewsFragment();
        loadFragment(speedNewsFragment, SpeedNewsFragment.TAG);
    }

    private void bottomNavigationItemSelectionUnselectionHandling() {
        mActivityMainBinding.news.setBackground(null);
        mActivityMainBinding.ePapers.setBackground(null);
        mActivityMainBinding.livetv.setBackground(null);
        mActivityMainBinding.speedNews.setBackground(null);
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onClickNavigationMenu() {
        mDrawer.openDrawer(Gravity.START);
    }

    private List<NewsAreaCategoryModel> newsAreaCategoryModelList;

    @Override
    public void onClickDropDown() {
//        RateUsDialog.newInstance().show(getSupportFragmentManager());
        if (newsAreaCategoryModelList != null && newsAreaCategoryModelList.size() > 0) {
            DropDownDialog dropDownDialog = new DropDownDialog();
            dropDownDialog.setDropDownList(newsAreaCategoryModelList, this);
            dropDownDialog.show(getSupportFragmentManager());
        } else {
            newsAreaCategoryModelList = new ArrayList<>();
            NewsAreaCategoryModel newsAreaCategoryModel = new NewsAreaCategoryModel();
            newsAreaCategoryModel.setName("తెలంగాణ");
            newsAreaCategoryModel.setCheck(true);
            newsAreaCategoryModelList.add(newsAreaCategoryModel);
            newsAreaCategoryModel = new NewsAreaCategoryModel();
            newsAreaCategoryModel.setName("ఆంధ్రప్రదేశ్");
            newsAreaCategoryModel.setCheck(false);
            newsAreaCategoryModelList.add(newsAreaCategoryModel);
            newsAreaCategoryModel = new NewsAreaCategoryModel();
            newsAreaCategoryModel.setName("జాతీయం");
            newsAreaCategoryModel.setCheck(false);
            newsAreaCategoryModelList.add(newsAreaCategoryModel);
            newsAreaCategoryModel = new NewsAreaCategoryModel();
            newsAreaCategoryModel.setName("టెక్నాలజీ");
            newsAreaCategoryModel.setCheck(false);
            newsAreaCategoryModelList.add(newsAreaCategoryModel);
            DropDownDialog dropDownDialog = new DropDownDialog();
            dropDownDialog.setDropDownList(newsAreaCategoryModelList, this);
            dropDownDialog.show(getSupportFragmentManager());
        }
    }

    @Override
    public void onDismisDropDownDialog(String name) {
        mActivityMainBinding.dropdownName.setText(name);
        for (int i = 0; i < newsAreaCategoryModelList.size(); i++) {
            newsAreaCategoryModelList.get(i).setCheck(false);
            if (newsAreaCategoryModelList.get(i).getName().equals(name)) {
                newsAreaCategoryModelList.get(i).setCheck(true);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = getViewDataBinding();
        mViewModel.setNavigator(this);
        setUp();
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mDrawer != null) {
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }
    }

    private void lockDrawer() {
        if (mDrawer != null) {
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }
    }

    private void setUp() {
        mDrawer = mActivityMainBinding.drawerView;
//        mToolbar = mActivityMainBinding.toolbar;
        mNavigationView = mActivityMainBinding.navigationView;
//        mCardsContainerView = mActivityMainBinding.cardsContainer;


        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawer,
                mToolbar,
                R.string.open_drawer,
                R.string.close_drawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                hideKeyboard();
            }
        };
        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        setupNavMenu();
        String version = getString(R.string.version) + " " + BuildConfig.VERSION_NAME;
        mViewModel.updateAppVersion(version);
        mViewModel.onNavMenuCreated();

        NewsFeedFragment newsFeedFragment = new NewsFeedFragment();
        loadFragment(newsFeedFragment, NewsFeedFragment.TAG);

//        setupCardContainerView();
//        subscribeToLiveData();

    }

    @Override
    public void onClickNews() {
        bottomNavigationItemSelectionUnselectionHandling();
        mActivityMainBinding.news.setBackground(getResources().getDrawable(R.drawable.bottomnav_itemselected_bg));
        NewsFeedFragment newsFeedFragment = new NewsFeedFragment();
        loadFragment(newsFeedFragment, NewsFeedFragment.TAG);
    }

    @Override
    public void onClickEpapers() {
        bottomNavigationItemSelectionUnselectionHandling();
        mActivityMainBinding.ePapers.setBackground(getResources().getDrawable(R.drawable.bottomnav_itemselected_bg));
        EPaperFeedFragment ePaperFeedFragment = new EPaperFeedFragment();
        loadFragment(ePaperFeedFragment, EPaperFeedFragment.TAG);
    }
    @Override
    public void onClickSpeedNews() {
        bottomNavigationItemSelectionUnselectionHandling();
        mActivityMainBinding.speedNews.setBackground(getResources().getDrawable(R.drawable.bottomnav_itemselected_bg));

        private void bottomNavigationItemSelectionUnselectionHandling () {
            mActivityMainBinding.news.setBackground(null);
            mActivityMainBinding.ePapers.setBackground(null);
            mActivityMainBinding.livetv.setBackground(null);
            mActivityMainBinding.speedNews.setBackground(null);
        }


        private void setupCardContainerView () {
            int screenWidth = ScreenUtils.getScreenWidth(this);
            int screenHeight = ScreenUtils.getScreenHeight(this);

            mCardsContainerView.getBuilder()
                    .setDisplayViewCount(3)
                    .setHeightSwipeDistFactor(10)
                    .setWidthSwipeDistFactor(5)
                    .setSwipeDecor(new SwipeDecor()
                            .setViewWidth((int) (0.90 * screenWidth))
                            .setViewHeight((int) (0.75 * screenHeight))
                            .setPaddingTop(20)
                            .setSwipeRotationAngle(10)
                            .setRelativeScale(0.01f));

            mCardsContainerView.addItemRemoveListener(count -> {
                if (count == 0) {
                    // reload the contents again after 1 sec delay
                    new Handler(getMainLooper()).postDelayed(() -> {
                        //Reload once all the cards are removed
                        mViewModel.loadQuestionCards();
                    }, 800);
                } else {
                    mViewModel.removeQuestionCard();
                }
            });
        }

        private void setupNavMenu () {
            NavHeaderMainBinding navHeaderMainBinding = DataBindingUtil.inflate(getLayoutInflater(),
                    R.layout.nav_header_main, mActivityMainBinding.navigationView, false);
            mActivityMainBinding.navigationView.addHeaderView(navHeaderMainBinding.getRoot());
            navHeaderMainBinding.setViewModel(mViewModel);

            mNavigationView.getMenu().getItem(0).setActionView(R.layout.menu_image);
            mNavigationView.getMenu().getItem(1).setActionView(R.layout.menu_image);
            mNavigationView.getMenu().getItem(2).setActionView(R.layout.menu_image);
            mNavigationView.getMenu().getItem(3).setActionView(R.layout.menu_image);
            mNavigationView.getMenu().getItem(4).setActionView(R.layout.menu_image);
            mNavigationView.getMenu().getItem(5).setActionView(R.layout.menu_image);

//        mNavigationView.getMenu().setGroupVisible(R.id.MainEditGroup, false);


            mNavigationView.setNavigationItemSelectedListener(
                    item -> {
                        mDrawer.closeDrawer(GravityCompat.START);
                        switch (item.getItemId()) {
                            case R.id.main_edit:
//                            mNavigationView.getMenu().setGroupVisible(R.id.MainEditGroup, true);
                                return true;
                            case R.id.andhra:
                                return true;
                            case R.id.telengana:
                                return true;
                            case R.id.karnataka:
                                return true;
                            case R.id.tamil_nadu:
                                return true;
                            case R.id.magazines:
                                return true;
                            case R.id.about_us:
                                return true;
                            case R.id.contact_us:
                                return true;
                            case R.id.privacy_policy:
                                return true;
                            case R.id.terma_conditions:
                                return true;
                            default:
                                return false;
                        }
                    });
        }

        private void loadFragment (Fragment fragment, String TAG){
            lockDrawer();
            FrameLayout fl = (FrameLayout) findViewById(R.id.clRootView);
            fl.removeAllViews();
            getSupportFragmentManager()
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .add(R.id.clRootView, fragment, TAG)
                    .commit();
        }

        private void subscribeToLiveData () {
            mViewModel.getQuestionCardData().observe(this, questionCardDatas -> mViewModel.setQuestionDataList(questionCardDatas));
        }

        private void unlockDrawer () {
            if (mDrawer != null) {
                mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            }
        }
    }
