package site.linyuange.awesome.splash.home;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import site.linyuange.awesome.splash.R;
import site.linyuange.awesome.splash.base.AbsBaseActivity;
import site.linyuange.awesome.splash.data.model.PhotoEntity;
import site.linyuange.awesome.splash.databinding.ActivityMainBinding;

public class MainActivity extends AbsBaseActivity implements HomeContract.View {

    private ActivityMainBinding mBinding;
    private HomePresenter mPresenter;
    private HomePhotoAdapter mAdapter;

    @Override
    protected void initContentView() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutRes());
    }

    @Override
    protected void initData() {
        mAdapter = new HomePhotoAdapter();
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
        mAdapter.setPhotos(photos);
    }

    @Override
    public void showMorePhotos(@NonNull List<PhotoEntity> photos) {
        mAdapter.addMorePhotos(photos);
    }
}
