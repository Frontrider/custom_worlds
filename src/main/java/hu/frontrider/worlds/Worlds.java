package hu.frontrider.worlds;

import hu.frontrider.worlds.registry.BiomeRegistry;
import hu.frontrider.worlds.registry.DimensionRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = Worlds.MODID, name = Worlds.NAME, version = Worlds.VERSION)
public class Worlds
{
    public static final String MODID = "custom_worlds";
    public static final String NAME = "Custom Worlds";
    public static final String VERSION = "1.0";

    public static File configdir;
    public static Logger modLog;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        modLog= event.getModLog();
        configdir = new File(event.getModConfigurationDirectory(),"/worlds");
        if(!configdir.exists())
            configdir.mkdir();
        BiomeRegistry.preinit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        DimensionRegistry.init(event);
    }

    @EventHandler
    public static void onRegisterBiomes(RegistryEvent.Register<Biome> event)
    {
        modLog.debug("registering biomes");
        event.getRegistry().registerAll(BiomeRegistry.biomes);
    }
}
