package site.linyuange.awesome.splash.data.network;


import android.support.annotation.IntRange;
import android.support.annotation.StringDef;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
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
        getService().getPhotos(page, perPage, order).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    List<PhotoEntity> list = new GsonBuilder().create().fromJson(response.body(), PHOTO_LIST_TYPE);
                    callback.onDataLoaded(list);
                } else {
                    String msg = "response code is " + response.code() + response.message();
                    callback.onDataNotAvailable(msg);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {
                callback.onDataNotAvailable(throwable.getMessage());
            }
        });
    }

    interface PhotoService {

        @GET("photos/")
        Call<String> getPhotos(@Query("page") int page, @Query("per_page") int perPage, @Query("order_by") String orderType);
    }
}
