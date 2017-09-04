package com.example.user.cw1.dz4;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.example.user.cw1.R;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ya on 01.08.2017.
 */

public class Dz4View extends View {

    private Date date = new Date();
    private Calendar calendar = Calendar.getInstance();
    private Paint myPaint = new Paint();
    private float strokeWidthInPx;
    // TextView  TextView=(TextView) findViewById(R.id.dz4TextView);

    //для рамки
    private RectF arcRectF = new RectF();
    private int cx;
    private int cy;

    public Dz4View(Context context) {
        super(context);
        initialize();
    }

    public Dz4View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public Dz4View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Dz4View(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize();
    }


    private void initialize() {

        myPaint.setAntiAlias(true);
        int color = ContextCompat.getColor(getContext(), R.color.colorAccent);
        myPaint.setColor(color);
        myPaint.setStyle(Paint.Style.STROKE);

//ширина окантовки строке
        Resources r = getResources();

        // float strokeWidthInPx = TypedValue.
        strokeWidthInPx = TypedValue.
                applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                        2, r.getDisplayMetrics());
        myPaint.setStrokeWidth(strokeWidthInPx);

    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //здесь нужно минимально делать перериовку т.к. тратится много рисурсов.
        // не нужно создавать здесь объекты, лучше создать их зарание.

        int cx = getWidth() / 2;
        int cy = getHeight() / 2;
        int hour = calendar.get(Calendar.HOUR);
        int minutes = calendar.get(Calendar.MINUTE);
        // TextView.setText(String.valueOf(hour));
        // TextView.setText(hour + " : "+ mins);

        int radius = Math.min(getWidth(), getHeight()) / 4;
        canvas.drawCircle(cx, cy, radius, myPaint);
        int startX = cx;
        int startY = cy - radius - radius / 7;
        int stopX = cx;
        int stopY = cy - radius + radius / 7;
        myPaint.setTextSize(100);
        for (int i = 12; i > 0; i--) {
            canvas.drawLine(startX, startY, stopX, stopY, myPaint);
            if (i == hour || (hour == 0 && i == 12)) {

                strokeWidthInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
                myPaint.setStrokeWidth(strokeWidthInPx);
                canvas.drawLine(cx, cy, cx, cy - radius / 2, myPaint);// часовая стрелка
                strokeWidthInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics());
                myPaint.setStrokeWidth(strokeWidthInPx);

            }
            if (i == 12) {
                // if(i==12){

                canvas.drawText(String.valueOf(i), cx - radius / 5, startY, myPaint);

            }
            if (i == 9 || i == 3) {
                canvas.drawText(String.valueOf(i), cx - radius / 8, startY, myPaint);
            }
            if (i == 6) {
                canvas.drawText(String.valueOf(9), cx - radius / 8, startY, myPaint);
            }
            //canvas.drawPoint((float) cx,(float) cy,myPaint);
            canvas.rotate(-30, cx, cy);
        }
        canvas.rotate(6 * minutes, cx, cy);
        canvas.drawLine(cx, cy, cx, cy - radius / 1.3f, myPaint);// минутная стрелка


////   рисуем линию
//        int startX = 0;
//        int startY = 0;
//        // int stopX = getWidth();
//        int stopX = 50;
//        // int stopY = getHeight();
//        int stopY = 50;
//        canvas.drawLine(startX, startY, stopX, stopY, myPaint);
//        canvas.drawCircle();


//        arcRectF.left = 0;
//        arcRectF.top = 0;
//        arcRectF.right = getWidth();
//        arcRectF.bottom = getHeight();
//
//        canvas.drawArc(arcRectF, 0, -90, true, myPaint);
//
//
//        canvas.drawRect(50, 50, 100, 100, myPaint);


    }
}
