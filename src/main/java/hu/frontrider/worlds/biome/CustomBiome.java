package hu.frontrider.worlds.biome;

import hu.frontrider.worlds.Worlds;
import hu.frontrider.worlds.util.StringUtils;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;

import java.util.List;

/**
 * Created by frontrider on 2018.01.13..
 */
public class CustomBiome extends Biome {


    private final int skyColor;

    public CustomBiome(ExtendedBiomeProperties biomeproperties) {
        super(biomeproperties);
        setRegistryName(Worlds.MODID+":"+ StringUtils.clean(biomeproperties.name));
        this.spawnableWaterCreatureList = biomeproperties.water;
        this.spawnableMonsterList = biomeproperties.hostile;
        this.spawnableCaveCreatureList = biomeproperties.ambient;
        this.spawnableCreatureList = biomeproperties.neutral;
        this.skyColor = biomeproperties.skyColor;
    }

    @Override
    public List<SpawnListEntry> getSpawnableList(EnumCreatureType type) {
     switch (type)
     {
         case AMBIENT:
              return spawnableCaveCreatureList;
         case MONSTER:
             return spawnableMonsterList;

         case CREATURE:
             return spawnableCreatureList;

         case WATER_CREATURE:
             return spawnableWaterCreatureList;

     }
     return null;
    }

    @Override
    public int getSkyColorByTemp(float p_getSkyColorByTemp_1_) {
        return skyColor;
    }


}
