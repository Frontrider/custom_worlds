package hu.frontrider.worlds.registry;

import com.google.gson.Gson;
import hu.frontrider.worlds.Worlds;
import hu.frontrider.worlds.config.DimensionHolder;
import hu.frontrider.worlds.dimension.WorldProvider;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * Registering custom dimensions from config
 */
public class DimensionRegistry {

    public static DimensionType[] dimensionTypes;

    public static void init(FMLInitializationEvent event)
    {
        File config = new File(Worlds.configdir,"/dimensions");

        if(!config.exists())
            config.mkdir();
        try {
            File[] files = config.listFiles((dir, name) -> name.contains(".json"));
            Gson gson = new Gson();
            DimensionHolder[] configHolder = new DimensionHolder[files.length];
            for (int i = 0; i < files.length; i++) {
                try {
                    InputStreamReader reader = reader = new InputStreamReader(new FileInputStream(files[i]));
                    int id =DimensionManager.getNextFreeDimId();
                    DimensionHolder dimensionHolder = gson.fromJson(reader, DimensionHolder.class);
                    DimensionType dimtype = DimensionType.register(Worlds.MODID,
                            "_"+dimensionHolder.dimensiontype,
                            id, WorldProvider.class,false);
                    DimensionManager.registerDimension(id,dimtype);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }

        }catch (Exception e)
        {
            //e.printStackTrace();
        }
    }
}
