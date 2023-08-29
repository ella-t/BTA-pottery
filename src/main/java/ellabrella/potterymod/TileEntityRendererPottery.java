package ellabrella.potterymod;

import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.tileentity.TileEntityRenderer;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererPottery extends TileEntityRenderer<TileEntityPottery> {
    @Override
    public void doRender(TileEntityPottery tileEntity, double x, double y, double z, float renderPartialTicks) {

        Cube[][][] cubes = new Cube[16][16][16];
        this.loadTexture("blocks/clay.png");
        boolean[][][] potArray = tileEntity.getVoxels();

        for(int potX = 0; potX < 16; potX++) {
            for (int potY = 0; potY < 16; potY++) {
                for (int potZ = 0; potZ < 16; potZ++) {

                    if (potArray[potX][potY][potZ]) {

                        cubes[potX][potY][potZ] = new Cube(potX, potZ);
                        cubes[potX][potY][potZ].addBox(potX, potY, potZ, 1, 1, 1);

                    }

                }
            }
        }

        GL11.glPushMatrix();

        GL11.glTranslated(x, y, z);

        for(int rX = 0; rX < 16; rX++) {
            for (int rY = 0; rY < 16; rY++) {
                for (int rZ = 0; rZ < 16; rZ++) {

                    if (potArray[rX][rY][rZ]) {

                        cubes[rX][rY][rZ].render(1.0f / 16.0f);

                    }

                }
            }
        }

        GL11.glPopMatrix();

    }
}
