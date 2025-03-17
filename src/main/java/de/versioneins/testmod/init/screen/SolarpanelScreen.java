package de.versioneins.testmod.init.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import de.versioneins.testmod.init.Main;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class SolarpanelScreen extends AbstractContainerScreen<SolarpanelMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Main.MODID, "textures/gui/solarpanel.png");
    public SolarpanelScreen(SolarpanelMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        //holt sich die x und y positionen wo man grade mit der maus ist
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
    // erstellt die gui grafik in der mitte vom screen
        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            //definiert welche grafik man benutzt und wo plus offset menu.getScaledProgress bedeutet wie viel wir von dem pfeil zeichen (genau so viel wie weit der prozess ist )
            guiGraphics.blit(TEXTURE, x + 85, y + 30, 176, 0, 8, menu.getScaledProgress());
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
