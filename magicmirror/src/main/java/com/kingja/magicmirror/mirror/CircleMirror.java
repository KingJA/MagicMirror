package com.kingja.magicmirror.mirror;

import android.graphics.Path;

/**
 * Description:Circle
 * Create Time:2017/3/22 21:30
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class CircleMirror extends Mirror {

    @Override
    public Path getMirrorPath() {
        Path path = new Path();
        path.addCircle(getRectF().centerX(), getRectF().centerY(), getMeasuredMirrorWidth() * 0.5f - getBorderWidth() * 0.5f, Path
                .Direction.CW);
        return path;
    }
}
