package hu.frontrider.worlds.registry;

import com.google.gson.Gson;
import hu.frontrider.worlds.Worlds;
import hu.frontrider.worlds.biome.CustomBiome;
import hu.frontrider.worlds.biome.ExtendedBiomeProperties;
import hu.frontrider.worlds.config.BiomeConfigHolder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * Class to register all the biomes. Not written by hand, generated via the BuildBiomeRegistry class, in the generator folder
 * None of the biomes are registered in any dictionary, they intended to be customized in a way that they look like they are
 */

@SuppressWarnings("ConstantConditions")
public class BiomeRegistry {
/**
*Variable to hold the count of the registered biomes.
*/
 public static final int biomeCount = 16;


    /**
     * Event subscriber, handling the actual registry event
     */
    public static CustomBiome[] biomes;

    public static void preinit(FMLPreInitializationEvent event){
        File config = new File(Worlds.configdir,"/biomes");

        if(!config.exists())
            config.mkdir();
        try {
            File[] files = config.listFiles((dir, name) -> name.contains(".json"));
            Gson gson = new Gson();
            BiomeConfigHolder[] configHolder = new BiomeConfigHolder[files.length];
            for (int i = 0; i < files.length; i++) {
                try {
                    InputStreamReader reader = new InputStreamReader(new FileInputStream(files[i]));
                    configHolder[i] = gson.fromJson(reader, BiomeConfigHolder.class);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            for(int i = 0; i < files.length; i++)
            {
                biomes[i] = new CustomBiome(new ExtendedBiomeProperties(configHolder[i]));
            }
        }catch (Exception e)
        {
            //e.printStackTrace();
        }

    }


}