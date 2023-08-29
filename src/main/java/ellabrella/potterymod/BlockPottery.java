package ellabrella.potterymod;

import net.minecraft.core.block.BlockTileEntity;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.world.World;

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

    public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {

        TileEntityPottery pot = (TileEntityPottery)world.getBlockTileEntity(x, y, z);
        boolean[][][] voxels = new boolean[16][16][16];

        for (int potX = 0; potX < 16; potX++) {
            for (int potY = 0; potY < 16; potY++) {
                for (int potZ = 0; potZ < 16; potZ++) {
                    int rand = (int)(Math.random() * 10 + 1);
                    if (rand == 10)
                        voxels[potX][potY][potZ] = true;
                }
            }
        }

        pot.setVoxels(voxels);

        return true;

    }
}
