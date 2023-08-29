package ellabrella.potterymod;

import com.mojang.nbt.CompoundTag;
import net.minecraft.core.block.entity.TileEntity;

public class TileEntityPottery extends TileEntity {

    private boolean[][][] voxels = new boolean[16][16][16];

    public boolean[][][] getVoxels() {
        return voxels;
    }

    public void setVoxels(boolean[][][] voxels) {
        this.voxels = voxels;
    }

    public byte[] getVoxelsAsByteArray() {return new byte[512];}
    public void setVoxelsFromByteArray(byte[] byteArray) {
    }

    @Override
    public void writeToNBT(CompoundTag nbttagcompound) {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.putByteArray("voxels", getVoxelsAsByteArray());
    }

    @Override
    public void readFromNBT(CompoundTag nbttagcompound) {
        super.readFromNBT(nbttagcompound);
        setVoxelsFromByteArray(nbttagcompound.getByteArray("voxels"));
    }

}
