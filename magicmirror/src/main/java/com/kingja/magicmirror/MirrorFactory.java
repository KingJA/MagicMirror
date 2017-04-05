package com.kingja.magicmirror;

import com.kingja.magicmirror.mirror.AnyMirror;
import com.kingja.magicmirror.mirror.CircleMirror;
import com.kingja.magicmirror.mirror.Mirror;
import com.kingja.magicmirror.mirror.OvalMirror;
import com.kingja.magicmirror.mirror.PolygonMirror;
import com.kingja.magicmirror.mirror.RectMirror;
import com.kingja.magicmirror.mirror.RoundRectMirror;

/**
 * Description:TODO
 * Create Time:2017/3/22 21:23
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class MirrorFactory {
    private static final int RECT = 0;
    private static final int CIRCLE = 1;
    private static final int ROUND_RECT = 2;
    private static final int OVAL = 3;
    private static final int POLYGON = 4;
    private static final int ANY = 5;

    public static Mirror createMirror(int sharp) {
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
            case ANY:
                mirror = new AnyMirror();
                break;
            default:
                mirror = new RectMirror();
                break;
        }
        return mirror;
    }
}
