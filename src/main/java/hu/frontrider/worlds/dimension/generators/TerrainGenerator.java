package hu.frontrider.worlds.dimension.generators;

import hu.frontrider.worlds.dimension.Generator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;

/**
 * Normal terrain generator
 */
public class TerrainGenerator extends Generator{


    TerrainGenerator(World world){
        super(world);
        this.world = world;

    }


    public void generate(int chunkX, int chunkZ, ChunkPrimer primer) {
        generateHeightmap(chunkX,0,chunkZ);
        int waterlevel = 63;




    }
}
