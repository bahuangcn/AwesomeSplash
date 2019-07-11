package site.linyuange.awesome.splash.loader;


import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import site.linyuange.awesome.splash.data.model.PhotoEntity;
import site.linyuange.awesome.splash.utils.DeviceManager;

public class ImageLoader {

    public static void loadImage(RecyclerView parent, ImageView view, PhotoEntity item) {
        GlideApp.with(parent)
                .load(item.getUrls().getSmall())
                .thumbnail(
                        GlideApp.with(parent)
                                .load(item.getUrls().getThumb())
                )
//                .override(width, height)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view);
    }

    @BindingAdapter("SimpleLoadImage")
    public static void loadImage(ImageView view, PhotoEntity item) {
        GlideApp.with(view)
                .load(item.getUrls().getSmall())
                .thumbnail(
                        GlideApp.with(view)
                                .load(item.getUrls().getThumb())
                )
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view);
    }
}
