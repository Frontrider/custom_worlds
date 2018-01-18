package hu.frontrider.worlds.config;

/**
 *
 */
public class BiomeConfigHolder {
    public SpawnableHolder[] hostile_mobs = new SpawnableHolder[] {new SpawnableHolder()};
    public SpawnableHolder[] animal_mobs = new SpawnableHolder[] {new SpawnableHolder()};
    public SpawnableHolder[] water_mobs = new SpawnableHolder[] {new SpawnableHolder()};
    public SpawnableHolder[] ambient_mobs = new SpawnableHolder[] {new SpawnableHolder()};
    public float baseHeight =1;
    public float heightVariation =1;
    public boolean raindisabled =false;
    public boolean snowenabled =false;
    public ColorHolder watercolor = new ColorHolder();
    public float temperature =1;
    public ColorHolder skycolor;
    public BlockHolder surface = new BlockHolder();
    public BlockHolder filler = new BlockHolder();
    public String name ="default";
}
