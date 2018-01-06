package site.linyuange.awesome.splash.home;


import site.linyuange.awesome.splash.data.network.PhotoApi;
import site.linyuange.awesome.splash.data.repo.PhotoRepository;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;
    private PhotoRepository mPhotoRepository;

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
        mPhotoRepository.getPhotos(PhotoApi.ORDER_LATEST,
                photos -> mView.showMorePhotos(photos));
    }
}
