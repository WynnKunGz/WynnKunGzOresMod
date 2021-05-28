package com.wynnkungz.wkom.client.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.wynnkungz.wkom.WynnkungzOresMod;
import com.wynnkungz.wkom.common.container.AlloySmelterContainer;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AlloySmelterScreen extends ContainerScreen<AlloySmelterContainer>{

	private static final ResourceLocation DISPLAY_CASE_GUI = new ResourceLocation(WynnkungzOresMod.MOD_ID, "textures/gui/display_case.png");
	
	public AlloySmelterScreen(AlloySmelterContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
		
		this.guiLeft = 0;
		this.guiTop = 0;
		this.xSize = 175;
		this.ySize = 165;
	}

	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(matrixStack);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
		this.font.func_243248_b(matrixStack, this.playerInventory.getDisplayName(), (float) this.playerInventoryTitleX, 
				(float) this.playerInventoryTitleY, 4210752);
		this.font.func_243248_b(matrixStack, this.getTitle(), (float) 6, (float) 7, 4210752);
		this.minecraft.textureManager.bindTexture(DISPLAY_CASE_GUI);
		//checks whether the alloySmelter is Lit or not
		if(container.isPowered()){
			//draws the lit flame at 39(x) and 36(y)
			blit(matrixStack, 39, 36, 176, 0, 14,14);
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.color4f(1f, 1f, 1f, 1f);
		this.minecraft.textureManager.bindTexture(DISPLAY_CASE_GUI);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.blit(matrixStack, x, y, 0, 0, this.xSize, this.ySize);
	}
	
}
