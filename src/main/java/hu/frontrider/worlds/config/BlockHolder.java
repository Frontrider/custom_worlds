package hu.frontrider.worlds.config;

import hu.frontrider.worlds.util.NameHelper;
import net.minecraft.block.state.IBlockState;

/**
 * Created by frontrider on 2018.01.13..
 */
public class BlockHolder {
    String blockname = "minecraft:stone";
    int meta = 0;
    public BlockHolder()
    {}
    public BlockHolder(String name)
    {
        blockname = name;
    }
    public BlockHolder(String modid,String name)
    {
        blockname = modid+":"+name;
    }
    public BlockHolder(String name,int meta)
    {
        blockname = name;
        this.meta = meta;
    }
    public BlockHolder(String modid,String name,int meta)
    {
        blockname = modid+":"+name;
        this.meta = meta;
    }

    public IBlockState getBlock()
    {
        return NameHelper.getBlockFromName(blockname,meta);
    }
}
