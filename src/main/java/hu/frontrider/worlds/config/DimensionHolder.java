package hu.frontrider.worlds.config;

/**
 * Created by frontrider on 2018.01.13..
 */
public class DimensionHolder {
    public int sealevel=60;
    public BlockHolder material;
    public BlockHolder fluid;
    public String dimensiontype = "default";
    public int id=-1;
    public BiomeGenRule biomeGenRule = new BiomeGenRule();
}