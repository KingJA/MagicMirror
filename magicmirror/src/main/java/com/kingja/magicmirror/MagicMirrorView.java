package com.kingja.magicmirror;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

import com.kingja.magicmirror.mirror.Mirror;

/**
 * Description:TODO
 * Create Time:2017/3/1421:30
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class MagicMirrorView extends ImageView {

    private int corner;
    private int borderWidth;
    private int borderColor;
    private int sides;
    private int filter;
    private Mirror mirror;
    private int resourceId;

    public MagicMirrorView(Context context) {
        this(context, null);
    }

    public MagicMirrorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MagicMirrorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MagicMirrorView);
        int sharpCode = typedArray.getInteger(R.styleable.MagicMirrorView_mirrorSharp, 0);
        corner = dp2px(typedArray.getDimension(R.styleable.MagicMirrorView_mirrorCorner, 0));
        borderWidth = dp2px(typedArray.getDimension(R.styleable.MagicMirrorView_mirrorBorderWidth, 0));
        borderColor = typedArray.getColor(R.styleable.MagicMirrorView_mirrorBorderColor, 0xffffff);
        resourceId = typedArray.getResourceId(R.styleable.MagicMirrorView_mirrorAnySharp, 0);
        filter = typedArray.getInteger(R.styleable.MagicMirrorView_mirrorFilter, 0);
        sides =typedArray.getInteger(R.styleable.MagicMirrorView_mirrorSides, 5);
        mirror = MirrorFactory.getMirror(sharpCode)
                .setContext(this)
                .setResourceId(resourceId)
                .setFilter(filter)
                .setCorner(corner)
                .setBorderWidth(borderWidth)
                .setBorderColor(borderColor)
                .setSides(sides);
        typedArray.recycle();
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

    protected int dp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }
}
