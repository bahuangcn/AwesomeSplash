package site.linyuange.awesome.splash.home;


import java.util.List;

import site.linyuange.awesome.splash.data.listener.GetDataCallback;
import site.linyuange.awesome.splash.data.model.PhotoEntity;
import site.linyuange.awesome.splash.data.network.PhotoApi;
import site.linyuange.awesome.splash.data.repo.PhotoRepository;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;
    private PhotoRepository mPhotoRepository;
    private int count = 0;

    private final GetDataCallback<List<PhotoEntity>, String> loadMoreCallback =
            new GetDataCallback<List<PhotoEntity>, String>() {
                @Override
                public void onDataLoaded(List<PhotoEntity> photos) {
                    mView.showMorePhotos(photos);

                }

                @Override
                public void onDataNotAvailable(String msg) {
                    mView.showLoadFailed(msg);
                }
            };

    public HomePresenter(HomeContract.View view) {
        mView = view;
        mPhotoRepository = PhotoRepository.getInstance();
    }

    @Override
    public void start() {
        mPhotoRepository.getPhotos(PhotoApi.ORDER_LATEST,
                photos -> mView.showPhotos(photos)
        );
    }

    @Override
    public void loadMorePhotos() {
        mPhotoRepository.getPhotos(PhotoApi.ORDER_LATEST, loadMoreCallback);
    }
}
