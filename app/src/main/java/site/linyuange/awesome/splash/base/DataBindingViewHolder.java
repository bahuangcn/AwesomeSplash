package site.linyuange.awesome.splash.base;


import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.android.databinding.library.baseAdapters.BR;

public class DataBindingViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding mBinding;

    public DataBindingViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind() {
        mBinding.setVariable(BR.position, getAdapterPosition());
    }
}
