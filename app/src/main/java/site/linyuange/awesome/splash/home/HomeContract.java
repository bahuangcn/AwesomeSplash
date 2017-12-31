package site.linyuange.awesome.splash.home;


import android.support.annotation.NonNull;

import java.util.List;

import site.linyuange.awesome.splash.base.BasePresenter;
import site.linyuange.awesome.splash.base.BaseView;
import site.linyuange.awesome.splash.data.model.PhotoEntity;

public interface HomeContract {
    interface View extends BaseView {
        void showPhotos(@NonNull List<PhotoEntity> photos);

        void showMorePhotos(@NonNull List<PhotoEntity> photos);
    }

    interface Presenter extends BasePresenter {
        void loadMorePhotos();
    }
}
