package fuzs.thinair.core;

import dev.emi.trinkets.api.TrinketsApi;
import fuzs.puzzleslib.api.core.v1.ModLoaderEnvironment;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

public class FabricAbstractions implements CommonAbstractions {

    @Override
    public Optional<ItemStack> findEquippedItem(LivingEntity entity, TagKey<Item> tagKey) {
        if (ModLoaderEnvironment.INSTANCE.isModLoaded("trinkets")) {
            return TrinketsApi.getTrinketComponent(entity).flatMap(component -> component.getEquipped(itemStack -> itemStack.is(tagKey))
                    .stream().findFirst().map(Tuple::getB));
        } else {
            return CommonAbstractions.super.findEquippedItem(entity, tagKey);
        }
    }
}
