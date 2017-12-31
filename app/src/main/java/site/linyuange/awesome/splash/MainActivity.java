package site.linyuange.awesome.splash;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;

import site.linyuange.awesome.splash.base.AbsBaseActivity;
import site.linyuange.awesome.splash.databinding.ActivityMainBinding;

public class MainActivity extends AbsBaseActivity {
    private ActivityMainBinding mBinding;

    @Override
    protected void initContentView() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutRes());
    }

    @Override
    protected void initData() {
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerView.setAdapter(new HomePhotoAdapter());
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }
}
