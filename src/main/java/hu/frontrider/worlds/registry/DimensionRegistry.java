package hu.frontrider.worlds.registry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hu.frontrider.worlds.Worlds;
import hu.frontrider.worlds.config.DimensionHolder;
import hu.frontrider.worlds.dimension.WorldProvider;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Registering custom dimensions from config
 */
public class DimensionRegistry {

    public static HashMap<Integer,DimensionHolder> dimensionmap = new HashMap<>();

    public static void init(FMLInitializationEvent event)
    {
        File config = new File(Worlds.configdir,"dimensions/");
        //System.out.println("dimension config directory: "+config.getAbsolutePath());

        if(!config.exists())
            config.mkdir();
        try {
            //System.out.println(Arrays.toString(config.listFiles()));
            File[] files = config.listFiles((dir, name) -> name.contains(".json"));
            assert files != null;
            //System.out.println("dimension file count: "+files.length);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            for (File file : files) {
               // System.out.println(file.getName());
                InputStreamReader reader = new InputStreamReader(new FileInputStream(file));

                DimensionHolder dimensionHolder = gson.fromJson(reader, DimensionHolder.class);
                reader.close();
                if (dimensionHolder.id == -1) {
                    dimensionHolder.id = DimensionManager.getNextFreeDimId();
                    String json = gson.toJson(dimensionHolder);

                    PrintStream printStream = new PrintStream(file);
                    printStream.print(json);
                    printStream.close();

                }
                dimensionmap.put(dimensionHolder.id,dimensionHolder);
                DimensionType dimtype = DimensionType.register(Worlds.MODID + "_" + dimensionHolder.dimensiontype,
                        "_" + dimensionHolder.dimensiontype,
                        dimensionHolder.id, WorldProvider.class, false);
                DimensionManager.registerDimension(dimensionHolder.id, dimtype);
            }

        }catch (Exception e)
        {
            System.out.println("failed to load dimension");
            //e.printStackTrace();
        }
    }
}
