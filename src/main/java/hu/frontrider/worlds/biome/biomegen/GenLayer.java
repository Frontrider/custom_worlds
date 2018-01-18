package hu.frontrider.worlds.biome.biomegen;

public abstract class GenLayer extends net.minecraft.world.gen.layer.GenLayer{


    public GenLayer(long p_i2125_1_) {
        super(p_i2125_1_);
    }

    public static GenLayer[] initlayers()
    {
        return new GenLayer[] {null, null,null};
    }


    public void initWorldGenSeed(long p_initWorldGenSeed_1_) {
        this.worldGenSeed = p_initWorldGenSeed_1_;
        if (this.parent != null) {
            this.parent.initWorldGenSeed(p_initWorldGenSeed_1_);
        }

        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
    }

    public void initChunkSeed(long p_initChunkSeed_1_, long p_initChunkSeed_3_) {
        this.chunkSeed = this.worldGenSeed;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += p_initChunkSeed_1_;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += p_initChunkSeed_3_;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += p_initChunkSeed_1_;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += p_initChunkSeed_3_;
    }

    protected int nextInt(int p_nextInt_1_) {
        int i = (int)((this.chunkSeed >> 24) % (long)p_nextInt_1_);
        if (i < 0) {
            i += p_nextInt_1_;
        }

        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += this.worldGenSeed;
        return i;
    }

    public abstract int[] getInts(int var1, int var2, int var3, int var4);


    protected static boolean isBiomeOceanic(int p_isBiomeOceanic_0_) {
        return false;
    }

    protected long nextLong(long p_nextLong_1_) {
        long j = (this.chunkSeed >> 24) % p_nextLong_1_;
        if (j < 0L) {
            j += p_nextLong_1_;
        }

        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += this.worldGenSeed;
        return j;
    }

    protected int selectRandom(int... p_selectRandom_1_) {
        return p_selectRandom_1_[this.nextInt(p_selectRandom_1_.length)];
    }

    protected int selectModeOrRandom(int p_selectModeOrRandom_1_, int p_selectModeOrRandom_2_, int p_selectModeOrRandom_3_, int p_selectModeOrRandom_4_) {
        if (p_selectModeOrRandom_2_ == p_selectModeOrRandom_3_ && p_selectModeOrRandom_3_ == p_selectModeOrRandom_4_) {
            return p_selectModeOrRandom_2_;
        } else if (p_selectModeOrRandom_1_ == p_selectModeOrRandom_2_ && p_selectModeOrRandom_1_ == p_selectModeOrRandom_3_) {
            return p_selectModeOrRandom_1_;
        } else if (p_selectModeOrRandom_1_ == p_selectModeOrRandom_2_ && p_selectModeOrRandom_1_ == p_selectModeOrRandom_4_) {
            return p_selectModeOrRandom_1_;
        } else if (p_selectModeOrRandom_1_ == p_selectModeOrRandom_3_ && p_selectModeOrRandom_1_ == p_selectModeOrRandom_4_) {
            return p_selectModeOrRandom_1_;
        } else if (p_selectModeOrRandom_1_ == p_selectModeOrRandom_2_ && p_selectModeOrRandom_3_ != p_selectModeOrRandom_4_) {
            return p_selectModeOrRandom_1_;
        } else if (p_selectModeOrRandom_1_ == p_selectModeOrRandom_3_ && p_selectModeOrRandom_2_ != p_selectModeOrRandom_4_) {
            return p_selectModeOrRandom_1_;
        } else if (p_selectModeOrRandom_1_ == p_selectModeOrRandom_4_ && p_selectModeOrRandom_2_ != p_selectModeOrRandom_3_) {
            return p_selectModeOrRandom_1_;
        } else if (p_selectModeOrRandom_2_ == p_selectModeOrRandom_3_ && p_selectModeOrRandom_1_ != p_selectModeOrRandom_4_) {
            return p_selectModeOrRandom_2_;
        } else if (p_selectModeOrRandom_2_ == p_selectModeOrRandom_4_ && p_selectModeOrRandom_1_ != p_selectModeOrRandom_3_) {
            return p_selectModeOrRandom_2_;
        } else {
            return p_selectModeOrRandom_3_ == p_selectModeOrRandom_4_ && p_selectModeOrRandom_1_ != p_selectModeOrRandom_2_ ? p_selectModeOrRandom_3_ : this.selectRandom(p_selectModeOrRandom_1_, p_selectModeOrRandom_2_, p_selectModeOrRandom_3_, p_selectModeOrRandom_4_);
        }
    }
}
