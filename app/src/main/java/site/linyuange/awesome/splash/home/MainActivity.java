package site.linyuange.awesome.splash.home;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import site.linyuange.awesome.splash.R;
import site.linyuange.awesome.splash.base.AbsBaseActivity;
import site.linyuange.awesome.splash.data.model.PhotoEntity;
import site.linyuange.awesome.splash.databinding.ActivityMainBinding;
import site.linyuange.awesome.splash.vm.PhotoViewModel;

public class MainActivity extends AbsBaseActivity implements HomeContract.View,
        HomePhotoAdapter.OnListPerformListener {

    private static final int DISPLAY_PHOTOS_DURATION = 700;
    private static final int ADD_MORE_PHOTOS_DELAY = 700;

    private PhotoViewModel mPhotoModel;
    private Handler mHandler;

    private ActivityMainBinding mBinding;
    private HomePresenter mPresenter;
    private HomePhotoAdapter mAdapter;

    @Override
    protected void initContentView() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutRes());
    }

    @Override
    protected void initData() {
        initViewModel();
        mHandler = new Handler();
        mAdapter = new HomePhotoAdapter(this);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerView.setAdapter(mAdapter);
        mBinding.recyclerView.setAlpha(0);
        mPresenter = new HomePresenter(this);
        mPresenter.start();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void showPhotos(@NonNull List<PhotoEntity> photos) {
        mAdapter.setPhotos(photos);
        mBinding.recyclerView
                .animate()
                .alphaBy(0)
                .alpha(1)
                .setDuration(DISPLAY_PHOTOS_DURATION);
        mAdapter.setLoadMoreEnabled(true);
    }

    @Override
    public void showMorePhotos(@NonNull List<PhotoEntity> photos) {
        mAdapter.loadCompleted();
        mHandler.postDelayed(() -> mAdapter.addMorePhotos(photos), ADD_MORE_PHOTOS_DELAY);
    }

    @Override
    public void showLoadFailed(String msg) {
        mAdapter.loadFailed();
    }

    @Override
    public void loadMore() {
        mPresenter.loadMorePhotos();
    }

    @Override
    public void viewPhotoInfo() {
    }

    private void initViewModel() {
        mPhotoModel = ViewModelProviders.of(this).get(PhotoViewModel.class);
        mPhotoModel.getPhotoList().observe(this, photoList -> {

        });
    }
}
