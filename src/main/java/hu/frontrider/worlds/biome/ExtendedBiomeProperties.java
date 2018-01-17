package hu.frontrider.worlds.biome;

import hu.frontrider.worlds.config.BiomeConfigHolder;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.biome.Biome;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by frontrider on 2018.01.13..
 */
public class ExtendedBiomeProperties extends Biome.BiomeProperties {

    ArrayList<Biome.SpawnListEntry> hostile;
    ArrayList<Biome.SpawnListEntry> water;
    ArrayList<Biome.SpawnListEntry> neutral;
    ArrayList<Biome.SpawnListEntry> ambient;
    int skyColor;
    HashMap<IBlockState,Integer> flowers = new HashMap<>();
    String name;

    public ExtendedBiomeProperties(String name) {
        super(name);

    }

    public ExtendedBiomeProperties(BiomeConfigHolder configHolder)
    {
        super(configHolder.name);
        setBaseHeight(configHolder.baseHeight);
        setHeightVariation(configHolder.heightVariation);
        if(configHolder.raindisabled)
            setRainDisabled();
        if(configHolder.snowenabled)
            setSnowEnabled();
        setTemperature(configHolder.temperature);
        setWaterColor(configHolder.watercolor.getColor());
        skyColor = configHolder.skycolor.getColor();
        name = configHolder.name;



    }
}
