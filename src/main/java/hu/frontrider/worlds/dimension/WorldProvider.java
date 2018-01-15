package hu.frontrider.worlds.dimension;

import net.minecraft.world.DimensionType;
import net.minecraft.world.gen.IChunkGenerator;

/**
 * Created by frontrider on 2018.01.13..
 */
public class WorldProvider extends net.minecraft.world.WorldProvider {

    @Override
    public DimensionType getDimensionType() {
        return null;
    }
    @Override
    public String getSaveFolder() {
        return "TEST";
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkProvider(world);
    }
}
