package site.linyuange.awesome.splash.splash;


import android.app.Application;
import android.content.Intent;
import android.os.Handler;

import com.crashlytics.android.Crashlytics;
import com.facebook.stetho.Stetho;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatCrashReporter;
import com.tencent.stat.StatService;

import io.fabric.sdk.android.Fabric;
import site.linyuange.awesome.splash.BuildConfig;
import site.linyuange.awesome.splash.base.AbsBaseActivity;
import site.linyuange.awesome.splash.home.MainActivity;

public class SplashActivity extends AbsBaseActivity {

    @Override
    protected void initData() {

        Application application = getApplication();
        Fabric.with(application, new Crashlytics());
        CrashReport.initCrashReport(application, BuildConfig.BUGLY_APP_ID, false);
        Stetho.initializeWithDefaults(application);

        // configure mta
        StatConfig.setDebugEnable(BuildConfig.DEBUG);
        StatService.registerActivityLifecycleCallbacks(application);
        StatCrashReporter.getStatCrashReporter(application).setJavaCrashHandlerStatus(true);

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
