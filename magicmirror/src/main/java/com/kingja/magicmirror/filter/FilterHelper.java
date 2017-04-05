package com.kingja.magicmirror.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Description：TODO
 * Create Time：2017/3/28 22:05
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class FilterHelper {
    private static final float[] CLEAR = {
            1F, 0F, 0F, 0F, 0F,
            0F, 1F, 0F, 0F, 0F,
            0F, 0F, 1F, 0F, 0F,
            0F, 0F, 0F, 1F, 0F};
    private static final float[] OLDPICTURE = {
            0.393F, 0.769F, 0.189F, 0, 0,
            0.349F, 0.686F, 0.168F, 0, 0,
            0.272F, 0.534F, 0.131F, 0, 0,
            0, 0, 0, 1, 0};

    private static final float[] GRAY = {
            0.33F, 0.59F, 0.11F, 0F, 0F,
            0.33F, 0.59F, 0.11F, 0F, 0F,
            0.33F, 0.59F, 0.11F, 0F, 0F,
            0F, 0F, 0F, 1F, 0F};

    private static final float[] SATURATION = {
            1.438F, -0.122F, -0.016F, 0F, -0.03F,
            -0.062F, 1.378F, -0.016F, 0F, 0.05F,
            -0.062F, -0.122F, 1.483F, 0F, -0.02F,
            0F, 0F, 0F, 1F, 0F};


    public static Bitmap getFilterBitmap(Bitmap bitmap, int filter) {
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();
        ColorMatrix hueMatrix = new ColorMatrix();
        hueMatrix.set(getFilter(filter));
        paint.setColorFilter(new ColorMatrixColorFilter(hueMatrix));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return bmp;
    }

    private static float[] getFilter(int filter) {
        float[] filterArr = CLEAR;
        switch (filter) {
            case 1:
                filterArr = OLDPICTURE;
                break;
            case 2:
                filterArr = GRAY;
                break;
            case 3:
                filterArr = SATURATION;
                break;
        }
        return filterArr;
    }
}
