package site.linyuange.awesome.splash.loader;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import site.linyuange.awesome.splash.data.model.PhotoEntity;
import site.linyuange.awesome.splash.utils.DeviceManager;

/**
 * Author: BaHuang
 * Date: 2019/7/9 16:54
 */
public class Preload {

    public static final List<PhotoEntity> PHOTO_LIST = new ArrayList<>();

    public static class SizeProvider implements ListPreloader.PreloadSizeProvider<PhotoEntity> {

        @Nullable
        @Override
        public int[] getPreloadSize(@NonNull PhotoEntity item, int adapterPosition, int perItemPosition) {

            int[] size = DeviceManager.getSize();
            int width = size[0];
            int height = (int) (width * 1F / item.getWidth() * item.getHeight());

            return new int[]{width, height};
        }
    }

    public static class ModelProvider implements ListPreloader.PreloadModelProvider<PhotoEntity> {

        private RecyclerView mViewHolder;
        private PreloadListener mPreloadListener;

        public interface PreloadListener {
            void onAllItemPreloaded();
        }

        public ModelProvider(RecyclerView view) {
            mViewHolder = view;
        }

        public ModelProvider(RecyclerView viewHolder, PreloadListener listener) {
            mViewHolder = viewHolder;
            mPreloadListener = listener;
        }

        @NonNull
        @Override
        public List<PhotoEntity> getPreloadItems(int position) {
            if (position >= PHOTO_LIST.size()) {
                if (mPreloadListener != null) {
                    mPreloadListener.onAllItemPreloaded();
                }
                return Collections.emptyList();
            }

            PhotoEntity item = PHOTO_LIST.get(position);
            if (item == null) {
                return Collections.emptyList();
            }
            return Collections.singletonList(item);
        }

        @Nullable
        @Override
        public RequestBuilder<?> getPreloadRequestBuilder(@NonNull PhotoEntity item) {
            return GlideApp.with(mViewHolder)
                    .load(item.getUrls().getSmall())
//                    .override(width, height)
                    ;
        }
    }
}
