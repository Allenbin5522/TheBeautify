package com.example.dllo.thebeautiful.ui.activity.child_activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;

/**
 * Created by dllo on 16/8/18.
 */
public class MyDrawable extends BitmapDrawable {
    private Bitmap bitmap;

    public MyDrawable setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        return this;
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        if(bitmap!=null){
            canvas.drawBitmap(bitmap,0,0,paint);
        }
        super.draw(canvas);
    }
}
