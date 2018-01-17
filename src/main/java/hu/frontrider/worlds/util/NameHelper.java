package hu.frontrider.worlds.util;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

public class NameHelper {

    public static IBlockState getBlockFromName(String name,int meta)
    {
        ResourceLocation resourcelocation = new ResourceLocation(name);
        if (Block.REGISTRY.containsKey(resourcelocation)) {
            return Block.REGISTRY.getObject(resourcelocation).getStateFromMeta(meta);
        }
        return Blocks.AIR.getDefaultState();
    }
}
