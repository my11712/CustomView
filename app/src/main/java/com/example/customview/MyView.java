package com.example.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by 奇志 on 2018/10/20.
 */

public class MyView extends LinearLayout {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("dispatchKeyEvent", "down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("dispatchKeyEvent", "move");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("dispatchKeyEvent", "up");
                break;
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("onTouchEvent", "down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("onTouchEvent", "move");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("onTouchEvent", "up");
                break;
        }
        return super.onTouchEvent(event);
    }
}
