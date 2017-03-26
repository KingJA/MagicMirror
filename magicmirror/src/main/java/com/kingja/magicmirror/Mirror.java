package com.kingja.magicmirror;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Description：TODO
 * Create Time：2017/3/2221:01
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public abstract class Mirror {
    protected int corner;
    protected int borderWidth;
    protected int borderColor;
    protected int width;
    protected int height;
    protected MagicMirrorView magicMirrorView;


    public Mirror setContext(MagicMirrorView magicMirrorView) {
        this.magicMirrorView = magicMirrorView;
        return this;
    }

    public Mirror setCorner(int corner) {
        this.corner = corner;
        return this;
    }

    public Mirror setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public Mirror setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    public Paint getStrokePaint() {
        Paint strokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setColor(borderColor);
        strokePaint.setStrokeWidth(borderWidth);
        return strokePaint;
    }

    public RectF getRectF() {
        int borderOffset = (int) (borderWidth * 0.5f);
        RectF rectF = new RectF();
        rectF.set(borderOffset, borderOffset, width - borderOffset, height - borderOffset);
        return rectF;
    }

    public Paint getShaderPaint() {
        Bitmap mBitmap = drawable2Bitmap(magicMirrorView.getDrawable());
        BitmapShader mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        int bitmapSize = Math.min(mBitmap.getWidth(), mBitmap.getHeight());
        float scale = width * 1.0f / bitmapSize;

        Matrix mMatrix = new Matrix();
        mMatrix.setScale(scale, scale);
        mBitmapShader.setLocalMatrix(mMatrix);

        Paint mBitmapPaint = new Paint();
        mBitmapPaint.setAntiAlias(true);
        mBitmapPaint.setShader(mBitmapShader);
        return mBitmapPaint;
    }

    private Bitmap drawable2Bitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        if (drawable != null) {
            drawable.setBounds(0, 0, width, height);
            drawable.draw(canvas);
        }
        return bitmap;

    }

    public void drawMirror(Canvas canvas) {
        canvas.drawPath(getMirrorPath(), getShaderPaint());
        canvas.drawPath(getMirrorPath(), getStrokePaint());
    }

    abstract int getMeasuredMirrorWidth();

    abstract int getMeasuredMirrorHeight();

    abstract Path getMirrorPath();
}
