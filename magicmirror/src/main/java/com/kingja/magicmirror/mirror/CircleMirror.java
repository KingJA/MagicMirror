package com.kingja.magicmirror.mirror;

import android.graphics.Path;

import com.kingja.magicmirror.Mirror;

/**
 * Description：TODO
 * Create Time：2017/3/2221:30
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class CircleMirror extends Mirror {
    @Override
    public int getMeasuredMirrorWidth() {
        width = Math.min(magicMirrorView.getMeasuredWidth(), magicMirrorView.getMeasuredHeight());
        return width;
    }

    @Override
    public int getMeasuredMirrorHeight() {
        height = Math.min(magicMirrorView.getMeasuredWidth(), magicMirrorView.getMeasuredHeight());
        return height;
    }

    @Override
    public Path getMirrorPath() {
        Path path = new Path();
        path.addCircle(getRectF().centerX(), getRectF().centerY(), width * 0.5f - borderWidth * 0.5f, Path.Direction.CW);
        return path;
    }


}
