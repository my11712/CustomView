package com.example.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by 奇志 on 2018/9/11.
 * <p>
 * <p>
 * https://blog.csdn.net/xmxkf/article/details/54020386
 */

public class CalendarView extends View {
    private String Tag = "CalendarView";
    private int year, month, day;
    /**
     * 控件宽度
     */
    private int widthSize;
    /**
     * 标题文字大小
     */
    private int titleSize;
    /**
     * 每一栏的宽度
     */
    private int columnWidth;
    private int titleHeight = 80;
    private int weekHeight = 100;
    private int lineNum = 90;
    private int oneHeight = 150;
    private Paint paint = new Paint();
    private Paint paintTitle = new Paint();

    public CalendarView(Context context) {
        super(context);
        Log.e(Tag, "构造器");
    }

    public CalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.e(Tag, "构造器0");
        initCustomAttrs(context, attrs);
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    //初始化自定义属性
    private void initCustomAttrs(Context context, AttributeSet attrs) {
        //获取自定义属性。
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CalendarView);
        year = ta.getInteger(R.styleable.CalendarView_year, 0);
        month = ta.getInteger(R.styleable.CalendarView_month, 0);
        day = ta.getInteger(R.styleable.CalendarView_day, 0);
        titleSize = ta.getDimensionPixelSize(R.styleable.CalendarView_titleSize, 14);
        Log.e("日期：", "年：" + year + " 月：" + month + " 日：" + day);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        widthSize = MeasureSpec.getSize(widthMeasureSpec);//获取宽的尺寸
        columnWidth = widthSize / 7;//一周7天
        //高度 = 标题高度 + 星期高度 + 日期行数*每行高度
        float height = titleHeight + weekHeight + (lineNum * oneHeight);
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec), (int) height);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(300, 300, 60, paint);
        drawTitle(canvas);
    }

    /**
     * 画标题年月日
     *
     * @param canvas
     */
    private void drawTitle(Canvas canvas) {
        String title = year + " 年 " + month + " 月 " + day + " 日";
        paintTitle.setTextSize(titleSize);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.left);
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        Rect rect = new Rect();
        paintTitle.getTextBounds(title, 0, title.length(), rect);
        int textWidth = rect.width();
        int textHeight = rect.height();
        int start = (widthSize - textWidth) / 2;
        Log.e(Tag, "drawTitle,widthSize:" + widthSize + "，文字宽：" + textWidth + ",x:" + start + " 高" + textHeight);

        int bitmapStart = (start - bitmapWidth) / 2;

        canvas.drawBitmap(bitmap, bitmapStart + 10, 5, paintTitle);
        canvas.drawText(title, start, bitmapHeight, paintTitle);
    }
}
