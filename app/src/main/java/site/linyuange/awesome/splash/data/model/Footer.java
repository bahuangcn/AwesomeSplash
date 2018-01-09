package site.linyuange.awesome.splash.data.model;


import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Footer {

    public static final int LOADING_STATE = 0;
    public static final int COMPLETED_STATE = 1;
    public static final int ERROR_STATE = 2;

    @IntDef({
            LOADING_STATE,
            COMPLETED_STATE,
            ERROR_STATE
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface FooterState {}

    @FooterState
    private int mState;
    private String mMessage;


    @FooterState
    public int getState() {
        return mState;
    }

    public void setState(@FooterState int state) {
        mState = state;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }
}
