package com.kingja.magicmirror;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.kingja.magicmirror.mirror.Mirror;

/**
 * Description:TODO
 * Create Time:2017/3/1421:30
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class MagicMirrorView extends AppCompatImageView {

    private static final int DEFAULT_SIDES = 5;
    private int corner;
    private int borderWidth;
    private int borderColor;
    private int sides;
    private int filter;
    private int shapeResourceId;
    private Mirror mirror;

    public interface Filter {
        int OLDPICTURE = 1;
        int GRAY = 2;
        int SATURATION = 3;
    }


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
        corner = Util.dp2px(context, typedArray.getDimension(R.styleable.MagicMirrorView_mirrorCorner, 0));
        borderWidth = Util.dp2px(context, typedArray.getDimension(R.styleable.MagicMirrorView_mirrorBorderWidth, 0));
        borderColor = typedArray.getColor(R.styleable.MagicMirrorView_mirrorBorderColor, Color.TRANSPARENT);
        shapeResourceId = typedArray.getResourceId(R.styleable.MagicMirrorView_mirrorAnyShape, 0);
        filter = typedArray.getInteger(R.styleable.MagicMirrorView_mirrorFilter, 0);
        sides = typedArray.getInteger(R.styleable.MagicMirrorView_mirrorSides, DEFAULT_SIDES);
        mirror = MirrorFactory.createMirror(sharpCode)
                .setContext(this)
                .setShapeResourceId(shapeResourceId)
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

    public void setShapeResourceId(int shapeResourceId) {
        mirror.setShapeResourceId(shapeResourceId);
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
