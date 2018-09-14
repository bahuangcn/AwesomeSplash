package site.linyuange.awesome.splash.utils;

import android.util.Log;

import site.linyuange.awesome.splash.BuildConfig;

/**
 * Author: BaHuang
 * Date: 2018/9/10 14:56
 */
public class DebugLog {

    public static void v(String message) {
        if (BuildConfig.DEBUG) {
            Log.v("DebugLog -- ", message);
        }
    }

    public static void d(String message) {
        if (BuildConfig.DEBUG) {
            Log.d("DebugLog -- ", message);
        }
    }

    public static void i(String message) {
        if (BuildConfig.DEBUG) {
            Log.i("DebugLog -- ", message);
        }
    }

    public static void w(String message) {
        if (BuildConfig.DEBUG) {
            Log.w("DebugLog -- ", message);
        }
    }

    public static void e(String message) {
        if (BuildConfig.DEBUG) {
            Log.e("DebugLog -- ", message);
        }
    }
}
