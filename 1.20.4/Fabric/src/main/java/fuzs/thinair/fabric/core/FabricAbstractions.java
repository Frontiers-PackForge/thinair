package fuzs.thinair.fabric.core;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import fuzs.puzzleslib.api.core.v1.ModLoaderEnvironment;
import fuzs.thinair.core.CommonAbstractions;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

public class FabricAbstractions implements CommonAbstractions {

    @Override
    public ItemStack findEquippedItem(LivingEntity entity, TagKey<Item> tagKey) {
        if (ModLoaderEnvironment.INSTANCE.isModLoaded("trinkets")) {
            return TrinketsApi.getTrinketComponent(entity).flatMap(component -> component.getEquipped(itemStack -> itemStack.is(tagKey))
                    .stream().findFirst().map(Tuple::getB))
                    .orElseGet(() -> CommonAbstractions.super.findEquippedItem(entity, tagKey));
        } else {
            return CommonAbstractions.super.findEquippedItem(entity, tagKey);
        }
    }
}
