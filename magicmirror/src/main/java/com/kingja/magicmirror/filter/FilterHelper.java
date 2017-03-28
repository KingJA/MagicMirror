package com.kingja.magicmirror.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Description：TODO
 * Create Time：2017/3/2822:05
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class FilterHelper {
    private static final  float[] OLD = {
            0.393f,0.769f,0.189f,0,0,
            0.349f,0.686f,0.168f,0,0,
            0.272f,0.534f,0.131f,0,0,
            0,0,0,1,0};

    public static Bitmap getFilter(Bitmap bitmap) {
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();
        ColorMatrix hueMatrix = new ColorMatrix();
        hueMatrix.set(OLD);
        paint.setColorFilter(new ColorMatrixColorFilter(hueMatrix));
        canvas.drawBitmap(bitmap,0,0,paint);
       return bmp;
    }
}
