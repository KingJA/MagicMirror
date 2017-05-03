package com.kingja.magicmirror;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.kingja.magicmirror.mirror.Mirror;

/**
 * Description:MagicMirrorView
 * Create Time:2017/3/1421:30
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class MagicMirrorView extends AppCompatImageView {

    private static final int DEFAULT_SIDES = 5;
    private Mirror mirror;

    public MagicMirrorView(Context context) {
        this(context, null);
    }

    public MagicMirrorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MagicMirrorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MagicMirrorView);
        int sharpCode = typedArray.getInteger(R.styleable.MagicMirrorView_mirrorShape, 0);
        int corner = Util.dp2px(context, typedArray.getDimension(R.styleable.MagicMirrorView_mirrorCorner, 0));
        int borderWidth = Util.dp2px(context, typedArray.getDimension(R.styleable.MagicMirrorView_mirrorBorderWidth,
                0));
        int borderColor = typedArray.getColor(R.styleable.MagicMirrorView_mirrorBorderColor, Color.TRANSPARENT);
        int maskRes = typedArray.getResourceId(R.styleable.MagicMirrorView_mirrorMaskRes, 0);
        int filter = typedArray.getInteger(R.styleable.MagicMirrorView_mirrorFilter, 0);
        int sides = typedArray.getInteger(R.styleable.MagicMirrorView_mirrorSides, DEFAULT_SIDES);
        mirror = MirrorFactory.createMirror(sharpCode)
                .setContext(this)
                .setMaskRes(maskRes)
                .setFilter(filter)
                .setCorner(corner)
                .setBorderWidth(borderWidth)
                .setBorderColor(borderColor)
                .setSides(sides);
        typedArray.recycle();
        setScaleType(ScaleType.CENTER_CROP);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(mirror.getMeasuredMirrorWidth(), mirror.getMeasuredMirrorHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mirror.drawMirror(canvas);
    }

    public void setCorner(int conrner) {
        mirror.setCorner(conrner);
        invalidate();
    }

    public void setBorderWidth(int borderWidth) {
        mirror.setBorderWidth(borderWidth);
        invalidate();
    }

    public void setBorderColor(int borderColor) {
        mirror.setBorderColor(borderColor);
        invalidate();
    }

    public void setSides(int sides) {
        mirror.setSides(sides);
        invalidate();
    }

    public void setFilter(int filter) {
        mirror.setFilter(filter);
        invalidate();
    }

    public void setMaskRes(int maskRes) {
        mirror.setMaskRes(maskRes);
        invalidate();
    }

    @Override
    public void setScaleType(ScaleType scaleType) {
        if (ScaleType.FIT_XY == scaleType) {
            scaleType = ScaleType.CENTER_CROP;
        }
        super.setScaleType(scaleType);
    }
}
