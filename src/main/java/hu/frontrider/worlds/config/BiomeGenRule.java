package hu.frontrider.worlds.config;

public class BiomeGenRule {

    BiomeHolder[] biomes=new BiomeHolder[] {new BiomeHolder(),new BiomeHolder("minecraft:extreme_hills"),new BiomeHolder("minecraft:forest")};
    BiomeHolder[] ocean=new BiomeHolder[] {new BiomeHolder("minecraft:ocean")};
    BiomeHolder[] beach = new BiomeHolder[] {new BiomeHolder("minecraft:beach")};
    BiomeHolder[] river = new BiomeHolder[] {new BiomeHolder("minecraft:river")};

    boolean ignoreTempatures = false;
    boolean largeOceans = false;
    class BiomeHolder{

        String name ="minecraft:plains";
        int chance=1; //biome spawn chance
        int order=0; //extra information, order in the biome array. will be set automatically

        BiomeHolder(String biome)
        {
            name = biome;
        }
        BiomeHolder()
        {}
    }
}
