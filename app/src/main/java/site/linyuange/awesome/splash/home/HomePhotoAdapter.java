package site.linyuange.awesome.splash.home;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import site.linyuange.awesome.splash.R;
import site.linyuange.awesome.splash.base.BaseDataBindingAdapter;
import site.linyuange.awesome.splash.base.DataBindingViewHolder;
import site.linyuange.awesome.splash.data.model.Footer;
import site.linyuange.awesome.splash.data.model.PhotoEntity;

public class HomePhotoAdapter extends BaseDataBindingAdapter implements HomePhotoViewHolder.OnItemClickListener {

    private static final int FOOTER_ITEM_COUNT = 1;
    // 20% transparency: 255 * 0.2 = 55
    private static final int PHOTO_SUMMARY_TRANSPARENCY = 55;

    private static final Footer LOADING_STATE = new Footer();
    private static final Footer COMPLETED_STATE = new Footer();
    private static final Footer ERROR_STATE = new Footer();

    static {
        LOADING_STATE.setMessage("Loading More");
        LOADING_STATE.setState(Footer.LOADING_STATE);
        COMPLETED_STATE.setMessage("Loading Completed");
        COMPLETED_STATE.setState(Footer.COMPLETED_STATE);
        ERROR_STATE.setMessage("Something Error");
        ERROR_STATE.setState(Footer.ERROR_STATE);
    }


    private OnListPerformListener mListener;

    @NonNull
    private List<PhotoEntity> mPhotos = new ArrayList<>();
    private Footer mFooter;
    private boolean mIsLoadMoreEnabled;
    private boolean mIsLoading;

    public HomePhotoAdapter(@NonNull OnListPerformListener listener) {
        mFooter = LOADING_STATE;
        mListener = listener;
    }

    public void setLoadMoreEnabled(boolean enabled) {
        mIsLoadMoreEnabled = enabled;
    }

    public void setPhotos(@NonNull List<PhotoEntity> photos) {
        mPhotos.clear();
        mPhotos.addAll(photos);
        notifyItemRangeChanged(0, mPhotos.size());
        notifyFooterItem(LOADING_STATE);
    }

    public void addMorePhotos(@NonNull List<PhotoEntity> photos) {
        int startIndex = mPhotos.size();
        mPhotos.addAll(startIndex, photos);
        notifyItemRangeInserted(startIndex, photos.size());
        mIsLoading = false;
        notifyFooterItem(LOADING_STATE);
    }

    public void loadFailed() {
        notifyFooterItem(ERROR_STATE);
        mIsLoading = false;
        mIsLoadMoreEnabled = false;
    }

    public void loadCompleted() {
        notifyFooterItem(COMPLETED_STATE);
    }

    private void notifyFooterItem(Footer newFooter) {
        mFooter = newFooter;
        notifyItemChanged(getItemCount() - 1);
    }

    @Override
    @NonNull
    public DataBindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, viewType, parent, false);
        return new HomePhotoViewHolder(binding, this);
    }

    @Override
    public void onBindViewHolder(@NonNull DataBindingViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (isLastItem(position)) {
            if (mIsLoadMoreEnabled && !mIsLoading && mListener != null) {
                loadMorePhotos();
            }
        }
    }

    private void loadMorePhotos() {
        mIsLoading = true;
        mListener.loadMore();
    }

    @Nullable
    @Override
    protected Object getItemByPosition(int position) {
        return position < mPhotos.size() ? mPhotos.get(position) : mFooter;
    }

    @Override
    protected int getLayoutResByPosition(int position) {
        return isLastItem(position) ? R.layout.item_loading_more : R.layout.item_home_photo;
    }

    @Override
    public int getItemCount() {
        int size = mPhotos.size();
        return size == 0 ? 0 : size + FOOTER_ITEM_COUNT;
    }

    public boolean isLastItem(int position) {
        return getItemCount() - FOOTER_ITEM_COUNT == position;
    }

    @Override
    public void onFooterClicked() {
        notifyFooterItem(LOADING_STATE);
        mIsLoadMoreEnabled = true;
        loadMorePhotos();
    }

    @Override
    public void onPhotoClicked() {
        if (mListener != null) {
            mListener.viewPhotoInfo();
        }
    }

    public interface OnListPerformListener {
        void loadMore();

        void viewPhotoInfo();
    }
}
