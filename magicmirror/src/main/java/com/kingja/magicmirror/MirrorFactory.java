package com.kingja.magicmirror;

import com.kingja.magicmirror.mirror.CircleMirror;
import com.kingja.magicmirror.mirror.Mirror;
import com.kingja.magicmirror.mirror.OvalMirror;
import com.kingja.magicmirror.mirror.PolygonMirror;
import com.kingja.magicmirror.mirror.RectMirror;
import com.kingja.magicmirror.mirror.RoundRectMirror;

/**
 * Description：TODO
 * Create Time：2017/3/2221:23
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class MirrorFactory {
    public static final int RECT = 0;
    public static final int CIRCLE = 1;
    public static final int ROUND_RECT = 2;
    public static final int OVAL = 3;
    public static final int POLYGON = 4;

    public static Mirror getMirror(int sharp) {
        Mirror mirror;
        switch (sharp) {
            case CIRCLE:
                mirror = new CircleMirror();
                break;
            case ROUND_RECT:
                mirror = new RoundRectMirror();
                break;
            case OVAL:
                mirror = new OvalMirror();
                break;
            case RECT:
                mirror = new RectMirror();
                break;
            case POLYGON:
                mirror = new PolygonMirror();
                break;
            default:
                mirror = new RectMirror();
                break;
        }
        return mirror;
    }
}
