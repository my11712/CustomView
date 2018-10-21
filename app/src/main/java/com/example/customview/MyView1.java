package com.example.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by 奇志 on 2018/10/20.
 */

public class MyView1 extends LinearLayout {
    public MyView1(Context context) {
        super(context);
    }

    public MyView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("dispatchKeyEvent111", "down1");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("dispatchKeyEvent1111", "move1");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("dispatchKeyEvent111", "up1");
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("onTouchEvent111", "down1");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("onTouchEvent111", "move1");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("onTouchEvent111", "up1");
                break;
        }
        return false;
    }
}
