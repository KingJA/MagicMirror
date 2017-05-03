package com.kingja.magicmirror.mirror;

import android.graphics.Path;

/**
 * Description:RoundRect
 * Create Time:2017/3/22 21:31
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class RoundRectMirror extends Mirror {

    @Override
    public Path getMirrorPath() {
        Path path = new Path();
        path.addRoundRect(getRectF(), getCorner(), getCorner(), Path.Direction.CW);
        return path;
    }
}
