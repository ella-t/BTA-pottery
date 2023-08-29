package ellabrella.potterymod;

import net.minecraft.core.block.BlockTileEntity;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;

public class BlockPottery extends BlockTileEntity {
    public BlockPottery(String key, int id, Material material) {
        super(key, id, material);
    }

    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntityPottery();
    }

    public boolean renderAsNormalBlock() {return false;}

    public boolean isOpaqueCube() {return false;}
}
