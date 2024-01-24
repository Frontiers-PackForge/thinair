package fuzs.thinair.core;

import fuzs.puzzleslib.api.core.v1.ServiceProviderHelper;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public interface CommonAbstractions {
    CommonAbstractions INSTANCE = ServiceProviderHelper.load(CommonAbstractions.class);

    default ItemStack findEquippedItem(LivingEntity entity, TagKey<Item> tagKey) {
        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            if (equipmentSlot != EquipmentSlot.MAINHAND) {
                ItemStack itemStack = entity.getItemBySlot(equipmentSlot);
                if (itemStack.is(tagKey) && Mob.getEquipmentSlotForItem(itemStack) == equipmentSlot) {
                    return itemStack;
                }
            }
        }
        return ItemStack.EMPTY;
    }
}
