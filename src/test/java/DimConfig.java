import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hu.frontrider.worlds.config.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by frontrider on 2018.01.14..
 */
public class DimConfig {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        DimensionHolder holder = new DimensionHolder();
        holder.material = new BlockHolder();
        holder.fluid = new BlockHolder("minecraft:water");
        holder.biomes = new String[] {"minecraft:mesa"};
        Gson json =  new GsonBuilder().setPrettyPrinting().create();
        String print = json.toJson(holder);

        ShortHands.log(print);
        PrintWriter file = new PrintWriter("./dimconf.json","utf8");

        file.write(print);
        file.close();

        BiomeConfigHolder biomeConfigHolder = new BiomeConfigHolder();

        biomeConfigHolder.skycolor = new ColorHolder();
        biomeConfigHolder.watercolor = new ColorHolder();
        biomeConfigHolder.filler= new BlockHolder();
        biomeConfigHolder.surface= new BlockHolder();
        biomeConfigHolder.water = new SpawnableHolder[3];
        biomeConfigHolder.ambient = new SpawnableHolder[3];
        biomeConfigHolder.hostile = new SpawnableHolder[3];
        biomeConfigHolder.animal  = new SpawnableHolder[3];
        biomeConfigHolder.animal[0] = new SpawnableHolder();
        biomeConfigHolder.animal[1] = new SpawnableHolder();
        biomeConfigHolder.animal[2] = new SpawnableHolder();
        print = json.toJson(biomeConfigHolder);
        ShortHands.log(print);
        file = new PrintWriter("./biomeconf.json","utf8");

        file.write(print);
        file.close();



    }
}
