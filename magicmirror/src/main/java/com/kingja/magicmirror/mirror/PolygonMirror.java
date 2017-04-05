package com.kingja.magicmirror.mirror;

import android.graphics.Matrix;
import android.graphics.Path;

/**
 * Description:Polygo
 * Create Time:2017/3/22 21:30
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class PolygonMirror extends Mirror {
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
        if (sides < 3) {
            throw new IllegalArgumentException("sides can't be smaller than 3");
        }
        Path path = new Path();
        float radius, centerX, centerY;
        radius = centerX = centerY = Math.min(width, height) * 0.5f;
        radius -= borderWidth * 0.5f;
        float offsetAngle = 0;
        offsetAngle = (float) (Math.PI * offsetAngle / 180);
        for (int i = 0; i < sides; i++) {
            float x = (float) (centerX + radius * Math.cos(offsetAngle));
            float y = (float) (centerY + radius * Math.sin(offsetAngle));
            offsetAngle += 2 * Math.PI / sides;
            if (i == 0) {
                path.moveTo(x, y);
            } else {
                path.lineTo(x, y);
            }
        }
        path.close();
        if (sides % 2 != 0) {
            Matrix mMatrix = new Matrix();
            mMatrix.postRotate(-90, centerX, centerY);
            path.transform(mMatrix);
        }
        return path;
    }


}
