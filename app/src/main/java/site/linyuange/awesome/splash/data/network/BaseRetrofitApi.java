package site.linyuange.awesome.splash.data.network;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import site.linyuange.awesome.splash.BuildConfig;

public abstract class BaseRetrofitApi<T> {

    private static final String HTTP_SCHEME = "http";
    private static final String HTTPS_SCHEME = "https";
    private static final String URL_FORMAT = "%1$s://%2$s/";

    private static Retrofit.Builder sRetrofitBuilder = new Retrofit.Builder();
    private static OkHttpClient sOkHttpClient = getOkHttpClient();

    private Retrofit mRetrofit;
    private T mService;

    public BaseRetrofitApi() {
        mRetrofit = handleRetrofitBuilder(sRetrofitBuilder)
                .client(handleOkHttpClient(sOkHttpClient))
                .baseUrl(getBaseUrl())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        generateService();
    }

    private static OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(chain -> {
                    Request.Builder requestBuilder = chain.request().newBuilder();

                    requestBuilder.header("Accept-Version", "v1");
                    requestBuilder.header("Authorization", "Client-ID " + BuildConfig.APPLICATION_ID);

                    return chain.proceed(requestBuilder.build());
                })
                .build();
    }

    protected void generateService() {
        mService = mRetrofit.create(getServiceClass());
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public T getService() {
        return mService;
    }

    private T createService(Class<T> service) {
        return mRetrofit.create(service);
    }

    protected Retrofit.Builder handleRetrofitBuilder(Retrofit.Builder builder) {
        return builder;
    }

    // overwrite this method if you need to update OkHttpClient
    protected OkHttpClient handleOkHttpClient(OkHttpClient client) {
        //sOkHttpClient.newBuilder().build();
        return client;
    }

    private String getBaseUrl() {
        return String.format(URL_FORMAT, getScheme(), getHost());
    }

    protected String getScheme() {
        return getHttpsScheme();
    }

    protected final String getHttpScheme() {
        return HTTP_SCHEME;
    }

    protected final String getHttpsScheme() {
        return HTTPS_SCHEME;
    }

    protected abstract String getHost();

    protected abstract Class<T> getServiceClass();
}
