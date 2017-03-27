package com.kingja.magicmirror;

import com.kingja.magicmirror.mirror.CircleMirror;
import com.kingja.magicmirror.mirror.OvalMirror;
import com.kingja.magicmirror.mirror.RoundRectMirror;

/**
 * Description：TODO
 * Create Time：2017/3/2221:23
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class MirrorFactory {
    public static final int CIRCLE = 0;
    public static final int ROUND_RECT = 1;
    public static final int OVAL = 2;

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
            default:
                mirror = new CircleMirror();
                break;
        }
        return mirror;
    }
}
