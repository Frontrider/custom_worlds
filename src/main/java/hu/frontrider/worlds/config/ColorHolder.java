package hu.frontrider.worlds.config;

/**
 * Created by frontrider on 2018.01.13..
 */
public class ColorHolder {
    private int r = 255;
    private int g = 255;
    protected int b = 255;

    public int getColor(){
        return ((r&0x0ff)<<16)|((g&0x0ff)<<8)|(b&0x0ff);
    }
}
