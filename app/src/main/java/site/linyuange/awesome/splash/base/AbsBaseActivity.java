package site.linyuange.awesome.splash.base;


import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class AbsBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preSetContentView();
        initContentView();
        handleSavedInstanceState(savedInstanceState);
        initData();
    }

    @LayoutRes
    protected abstract int getLayoutRes();

    protected void preSetContentView() {}

    protected void initContentView() {
        setContentView(getLayoutRes());
    }

    protected void handleSavedInstanceState(Bundle savedInstanceState) {}

    protected void initData() {}

    @Override
    protected void onResume() {
        super.onResume();
        onSplashResume();
    }

    protected void onSplashResume(){

    }
}
