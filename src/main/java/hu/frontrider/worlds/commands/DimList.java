package hu.frontrider.worlds.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;

/**
 * Created by frontrider on 2018.01.15..
 */
public class DimList extends CommandBase {
    @Override
    public String getName() {
        return "dimlist";
    }

    @Override
    public String getUsage(ICommandSender iCommandSender) {
        return "";
    }

    @Override
    public void execute(MinecraftServer minecraftServer, ICommandSender iCommandSender, String[] strings) throws CommandException {
        WorldServer[] worlds = minecraftServer.worlds;


        iCommandSender.sendMessage(new TextComponentString("Found "+worlds.length+" worlds"));
        for(WorldServer world :worlds)
        {
            WorldProvider wp= world.provider;
            String name = wp.getDimensionType().getName();
            int dimension = wp.getDimension();

            iCommandSender.sendMessage(new TextComponentString(name+":"+dimension));
        }
    }
}
