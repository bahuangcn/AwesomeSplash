package site.linyuange.awesome.splash.home;


import android.support.annotation.Nullable;

import site.linyuange.awesome.splash.R;
import site.linyuange.awesome.splash.base.BaseDataBindingAdapter;

public class HomePhotoAdapter extends BaseDataBindingAdapter {

    @Nullable
    @Override
    protected Object getItemByPosition(int position) {
        return null;
    }

    @Override
    protected int getLayoutResByPosition(int position) {
        return R.layout.item_home_photo;
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
