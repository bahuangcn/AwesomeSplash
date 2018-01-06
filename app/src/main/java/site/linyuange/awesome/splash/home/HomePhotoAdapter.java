package site.linyuange.awesome.splash.home;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import site.linyuange.awesome.splash.R;
import site.linyuange.awesome.splash.base.BaseDataBindingAdapter;
import site.linyuange.awesome.splash.base.DataBindingViewHolder;
import site.linyuange.awesome.splash.data.model.PhotoEntity;
import site.linyuange.awesome.splash.databinding.ItemHomePhotoBinding;
import site.linyuange.awesome.splash.utils.ImageLoader;

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
    public void onBindViewHolder(DataBindingViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        // DO NOT use data binding to set src size and download photo.
        ItemHomePhotoBinding binding = (ItemHomePhotoBinding) holder.getBinding();
        PhotoEntity item = (PhotoEntity) getItemByPosition(position);
        if (item == null) return;
        binding.splashPhoto.setSrcHeight(item.getHeight());
        binding.splashPhoto.setSrcWidth(item.getWidth());
        ImageLoader.loadImage(binding.splashPhoto, item.getUrls().getRegular());
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
