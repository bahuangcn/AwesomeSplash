package site.linyuange.awesome.splash.base;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class BaseDataBindingAdapter extends RecyclerView.Adapter<DataBindingViewHolder> {

    @Override
    public int getItemViewType(int position) {
        return getLayoutResByPosition(position);
    }

    @Override
    public DataBindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, viewType, parent, false);
        return new DataBindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(DataBindingViewHolder holder, int position) {
        holder.bind(getItemByPosition(position));
    }

    @Nullable
    protected abstract Object getItemByPosition(int position);

    @LayoutRes
    protected abstract int getLayoutResByPosition(int position);
}
