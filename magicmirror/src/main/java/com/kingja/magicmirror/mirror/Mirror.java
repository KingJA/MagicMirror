package com.kingja.magicmirror.mirror;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

import com.kingja.magicmirror.MagicMirrorView;

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
    protected int sides;
    protected int resourceId;
    protected MagicMirrorView magicMirrorView;


    public Mirror setContext(MagicMirrorView magicMirrorView) {
        this.magicMirrorView = magicMirrorView;
        return this;
    }

    public Mirror setResourceId(int resourceId) {
        this.resourceId = resourceId;
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

    public Mirror setSides(int sides) {
        this.sides = sides;
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

//        int bitmapSize = Math.min(mBitmap.getWidth(), mBitmap.getHeight());
//        float scale = width * 1.0f / bitmapSize;
        float scaleX = width * 1.0f / mBitmap.getWidth();
        float scaleY = height * 1.0f / mBitmap.getHeight();
        Paint mBitmapPaint = new Paint();
        setPersonalPaint(mBitmapPaint);
        mBitmapPaint.setAntiAlias(true);
        Matrix mMatrix = new Matrix();
        mMatrix.setScale(scaleX, scaleY);
        mBitmapShader.setLocalMatrix(mMatrix);



        mBitmapPaint.setShader(mBitmapShader);
        return mBitmapPaint;
    }

    protected void setPersonalPaint(Paint bitmapPaint) {}

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
        if (borderWidth > 0) {
            canvas.drawPath(getMirrorPath(), getStrokePaint());
        }
    }

    public abstract int getMeasuredMirrorWidth();

    public abstract int getMeasuredMirrorHeight();

    public abstract Path getMirrorPath();
}
