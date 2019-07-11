package site.linyuange.awesome.splash.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Author: BaHuang
 * Date: 2019/7/10 16:25
 */
public class DeviceManager {

    private static final int[] SIZE = new int[2];

    static {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        SIZE[0] = width;
        SIZE[1] = height;
    }

    public static int[] getSize() {
        return SIZE;
    }
}
