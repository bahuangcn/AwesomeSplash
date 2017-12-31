package site.linyuange.awesome.splash.utils;


import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageLoader {

    @BindingAdapter("SimpleLoadImage")
    public static void loadImage(ImageView view, String url) {
        Glide.with(view).load(Uri.parse(url)).into(view);
    }
}
