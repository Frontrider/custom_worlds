package hu.frontrider.worlds.config;

/**
 *
 */
public class BiomeConfigHolder {
    public SpawnableHolder[] hostile;
    public SpawnableHolder[] animal;
    public SpawnableHolder[] water;
    public SpawnableHolder[] ambient;
    public float baseHeight =1;
    public float heightVariation =1;
    public boolean raindisabled =false;
    public boolean snowenabled =false;
    public ColorHolder watercolor;
    public float tempature =1;
    public ColorHolder skycolor;
    public BlockHolder surface;
    public BlockHolder filler;
    public String name ="default";
}
