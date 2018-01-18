package biome_provider_test;


import hu.frontrider.worlds.biome.biomegen.BProvider;
import hu.frontrider.worlds.biome.biomegen.GenLayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The working of the BiomeProvider:
 * it has a biome array, indexed according to the tempature.
 * Genlayer(s?) output ints indexing the biome array.
 * */

public class BiomeProviderTest {

    private BProvider provider;
    private int biomecount = 10;

    @BeforeEach
    void beforeAll()
    {
        provider = new BProvider(1234L);
    }

    @Nested
    @DisplayName("Biome test")
    class biomes {
        @Test
        @DisplayName("get biome for a set of chunks")
        void getBiome() {
            assertTrue(provider.getvalue(0, 0) > -1);

        }

        @Test
        @DisplayName("get biome for an area at 0,0-16-16, the chunk az 0,0")
        void getBiomeChunk() {
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++)
                    assertTrue(provider.getvalue(i, j) > -1);
            }
        }
    }
    @Nested
    @DisplayName("Layertest")
    class genlayertest{
        GenLayer[] layers;
        @BeforeEach
        void beforeeach()
        {
            layers = GenLayer.initlayers();
        }
        @Nested
        @DisplayName("Layerinit")
        class layerinit{

            @Test
            @DisplayName("initlayers isn't empty")
            void notempty()
            {
                assertTrue(layers.length !=0);
            }
            @Test
            @DisplayName("initlayers contains 3 layers")
            void layercount()
            {

                assertEquals(2,layers.length);
            }

            @Test
            @DisplayName("Layers array contains layers")
            void layertype()
            {

                for(GenLayer layer :layers)
                    assertTrue(layer != null);

            }
        }

        @Nested
        @DisplayName("getInts test")
        class getInts
        {
            @Test
            @DisplayName("all values are greater than -1")
            void notMinusOne()
            {
                for(GenLayer layer : layers)
                {
                    int[] ints = layer.getInts(0,0,16,16);
                    for(int i :ints)
                    {
                        assertTrue(i>-1);
                    }
                }
            }
            @Test
            @DisplayName("all values are smaller than biomeCount")
            void notGreaterBiomeCount()
            {
                for(GenLayer layer : layers)
                {
                    int[] ints = layer.getInts(0,0,16,16);
                    for(int i :ints)
                    {
                        assertTrue(i<biomecount);
                    }
                }
            }

            @Test
            @DisplayName("the array is not null")
            void notNull()
            {
                for(GenLayer layer : layers)
                {
                    int[] ints = layer.getInts(0,0,16,16);
                    assertNotNull(ints);
                }
            }
            @Test
            @DisplayName("the array is not empty")
            void arrayNotEMpty()
            {
                for(GenLayer layer : layers)
                {
                    int[] ints = layer.getInts(0,0,16,16);
                    assertTrue(ints.length>0);
                }
            }
        }

    }

}
