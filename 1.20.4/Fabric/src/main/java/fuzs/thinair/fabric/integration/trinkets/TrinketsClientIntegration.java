package fuzs.thinair.fabric.integration.trinkets;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import fuzs.thinair.client.renderer.entity.layers.RespiratorRenderer;
import fuzs.thinair.init.ModRegistry;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class TrinketsClientIntegration {

    public static void registerTrinketsRenderer() {
        TrinketRendererRegistry.registerRenderer(ModRegistry.RESPIRATOR_ITEM.value(), (ItemStack itemStack, SlotReference slotReference, EntityModel<? extends LivingEntity> entityModel, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, LivingEntity livingEntity, float v, float v1, float v2, float v3, float v4, float v5) -> {
            RespiratorRenderer.get().render(itemStack, poseStack, entityModel, multiBufferSource, i, RenderType::armorCutoutNoCull);
        });
    }
}
