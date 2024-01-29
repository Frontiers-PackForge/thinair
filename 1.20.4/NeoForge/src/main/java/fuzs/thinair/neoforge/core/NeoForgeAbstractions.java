package fuzs.thinair.neoforge.core;

import fuzs.puzzleslib.api.core.v1.ModLoaderEnvironment;
import fuzs.thinair.core.CommonAbstractions;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.function.Function;

public class NeoForgeAbstractions implements CommonAbstractions {

    @Override
    public ItemStack findEquippedItem(LivingEntity entity, TagKey<Item> tagKey) {
        if (ModLoaderEnvironment.INSTANCE.isModLoaded("curios")) {
            return CuriosApi.getCuriosInventory(entity).map(capability -> capability.findFirstCurio(itemStack -> itemStack.is(tagKey)))
                    .flatMap(Function.identity())
                    .map(SlotResult::stack)
                    .orElseGet(() -> CommonAbstractions.super.findEquippedItem(entity, tagKey));
        } else {
            return CommonAbstractions.super.findEquippedItem(entity, tagKey);
        }
    }
}
