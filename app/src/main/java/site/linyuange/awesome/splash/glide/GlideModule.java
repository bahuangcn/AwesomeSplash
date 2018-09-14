package site.linyuange.awesome.splash.glide;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Author: BaHuang
 * Date: 2018/9/4 20:11
 */
//@com.bumptech.glide.annotation.GlideModule
public class GlideModule extends AppGlideModule {

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {

        // Glide default Bitmap Format is set to RGB_565 since it
        // consumed just 50% memory footprint compared to ARGB_8888.
        // Increase memory usage for quality with:
//        RequestOptions requestOptions = new RequestOptions()
//                .format(DecodeFormat.PREFER_ARGB_8888);
//        builder.setDefaultRequestOptions(requestOptions);
    }
}
