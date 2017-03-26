package com.kingja.magicmirror;

import android.graphics.Path;

/**
 * Description：TODO
 * Create Time：2017/3/2221:30
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class CircleMirror extends Mirror {
    @Override
    int getMeasuredMirrorWidth() {
        width=Math.min(magicMirrorView.getMeasuredWidth(), magicMirrorView.getMeasuredHeight());
        return width;
    }

    @Override
    int getMeasuredMirrorHeight() {
        height=Math.min(magicMirrorView.getMeasuredWidth(), magicMirrorView.getMeasuredHeight());
        return height;
    }

    @Override
    Path getMirrorPath() {
        Path path = new Path();
        path.addCircle(getRectF().centerX(), getRectF().centerY(), width*0.5f-borderWidth*0.5f, Path.Direction.CW);
        return path;
    }


}
