package com.kingja.magicmirror;

import android.graphics.Path;

/**
 * Description：TODO
 * Create Time：2017/3/2221:31
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class RoundRectMirror extends Mirror {
    @Override
    int getMeasuredMirrorWidth() {
        width= magicMirrorView.getMeasuredWidth();
        return width;
    }

    @Override
    int getMeasuredMirrorHeight() {
        this.height= magicMirrorView.getMeasuredHeight();
        return height;
    }

    @Override
    Path getMirrorPath() {
        Path path = new Path();
        path.addRoundRect(getRectF(), corner, corner, Path.Direction.CW);
        return path;
    }

}
