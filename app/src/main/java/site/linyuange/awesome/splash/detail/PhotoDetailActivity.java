package site.linyuange.awesome.splash.detail;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;

import site.linyuange.awesome.splash.R;
import site.linyuange.awesome.splash.base.AbsBaseActivity;
import site.linyuange.awesome.splash.data.model.PhotoEntity;
import site.linyuange.awesome.splash.databinding.ActivityPhotoDetailBinding;
import site.linyuange.awesome.splash.vm.PhotoViewModel;

/**
 * Author: BaHuang
 * Date: 2018/5/18 10:27
 */
public class PhotoDetailActivity extends AbsBaseActivity {

    public static final int CODE_REQUEST_START = 0xa001;
    private static final String KEY_POSITION = "key_position";
    private int mPosition;
    private ActivityPhotoDetailBinding mBinding;

    public static void startInstance(Activity activity, int position) {
        Intent intent = new Intent(activity, PhotoDetailActivity.class);
        intent.putExtra(KEY_POSITION, position);
        activity.startActivityForResult(intent, CODE_REQUEST_START);
    }

    @Override
    protected void initContentView() {
//        mBinding = DataBindingUtil.setContentView(this, getLayoutRes());
        mBinding = ActivityPhotoDetailBinding.inflate(getLayoutInflater());
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_photo_detail;
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        mPosition = intent.getIntExtra(KEY_POSITION, -1);
        if (mPosition < 0) {
            finish();
        }

        ViewModelProviders.of(this).get(PhotoViewModel.class).getPhoto().observe(this, new Observer<PhotoEntity>() {
            @Override
            public void onChanged(@Nullable PhotoEntity photo) {
                mBinding.setItem(photo);
            }
        });
    }
}
