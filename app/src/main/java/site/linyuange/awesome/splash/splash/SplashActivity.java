package site.linyuange.awesome.splash.splash;


import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.crashlytics.android.Crashlytics;
import com.tencent.bugly.crashreport.CrashReport;

import net.hockeyapp.android.CrashManager;

import io.fabric.sdk.android.Fabric;
import site.linyuange.awesome.splash.BuildConfig;
import site.linyuange.awesome.splash.base.AbsBaseActivity;
import site.linyuange.awesome.splash.home.MainActivity;

public class SplashActivity extends AbsBaseActivity {

    @Override
    protected void initData() {

        Context applicationContext = getApplicationContext();
        Fabric.with(applicationContext, new Crashlytics());
        CrashManager.register(applicationContext);
        CrashReport.initCrashReport(applicationContext, BuildConfig.BUGLY_APP_ID, false);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 2000);
    }

    @Override
    protected void initContentView() {

    }

    @Override
    protected int getLayoutRes() {
        return 0;
    }
}
