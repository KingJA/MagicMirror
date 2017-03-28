package com.kingja.magicmirror.mirror;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Description：TODO
 * Create Time：2017/3/2221:31
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class MagicMirror extends Mirror {
    @Override
    public int getMeasuredMirrorWidth() {
        width = magicMirrorView.getMeasuredWidth();
        return width;
    }

    @Override
    public int getMeasuredMirrorHeight() {
        this.height = magicMirrorView.getMeasuredHeight();
        return height;
    }

    @Override
    public Path getMirrorPath() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        /*缩放Bitmap，使它的尺寸不超过ImageView的尺寸*/
        BitmapFactory.decodeResource(magicMirrorView.getResources(), resourceId, options);
        int widthRatio = (int) (options.outWidth * 1f / width);
        int heightRatio = (int) (options.outHeight * 1f / height);
        if (widthRatio > heightRatio) {
            options.inSampleSize = widthRatio;
        } else {
            options.inSampleSize = heightRatio;
        }
        if (options.inSampleSize == 0) {
            options.inSampleSize = 1;
        }
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeResource(magicMirrorView.getResources(), resourceId, options);
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        /*获取像素路径*/
        Path path = new Path();
        int[] origin = new int[bitmapWidth];
        int lastA;
        for (int i = 0; i < bitmapHeight; i++) {
            bitmap.getPixels(origin, 0, bitmapWidth, 0, i, bitmapWidth, 1);
            lastA = 0;
            for (int j = 0; j < bitmapWidth; j++) {
                int a = Color.alpha(origin[j]);
                if (a != 0 && lastA == 0) {
                    path.moveTo(j, i);
                } else if (a == 0 && lastA != 0) {
                    path.lineTo(j - 1, i);
                } else if (a != 0 && j == bitmapWidth - 1) {
                    path.lineTo(j, i);
                }
                lastA = a;
            }
        }
        bitmap.recycle();
        Matrix matrix = new Matrix();
        float scaleX = width * 1.0f / bitmap.getWidth();
        float scaleY = height * 1.0f / bitmap.getHeight();
        matrix.setScale(scaleX, scaleY);
        path.transform(matrix);
        return path;
    }

    @Override
    protected void setPersonalPaint(Paint bitmapPaint) {
        super.setPersonalPaint(bitmapPaint);
        bitmapPaint.setStyle(Paint.Style.STROKE);
    }
}
