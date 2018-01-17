package hu.frontrider.worlds.dimension.generators;

import hu.frontrider.worlds.config.DimensionHolder;
import hu.frontrider.worlds.dimension.ChunkProvider;
import hu.frontrider.worlds.dimension.Generator;
import hu.frontrider.worlds.registry.DimensionRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;

import java.util.Random;

import static hu.frontrider.worlds.registry.BiomeRegistry.biomes;

/**
 * Normal terrain generator
 */

public class TerrainGenerator extends Generator{

    public TerrainGenerator(World world,DimensionHolder settings) {
        super(world,settings);
        this.heightMap = new double[825];

        this.biomeWeights = new float[25];
        for (int j = -2; j <= 2; ++j) {
            for (int k = -2; k <= 2; ++k) {
                float f = 10.0F / MathHelper.sqrt((j * j + k * k) + 0.2F);
                this.biomeWeights[j + 2 + (k + 2) * 5] = f;
            }
        }
    }


    @Override
    public void generate(int chunkX, int chunkZ, ChunkPrimer primer) {
        generateHeightmap(chunkX * 4, 0, chunkZ * 4);

        for (int x4 = 0; x4 < 4; ++x4) {
            int l = x4 * 5;
            int i1 = (x4 + 1) * 5;

            for (int z4 = 0; z4 < 4; ++z4) {
                int k1 = (l + z4) * 33;
                int l1 = (l + z4 + 1) * 33;
                int i2 = (i1 + z4) * 33;
                int j2 = (i1 + z4 + 1) * 33;

                for (int height32 = 0; height32 < 32; ++height32) {
                    double d0 = 0.125D;
                    double d1 = heightMap[k1 + height32];
                    double d2 = heightMap[l1 + height32];
                    double d3 = heightMap[i2 + height32];
                    double d4 = heightMap[j2 + height32];
                    double d5 = (heightMap[k1 + height32 + 1] - d1) * d0;
                    double d6 = (heightMap[l1 + height32 + 1] - d2) * d0;
                    double d7 = (heightMap[i2 + height32 + 1] - d3) * d0;
                    double d8 = (heightMap[j2 + height32 + 1] - d4) * d0;

                    for (int h = 0; h < 8; ++h) {
                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;
                        int height = (height32 * 8) + h;

                        for (int x = 0; x < 4; ++x) {
                            double d14 = 0.25D;
                            double d16 = (d11 - d10) * d14;
                            double d15 = d10 - d16;

                            for (int z = 0; z < 4; ++z) {
                                if (height < 2) {
                                    primer.setBlockState(x4 * 4 + x, height32 * 8 + h, z4 * 4 + z, Blocks.BEDROCK.getDefaultState());
                                } else if ((d15 += d16) > 0.0D) {
                                    primer.setBlockState(x4 * 4 + x, height32 * 8 + h, z4 * 4 + z, material);
                                }
                                else if(height<sealevel)
                                {
                                    primer.setBlockState(x4 * 4 + x, height32 * 8 + h, z4 * 4 + z, fluid);
                                }
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }

    @Override
    public void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, IChunkGenerator generator, Biome[] biomes) {
        if (!net.minecraftforge.event.ForgeEventFactory.onReplaceBiomeBlocks(generator, x, z, primer, this.world)) return;
        this.depthBuffer = this.surfaceNoise.getRegion(this.depthBuffer, (x * 16), (z * 16), 16, 16, 0.0625D, 0.0625D, 1.0D);

        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                Biome biome = biomes[j + i * 16];
                biome.genTerrainBlocks(this.world, this.random, primer, x * 16 + i, z * 16 + j, this.depthBuffer[j + i * 16]);
            }
        }
    }

}
