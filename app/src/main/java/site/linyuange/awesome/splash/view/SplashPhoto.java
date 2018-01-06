package site.linyuange.awesome.splash.view;


import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Size;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import site.linyuange.awesome.splash.R;

public class SplashPhoto extends AppCompatImageView {

    private static final int GUIDE_WIDTH = 0;
    private static final int GUIDE_HEIGHT = 1;
    private static final float DEFAULT_SRC_SIZE = 0F;

    private int mGuideSide;
    private float mSrcWidth;
    private float mSrcHeight;

    public SplashPhoto(Context context) {
        this(context, null);
    }

    public SplashPhoto(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SplashPhoto(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SplashPhoto, defStyleAttr, 0);
        mGuideSide = typedArray.getInt(R.styleable.SplashPhoto_guideSide, GUIDE_WIDTH);
        mSrcWidth = typedArray.getFloat(R.styleable.SplashPhoto_srcWidth, DEFAULT_SRC_SIZE);
        mSrcHeight = typedArray.getFloat(R.styleable.SplashPhoto_srcHeight, DEFAULT_SRC_SIZE);
        typedArray.recycle();
    }

    public void setSrcHeight(float srcHeight) {
        mSrcHeight = srcHeight;
        checkToRequestLayout();
    }

    public void setSrcWidth(float srcWidth) {
        mSrcWidth = srcWidth;
        checkToRequestLayout();
    }

    private void checkToRequestLayout() {
        if (mSrcHeight > DEFAULT_SRC_SIZE && mSrcWidth > DEFAULT_SRC_SIZE) {
            requestLayout();
        }
    }

    @Size(2)
    public float[] getSrcSize() {
        return new float[]{mSrcWidth, mSrcHeight};
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (mSrcHeight > DEFAULT_SRC_SIZE && mSrcWidth > DEFAULT_SRC_SIZE) {
            int width;
            int height;
            float ratio;
            if (mGuideSide == GUIDE_WIDTH) {
                width = MeasureSpec.getSize(widthMeasureSpec);
                ratio = mSrcWidth / width;
                height = (int) (mSrcHeight / ratio + 0.5);
            } else {
                height = MeasureSpec.getSize(heightMeasureSpec);
                ratio = mSrcHeight / height;
                width = (int) (mSrcWidth / ratio + 0.5);
            }

            setMeasuredDimension(resolveSizeAndState(width, widthMeasureSpec, 0),
                    resolveSizeAndState(height, heightMeasureSpec, 0));

        }
    }
}
