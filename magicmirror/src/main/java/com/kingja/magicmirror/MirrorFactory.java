package com.kingja.magicmirror;

/**
 * Description：TODO
 * Create Time：2017/3/2221:23
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class MirrorFactory {
    public static final int CIRCLE = 0;
    public static final int ROUND_RECT = 1;

    public static Mirror getMirror(int sharp) {
        Mirror mirror;
        switch (sharp) {
            case 0:
                mirror=new CircleMirror();
                break;
            case 1:
                mirror=new RoundRectMirror();
                break;
            default:
                mirror=new CircleMirror();
                break;
        }
        return mirror;
    }
}
