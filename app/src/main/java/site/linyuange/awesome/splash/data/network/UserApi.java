package site.linyuange.awesome.splash.data.network;


import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import site.linyuange.awesome.splash.BuildConfig;
import site.linyuange.awesome.splash.data.listener.GetDataCallback;
import site.linyuange.awesome.splash.data.listener.RetrofitCallback;
import site.linyuange.awesome.splash.data.model.UserEntity;

public class UserApi extends BaseRetrofitApi<UserApi.Service> {

    private static class InstanceHolder {
        private final static UserApi INSTANCE = new UserApi();
    }

    public static UserApi getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private UserApi() {
        super();
    }


    @Override
    protected String getHost() {
        return BuildConfig.API_UNSPLASH_COM;
    }

    @Override
    protected Class<Service> getServiceClass() {
        return Service.class;
    }

    public void getPhotographer(String username, GetDataCallback<UserEntity, String> callback) {
        getPhotographer(username, 0, 0, callback);
    }

    public void getPhotographer(String username, int width, int height, GetDataCallback<UserEntity, String> callback) {
        getService().getPhotographer(username, width, height).enqueue(new RetrofitCallback<String>() {
            @Override
            public void onSuccess(Response<String> response) {
                UserEntity user = new Gson().fromJson(response.body(), UserEntity.class);
                callback.onDataLoaded(user);
            }

            @Override
            public void onFailure(String message) {
                callback.onDataNotAvailable(message);
            }
        });
    }

    interface Service {

        @GET("/users/{username}")
        Call<String> getPhotographer(@Path("username") String username,
                                     @Query("w") int width,
                                     @Query("h") int height);
    }
}
