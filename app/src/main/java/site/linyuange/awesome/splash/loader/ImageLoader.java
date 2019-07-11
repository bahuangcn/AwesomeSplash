package site.linyuange.awesome.splash.loader;


import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.LogTime;

import java.util.HashSet;
import java.util.Set;

import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import site.linyuange.awesome.splash.data.model.PhotoEntity;

public class ImageLoader {

    private static final Set<String> URL_SET = new HashSet<>();

    public static void loadImage(RecyclerView parent, ImageView view, PhotoEntity item) {
        String url = item.getUrls().getSmall();
        String type = "small";
        URL_SET.add(url);
        GlideApp.with(parent)
                .load(url)
                .thumbnail(
                        GlideApp.with(parent)
                                .load(item.getUrls().getThumb())
                                .transform(new GrayscaleTransformation())
                )
//                .override(width, height)
                .transition(DrawableTransitionOptions.withCrossFade())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        if (dataSource != DataSource.REMOTE) {
                            URL_SET.remove(url);
                        }
                        return false;
                    }
                })
                .into(new DrawableImageViewTarget(view) {
                    private long startTime;

                    @Override
                    public void onLoadStarted(@Nullable Drawable placeholder) {
                        startTime = LogTime.getLogTime();
                        super.onLoadStarted(placeholder);
                    }

                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        if (!URL_SET.contains(url)) {
                            double costTime = LogTime.getElapsedMillis(startTime);
                        }
                        super.onResourceReady(resource, transition);
                    }
                });
    }

    private static GlideUrl getUrlWithHeaders(String url, String type) {
        return new GlideUrl(url, new LazyHeaders.Builder()
                .addHeader("type", type)
                .build());
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
