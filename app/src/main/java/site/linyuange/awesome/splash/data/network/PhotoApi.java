package site.linyuange.awesome.splash.data.network;


import android.support.annotation.IntRange;
import android.support.annotation.StringDef;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import site.linyuange.awesome.splash.BuildConfig;
import site.linyuange.awesome.splash.data.listener.GetDataCallback;
import site.linyuange.awesome.splash.data.model.PhotoEntity;

public class PhotoApi extends BaseRetrofitApi<PhotoApi.PhotoService> {

    private static final Type PHOTO_LIST_TYPE = new TypeToken<List<PhotoEntity>>() {}.getType();

    public static final String ORDER_LATEST = "latest";
    public static final String ORDER_OLDEST = "oldest";
    public static final String ORDER_POPULAR = "popular";

    @StringDef({
            ORDER_LATEST,
            ORDER_OLDEST,
            ORDER_POPULAR
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface OrderType {}

    private static class InstanceHolder {
        private final static PhotoApi INSTANCE = new PhotoApi();
    }

    public static PhotoApi getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private PhotoApi() {
        super();
    }

    @Override
    protected String getHost() {
        return BuildConfig.API_UNSPLASH_COM;
    }

    @Override
    protected Class<PhotoService> getServiceClass() {
        return PhotoService.class;
    }

    public void loadPhotos(@IntRange(from = 1) int page, @IntRange(from = 1) int perPage, String order, GetDataCallback<List<PhotoEntity>, String> callback) {
        getService().getPhotos(page, perPage, order).enqueue(new ApiCallback<List<PhotoEntity>>(callback) {
            @Override
            public void onSuccess(Response<String> response) {
                List<PhotoEntity> list = new Gson().fromJson(response.body(), PHOTO_LIST_TYPE);
                callback.onDataLoaded(list);
            }
        });
    }

    public void loadCuratedPhotos(@IntRange(from = 1) int page, @IntRange(from = 1) int perPage, String order, GetDataCallback<List<PhotoEntity>, String> callback) {
        getService().getCuratedPhotos(page, perPage, order).enqueue(new ApiCallback<List<PhotoEntity>>(callback) {
            @Override
            public void onSuccess(Response<String> response) {
                List<PhotoEntity> list = new Gson().fromJson(response.body(), PHOTO_LIST_TYPE);
                callback.onDataLoaded(list);
            }
        });
    }

    public void loadPhotoDetail(String id, GetDataCallback<PhotoEntity, String> callback) {
        loadPhotoDetail(id, 0, 0, null, callback);
    }

    public void loadPhotoDetail(String id, int height, int width, String rect, GetDataCallback<PhotoEntity, String> callback) {
        getService().getPhotoDetail(id, height, width, rect).enqueue(new ApiCallback<PhotoEntity>(callback) {
            @Override
            public void onSuccess(Response<String> response) {
                PhotoEntity photo = new Gson().fromJson(response.body(), PhotoEntity.class);
                callback.onDataLoaded(photo);
            }
        });
    }


    interface PhotoService {

        @GET("photos/")
        Call<String> getPhotos(@Query("page") int page, @Query("per_page") int perPage, @Query("order_by") String orderType);

        @GET("photos/curated/")
        Call<String> getCuratedPhotos(@Query("page") int page, @Query("per_page") int perPage, @Query("order_by") String orderType);

        // 4 comma-separated integers representing x, y, width, height of the cropped rectangle.
        @GET("photos/{id}")
        Call<String> getPhotoDetail(@Path("id") String id, @Query("h") int height, @Query("w") int width, @Query("rect") String rect);
    }
}
