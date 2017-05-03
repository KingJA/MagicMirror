package com.kingja.magicmirror.mirror;

import android.graphics.Path;

/**
 * Description:Rect
 * Create Time:2017/3/22 21:31
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class RectMirror extends Mirror {

    @Override
    public Path getMirrorPath() {
        Path path = new Path();
        path.addRect(getRectF(), Path.Direction.CW);
        return path;
    }

}
