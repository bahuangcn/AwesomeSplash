package site.linyuange.awesome.splash.data.listener;


public interface GetDataCallback<T, R> {
    void onDataLoaded(T t);

    default void onDataNotAvailable(R r) {}
}
