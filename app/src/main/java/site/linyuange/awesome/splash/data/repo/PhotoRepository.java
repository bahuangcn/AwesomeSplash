package site.linyuange.awesome.splash.data.repo;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import site.linyuange.awesome.splash.data.listener.GetDataCallback;
import site.linyuange.awesome.splash.data.model.PhotoEntity;
import site.linyuange.awesome.splash.data.network.PhotoApi;

public class PhotoRepository {

    private Map<String, Integer> mPhotoPageMap = new HashMap<>();

    private PhotoApi mPhotoApi;

    private static class InstanceHolder {
        private static final PhotoRepository INSTANCE = new PhotoRepository();
    }

    public static PhotoRepository getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private PhotoRepository() {
        mPhotoApi = PhotoApi.getInstance();
    }

    public void getPhotos(@PhotoApi.OrderType String orderType, GetDataCallback<List<PhotoEntity>, String> callback) {
        Integer page = mPhotoPageMap.get(orderType);
        if (page == null) {
            page = 0;
        }
        page += 1;
        mPhotoPageMap.put(orderType, page);
        mPhotoApi.loadPhotos(page, 10, orderType, callback);
    }

    public void getMorePhotos(GetDataCallback<List<PhotoEntity>, String> callback) {

    }
}
