package site.linyuange.awesome.splash.home;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import com.android.databinding.library.baseAdapters.BR;

import site.linyuange.awesome.splash.base.DataBindingViewHolder;


public class FooterViewHolder extends DataBindingViewHolder {

    @NonNull
    private OnFooterClickListener mListener;

    public FooterViewHolder(ViewDataBinding binding, @NonNull OnFooterClickListener listener) {
        super(binding);
        mListener = listener;
    }

    @Override
    public void bind(@NonNull Object obj) {
        super.bind(obj);
        getBinding().setVariable(BR.listener, mListener);
    }

    public interface OnFooterClickListener {
        void onFooterClicked();
    }
}
