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
    public Path getMirrorPath() {
        Path path = new Path();
        float radius, centerX, centerY;
        radius = centerX = centerY = Math.min(getWidth(), getHeight()) * 0.5f;
        radius -= getBorderWidth() * 0.5f;
        float offsetAngle = 0;
        offsetAngle = (float) (Math.PI * offsetAngle / 180);
        for (int i = 0; i < getSides(); i++) {
            float x = (float) (centerX + radius * Math.cos(offsetAngle));
            float y = (float) (centerY + radius * Math.sin(offsetAngle));
            offsetAngle += 2 * Math.PI / getSides();
            if (i == 0) {
                path.moveTo(x, y);
            } else {
                path.lineTo(x, y);
            }
        }
        path.close();
        if (getSides() % 2 != 0) {
            Matrix mMatrix = new Matrix();
            mMatrix.postRotate(-90, centerX, centerY);
            path.transform(mMatrix);
        }
        return path;
    }

}
