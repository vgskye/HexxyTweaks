package vg.skye.silicate.mixin;

import at.petrak.hexcasting.api.spell.math.HexPattern;
import at.petrak.hexcasting.client.be.BlockEntitySlateRenderer;
import at.petrak.hexcasting.common.blocks.circles.BlockEntitySlate;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import vg.skye.silicate.pattern_renderer.PatternTextureManager;

@Mixin(BlockEntitySlateRenderer.class)
public class BlockEntitySlateRendererMixin {
	/**
	 * @author Skye
	 * @reason why not
	 */
	@Overwrite
	public void render(BlockEntitySlate tile, float pPartialTick, MatrixStack ps,
					   VertexConsumerProvider buffer, int light, int overlay) {
		if (tile.pattern == null) {
			return;
		}

		var bs = tile.getCachedState();
		PatternTextureManager.INSTANCE.renderPatternForSlate(tile, tile.pattern, ps, buffer, light, bs);
	}
}
