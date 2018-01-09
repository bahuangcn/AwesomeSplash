package site.linyuange.awesome.splash;


import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.tencent.bugly.crashreport.CrashReport;

import io.fabric.sdk.android.Fabric;
import net.hockeyapp.android.CrashManager;

public class AwesomeSplashApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        CrashManager.register(this);
        CrashReport.initCrashReport(getApplicationContext(), BuildConfig.BUGLY_APP_ID, false);
    }
}
