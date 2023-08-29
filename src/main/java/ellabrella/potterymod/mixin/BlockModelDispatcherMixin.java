package ellabrella.potterymod.mixin;

import ellabrella.potterymod.PotteryMod;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.BlockModelRenderBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = BlockModelDispatcher.class, remap = false)
public class BlockModelDispatcherMixin {

    @Inject(at = @At("TAIL"), method = "<init>()V")
    private void BlockModelsInit(CallbackInfo info) {
        ((BlockModelDispatcher)(Object)this).addDispatch(PotteryMod.unfiredPottery, new BlockModelRenderBlocks(-1));
    }

}
