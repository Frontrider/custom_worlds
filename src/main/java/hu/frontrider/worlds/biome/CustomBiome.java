package hu.frontrider.worlds.biome;

import hu.frontrider.worlds.Worlds;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;

import java.util.List;

/**
 * Created by frontrider on 2018.01.13..
 */
public class CustomBiome extends Biome {

    ExtendedBiomeProperties biomeproperties;

    public CustomBiome(ExtendedBiomeProperties biomeProperties) {
        super(biomeProperties);
        this.biomeproperties = biomeProperties;
        setRegistryName(Worlds.MODID+":"+biomeProperties.name.toLowerCase().replace(" ","_"));
    }

    @Override
    public List<SpawnListEntry> getSpawnableList(EnumCreatureType type) {
     switch (type)
     {
         case AMBIENT:
              return biomeproperties.ambient;
         case MONSTER:
             return biomeproperties.hostile;

         case CREATURE:
             return biomeproperties.neutral;

         case WATER_CREATURE:
             return biomeproperties.water;

     }
     return null;
    }

    @Override
    public int getSkyColorByTemp(float p_getSkyColorByTemp_1_) {
        return biomeproperties.skyColor;
    }


}
