package site.linyuange.awesome.splash.loader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;

import site.linyuange.awesome.splash.BuildConfig;

/**
 * Author: BaHuang
 * Date: 2019/6/25 18:14
 */

@GlideModule
public final class SplashGlideModule extends AppGlideModule {

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        super.applyOptions(context, builder);
        builder.setDefaultRequestOptions(
                new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.DATA));
        if (BuildConfig.DEBUG) {
            builder.setLogLevel(Log.VERBOSE);
        }
    }
}
