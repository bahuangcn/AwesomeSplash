package site.linyuange.awesome.splash.home;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import site.linyuange.awesome.splash.R;
import site.linyuange.awesome.splash.base.BaseDataBindingAdapter;
import site.linyuange.awesome.splash.data.model.PhotoEntity;

public class HomePhotoAdapter extends BaseDataBindingAdapter {

    @NonNull
    private List<PhotoEntity> mPhotos = new ArrayList<>();

    public void setPhotos(@NonNull List<PhotoEntity> photos) {
        mPhotos.clear();
        mPhotos.addAll(photos);
        notifyItemRangeChanged(0, mPhotos.size());
    }

    public void addMorePhotos(@NonNull List<PhotoEntity> photos) {
        int startIndex = mPhotos.size();
        mPhotos.addAll(startIndex, photos);
        notifyItemRangeInserted(startIndex, photos.size());
    }

    @Nullable
    @Override
    protected Object getItemByPosition(int position) {
        return mPhotos.get(position);
    }

    @Override
    protected int getLayoutResByPosition(int position) {
        return R.layout.item_home_photo;
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }
}
