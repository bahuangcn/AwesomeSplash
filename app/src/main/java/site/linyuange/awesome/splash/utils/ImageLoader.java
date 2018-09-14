package site.linyuange.awesome.splash.utils;


import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import site.linyuange.awesome.splash.data.model.PhotoEntity;

public class ImageLoader {

    @BindingAdapter("SimpleLoadImage")
    public static void loadImage(ImageView view, PhotoEntity entity) {

        String url = entity.getUrls().getSmall();
        Glide.with(view)
                .load(Uri.parse(url))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view);
//        Glide.with(view)
//                .asBitmap()
//                .load(Uri.parse(url))
//                .transition(BitmapTransitionOptions.withCrossFade())
//                .into(view);
//
//        Glide.with(view)
//                .load(url)
//                .thumbnail(0.1f )
//                .into(view);
    }
}
