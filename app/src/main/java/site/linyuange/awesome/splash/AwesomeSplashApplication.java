package site.linyuange.awesome.splash;


import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

import net.hockeyapp.android.CrashManager;

public class AwesomeSplashApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashManager.register(this);
        CrashReport.initCrashReport(getApplicationContext(), BuildConfig.BUGLY_APP_ID, false);
    }
}
