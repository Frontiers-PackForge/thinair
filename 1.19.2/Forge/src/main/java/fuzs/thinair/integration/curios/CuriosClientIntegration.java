package fuzs.thinair.integration.curios;

import com.mojang.blaze3d.vertex.PoseStack;
import fuzs.thinair.client.renderer.entity.layers.RespiratorRenderer;
import fuzs.thinair.init.ModRegistry;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class CuriosClientIntegration {
    
    public static void registerCuriosRenderer() {
        CuriosRendererRegistry.register(ModRegistry.RESPIRATOR_ITEM.get(), () -> new ICurioRenderer() {

            @Override
            public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack matrixStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
                RespiratorRenderer.get().render(stack, matrixStack, renderLayerParent.getModel(), renderTypeBuffer, light, RenderType::armorCutoutNoCull);
            }
        });
    }
}
