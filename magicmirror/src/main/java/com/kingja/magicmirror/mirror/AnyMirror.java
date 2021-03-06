package com.kingja.magicmirror.mirror;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Description:Any shape
 * Create Time:2017/3/22 21:31
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class AnyMirror extends Mirror {

    @Override
    public Path getMirrorPath() {
        if (getMaskRes() == 0) {
            throw new IllegalArgumentException("attr 'mirrorAnySharp' can't be empty");
        }
        Bitmap bitmap = getBitmapFromRes(getMagicMirror().getResources(), getMaskRes(), getWidth(), getHeight());
        Path path = getPixelsPath(bitmap);
        bitmap.recycle();
        float scaleX = getWidth() * 1.0f / bitmap.getWidth();
        float scaleY = getHeight() * 1.0f / bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(scaleX, scaleY);
        path.transform(matrix);
        return path;
    }

    @Override
    protected void setPersonalPaint(Paint bitmapPaint) {
        super.setPersonalPaint(bitmapPaint);
        bitmapPaint.setStyle(Paint.Style.STROKE);
    }

    private Path getPixelsPath(Bitmap bitmap) {
        Path path = new Path();
        int[] origin = new int[bitmap.getWidth()];
        int lastA;
        for (int i = 0; i < bitmap.getHeight(); i++) {
            bitmap.getPixels(origin, 0, bitmap.getWidth(), 0, i, bitmap.getWidth(), 1);
            lastA = 0;
            for (int j = 0; j < bitmap.getWidth(); j++) {
                int a = Color.alpha(origin[j]);
                if (a != 0 && lastA == 0) {
                    path.moveTo(j, i);
                } else if (a == 0 && lastA != 0) {
                    path.lineTo(j - 1, i);
                } else if (a != 0 && j == bitmap.getWidth() - 1) {
                    path.lineTo(j, i);
                }
                lastA = a;
            }
        }
        return path;
    }

    private Bitmap getBitmapFromRes(Resources resources, int resId, int width, int height) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, resId, options);
        int widthRatio = (int) (options.outWidth * 1.0f / width);
        int heightRatio = (int) (options.outHeight * 1.0f / height);
        options.inSampleSize = Math.max(widthRatio, heightRatio);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, resId, options);
    }


}
