package ellabrella.potterymod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.sound.block.BlockSound;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;


public class PotteryMod implements ModInitializer {
    public static final String MOD_ID = "potterymod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Blocks
    public static final Block unfiredPottery = new BlockBuilder(MOD_ID)
            .setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.0f))
            .build(new BlockPottery("pottery.unfired", 1000, Material.clay));

    @Override
    public void onInitialize() {

        // Tile entities
        EntityHelper.createSpecialTileEntity(TileEntityPottery.class, new TileEntityRendererPottery(), "Pottery");

        LOGGER.info("PotteryMod initialized.");
    }
}
