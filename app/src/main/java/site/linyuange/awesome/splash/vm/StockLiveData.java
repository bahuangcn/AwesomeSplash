package site.linyuange.awesome.splash.vm;

import android.arch.lifecycle.LiveData;

import java.math.BigDecimal;

/**
 * Author: BaHuang
 * Date: 2018/8/15 9:51
 */
public class StockLiveData extends LiveData<BigDecimal> {

    private SimplePriceListener mListener = price -> {

    };

    @Override
    protected void onActive() {
        super.onActive();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }

    public interface SimplePriceListener {
        void onPriceChanged(BigDecimal price);
    }
}
