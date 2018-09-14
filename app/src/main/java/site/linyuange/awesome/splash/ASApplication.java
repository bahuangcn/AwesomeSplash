package site.linyuange.awesome.splash;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ProcessLifecycleOwner;
import android.os.Bundle;
import android.util.Log;

import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.segment.analytics.Analytics;
import com.segment.analytics.android.integrations.mixpanel.MixpanelIntegration;

import site.linyuange.awesome.splash.tracker.TrackerManager;

/**
 * Author: BaHuang
 * Date: 2018/8/14 16:15
 */
public class ASApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new LifecycleObserver() {

            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            void onForeground() {
                Log.d("BaHuang -- ", "onForeground 51: ");
                TrackerManager.instance().trackerEvent("onForeground");
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            void onBackground() {
                Log.d("BaHuang -- ", "onBackground 56: ");
                TrackerManager.instance().trackerEvent("onBackground");
            }
        });

        if (BuildConfig.DEBUG) {
            initOnDebugBuild();
        }

        // Create an analytics client with the given context and Segment write key.
        Analytics analytics = new Analytics.Builder(this, BuildConfig.SEGMENT_KEY)
                // Enable this to record certain application events automatically!
                .trackApplicationLifecycleEvents()
                // Enable this to record screen views automatically!
                .recordScreenViews()
                .use(MixpanelIntegration.FACTORY)
                .build();

        // Set the initialized instance as a globally accessible instance.
        Analytics.setSingletonInstance(analytics);

        TrackerManager.registerTrackerManger(Analytics.with(this));
    }

    private void initOnDebugBuild() {

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
