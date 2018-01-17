package hu.frontrider.worlds.config;

/**
 *
 */
public class BiomeConfigHolder {
    public SpawnableHolder[] hostile_mobs;
    public SpawnableHolder[] animal_mobs;
    public SpawnableHolder[] water_mobs;
    public SpawnableHolder[] ambient_mobs;
    public float baseHeight =1;
    public float heightVariation =1;
    public boolean raindisabled =false;
    public boolean snowenabled =false;
    public ColorHolder watercolor;
    public float temperature =1;
    public ColorHolder skycolor;
    public BlockHolder surface;
    public BlockHolder filler;
    public String name ="default";
}
