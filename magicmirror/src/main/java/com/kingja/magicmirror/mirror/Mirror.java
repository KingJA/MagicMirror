package com.kingja.magicmirror.mirror;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;

import com.kingja.magicmirror.MagicMirrorView;
import com.kingja.magicmirror.filter.FilterHelper;

/**
 * Description:Mirror
 * Create Time:2017/3/22 21:01
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public abstract class Mirror {
    protected int corner;
    protected int borderWidth;
    protected int borderColor;
    protected int width;
    protected int height;
    protected int sides;
    protected int filter;
    protected int sharpResourceId;
    protected MagicMirrorView magicMirrorView;


    public Mirror setContext(@NonNull MagicMirrorView magicMirrorView) {
        this.magicMirrorView = magicMirrorView;
        return this;
    }

    public Mirror setShapeResourceId(@IdRes int sharpResourceId) {
        this.sharpResourceId = sharpResourceId;
        return this;
    }

    public Mirror setFilter(int filter) {
        this.filter = filter;
        return this;
    }

    public Mirror setCorner(int corner) {
        this.corner = corner;
        return this;
    }

    public int getCorner() {
        return corner;
    }

    public Mirror setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public Mirror setSides(int sides) {
        this.sides = sides;
        return this;
    }

    public int getSides() {
        return sides;
    }

    public Mirror setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public final Paint getStrokePaint() {
        Paint strokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setColor(borderColor);
        strokePaint.setStrokeWidth(borderWidth);
        return strokePaint;
    }


    public final RectF getRectF() {
        int borderOffset = (int) (borderWidth * 0.5f);
        RectF rectF = new RectF();
        rectF.set(borderOffset, borderOffset, width - borderOffset, height - borderOffset);
        return rectF;
    }

    public final Paint getShaderPaint() {
        Bitmap mBitmap = drawableToBitmap(magicMirrorView.getDrawable());
        mBitmap = FilterHelper.getFilterBitmap(mBitmap, filter);
        BitmapShader mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint mBitmapPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        setPersonalPaint(mBitmapPaint);
        mBitmapShader.setLocalMatrix(magicMirrorView.getImageMatrix());
        mBitmapPaint.setShader(mBitmapShader);
        return mBitmapPaint;
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap bitmap;
        try {
            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(2, 2, Bitmap.Config.ARGB_8888);
            } else {
                int width = drawable.getIntrinsicWidth();
                int height = drawable.getIntrinsicHeight();
                bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        } catch (Exception e) {
            e.printStackTrace();
            bitmap = null;
        }
        return bitmap;
    }

    public final void drawMirror(Canvas canvas) {
        canvas.drawPath(getMirrorPath(), getShaderPaint());
        if (borderWidth > 0) {
            canvas.drawPath(getMirrorPath(), getStrokePaint());
        }
    }

    protected void setPersonalPaint(Paint bitmapPaint) {
    }

    public int getMeasuredMirrorWidth() {
        width = Math.min(magicMirrorView.getMeasuredWidth(), magicMirrorView.getMeasuredHeight());
        return Math.min(magicMirrorView.getMeasuredWidth(), magicMirrorView.getMeasuredHeight());
    }

    public int getMeasuredMirrorHeight() {
        height = Math.min(magicMirrorView.getMeasuredWidth(), magicMirrorView.getMeasuredHeight());
        return Math.min(magicMirrorView.getMeasuredWidth(), magicMirrorView.getMeasuredHeight());
    }

    public abstract Path getMirrorPath();


}
