package site.linyuange.awesome.splash.vm;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import site.linyuange.awesome.splash.data.model.PhotoEntity;

/**
 * Author: BaHuang
 * Date: 2018/8/14 20:33
 */
public class PhotoViewModel extends ViewModel {

    private MutableLiveData<List<PhotoEntity>> mPhotoList = new MutableLiveData<>();
    private MutableLiveData<String> mPhotoId = new MutableLiveData<>();
    private LiveData<PhotoEntity> mCurrentPhoto =
            Transformations.switchMap(mPhotoId, new Function<String, LiveData<PhotoEntity>>() {
                @Override
                public LiveData<PhotoEntity> apply(String id) {
                    return null;
                }
            });

    public MutableLiveData<List<PhotoEntity>> getPhotoList() {
        return mPhotoList;
    }

    public void setPhotoId(String photoId){
        mPhotoId.setValue(photoId);
    }

    public LiveData<PhotoEntity> getPhoto() {
        return mCurrentPhoto;
    }
}
