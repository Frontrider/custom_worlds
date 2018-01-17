package hu.frontrider.worlds.dimension;

import hu.frontrider.worlds.dimension.generators.TerrainGenerator;
import hu.frontrider.worlds.registry.DimensionRegistry;
import net.minecraft.init.Biomes;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.DimensionManager;

/**
 * Created by frontrider on 2018.01.13..
 */
public class WorldProvider extends net.minecraft.world.WorldProvider {

    private DimensionType type;
    @Override
    public void setDimension(int dimid) {
        super.setDimension(dimid);
        type = DimensionManager.getProviderType(dimid);
    }

    @Override
    public DimensionType getDimensionType() {
        return type;
    }

    @Override
    public String getSaveFolder() {
        return "DIM"+type.getId();
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkProvider(world, new TerrainGenerator(world, DimensionRegistry.dimensionmap.get(type.getId())));
    }

    @Override
    public BiomeProvider getBiomeProvider() {
        return new BiomeProviderSingle(Biomes.OCEAN);
    }
}
