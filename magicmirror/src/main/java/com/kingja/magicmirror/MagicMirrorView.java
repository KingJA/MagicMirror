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
 * Create Time:2017/3/14 21:30
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class MagicMirrorView extends ImageView {

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
        mirror = MirrorFactory.createMirror(typedArray.getInteger(R.styleable.MagicMirrorView_mirrorSharp, 0))
                .setContext(this)
                .setResourceId(typedArray.getResourceId(R.styleable.MagicMirrorView_mirrorAnySharp, 0))
                .setFilter(typedArray.getInteger(R.styleable.MagicMirrorView_mirrorFilter, 0))
                .setCorner(dp2px(typedArray.getDimension(R.styleable.MagicMirrorView_mirrorCorner, 0)))
                .setBorderWidth(dp2px(typedArray.getDimension(R.styleable.MagicMirrorView_mirrorBorderWidth, 0)))
                .setBorderColor(typedArray.getColor(R.styleable.MagicMirrorView_mirrorBorderColor, 0xffffff))
                .setSides(typedArray.getInteger(R.styleable.MagicMirrorView_mirrorSides, 5));
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
