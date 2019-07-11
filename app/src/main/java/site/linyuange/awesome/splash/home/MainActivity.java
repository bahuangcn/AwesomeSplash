package site.linyuange.awesome.splash.home;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;

import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader;

import java.util.List;

import site.linyuange.awesome.splash.R;
import site.linyuange.awesome.splash.base.AbsBaseActivity;
import site.linyuange.awesome.splash.data.model.PhotoEntity;
import site.linyuange.awesome.splash.databinding.ActivityMainBinding;
import site.linyuange.awesome.splash.loader.GlideApp;
import site.linyuange.awesome.splash.loader.Preload;

public class MainActivity extends AbsBaseActivity implements HomeContract.View,
        HomePhotoAdapter.OnListPerformListener {

    private ActivityMainBinding mBinding;
    private HomePresenter mPresenter;
    private HomePhotoAdapter mAdapter;

    @Override
    protected void initContentView() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutRes());
    }

    @Override
    protected void initData() {
        Preload.ModelProvider modelProvider = new Preload.ModelProvider(mBinding.recyclerView, new Preload.ModelProvider.PreloadListener() {
            @Override
            public void onAllItemPreloaded() {
//                mPresenter.loadMorePhotos();
            }
        });
        RecyclerViewPreloader<PhotoEntity> preloader = new RecyclerViewPreloader<>(
                GlideApp.with(mBinding.recyclerView),
                modelProvider,
                new Preload.SizeProvider(),
                5);

        mAdapter = new HomePhotoAdapter(this);
        mBinding.recyclerView.addOnScrollListener(preloader);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerView.setAdapter(mAdapter);
        mPresenter = new HomePresenter(this);
        mPresenter.start();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void showPhotos(@NonNull List<PhotoEntity> photos) {
        Preload.PHOTO_LIST.addAll(photos);
        mAdapter.setPhotos(photos);
        mAdapter.setLoadMoreEnabled(true);
    }

    @Override
    public void showMorePhotos(@NonNull List<PhotoEntity> photos) {
        Preload.PHOTO_LIST.addAll(photos);
        mAdapter.loadCompleted();
        mAdapter.addMorePhotos(photos);
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
}
