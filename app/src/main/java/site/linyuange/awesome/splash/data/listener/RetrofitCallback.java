package site.linyuange.awesome.splash.data.listener;


import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public interface RetrofitCallback<T> extends Callback<T> {
    String MSG_FORMAT = "RetrofitCallback.onResponse() -- response code is:%1$s, response message is:%2$s";

    void onSuccess(Response<T> response);

    @Override
    default void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(response);
        } else {
            int code = response.code();
            String message = response.message();
            System.out.println(String.format(MSG_FORMAT, code, message));
            onFailure(message);
        }
    }

    @Override
    default void onFailure(Call<T> call, Throwable throwable) {
        System.out.println("RetrofitCallback.onFailure() -- an unexpected exception occurred.");
        onFailure(throwable.getMessage());
    }

    default void onFailure(String message) {}
}
