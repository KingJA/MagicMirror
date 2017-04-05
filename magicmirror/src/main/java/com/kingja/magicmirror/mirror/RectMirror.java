package com.kingja.magicmirror.mirror;

import android.graphics.Path;

/**
 * Description:TODO
 * Create Time:2017/3/22 21:31
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class RectMirror extends Mirror {
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
        Path path = new Path();
        path.addRect(getRectF(), Path.Direction.CW);
        return path;
    }

}
