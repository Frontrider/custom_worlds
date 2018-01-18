package hu.frontrider.worlds;

import hu.frontrider.worlds.commands.*;
import hu.frontrider.worlds.registry.BiomeRegistry;
import hu.frontrider.worlds.registry.DimensionRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = Worlds.MODID, name = Worlds.NAME, version = Worlds.VERSION)
public class Worlds
{
    public static final String MODID = "custom_worlds";
    public static final String NAME = "Custom Worlds";
    public static final String VERSION = "0.3-SNAPSHOT";

    public static File configdir;
    public static Logger modLog;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        modLog= event.getModLog();

        System.out.println("Custom worlds does the pre initialization cycle");
        configdir = new File(event.getModConfigurationDirectory(),"/worlds");
        if(!configdir.exists())
            configdir.mkdir();
        System.out.println("Initializing biomes");

        BiomeRegistry.preinit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("Custom worlds initialising");
        DimensionRegistry.init(event);
    }

    @EventHandler
    public static void onRegisterBiomes(RegistryEvent.Register<Biome> event)
    {
        System.out.println("registering biomes");
        event.getRegistry().registerAll(BiomeRegistry.biomes);
    }
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {

        event.registerServerCommand(new DimList());
    }
}
