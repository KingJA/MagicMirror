package com.kingja.magicmirror.mirror;

import android.graphics.Path;

/**
 * Description:Oval
 * Create Time:2017/3/22 21:31
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class OvalMirror extends Mirror {
    @Override
    public int getMeasuredMirrorWidth() {
        setWidth(magicMirrorView.getMeasuredWidth());
        return magicMirrorView.getMeasuredWidth();
    }

    @Override
    public int getMeasuredMirrorHeight() {
        setHeight(magicMirrorView.getMeasuredHeight());
        return magicMirrorView.getMeasuredHeight();
    }

    @Override
    public Path getMirrorPath() {
        Path path = new Path();
        path.addOval(getRectF(), Path.Direction.CW);
        return path;
    }

}
