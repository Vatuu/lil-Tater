package dev.vatuu.liltater.item;

import dev.vatuu.liltater.block.IrritaterBlock;
import dev.vatuu.liltater.block.LilTaterBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum TaterArmorMaterials implements ArmorMaterial {
    TATER("tater", 15, new int[]{1, 3, 5, 2}, 25, () -> {
        return Ingredient.ofItems(LilTaterBlock.ITEM);
    }),
    IRRITATER("irritater", 7, new int[]{2, 5, 6, 2}, 9, () -> {
        return Ingredient.ofItems(IrritaterBlock.ITEM);
    });

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredientSupplier;

    private TaterArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, Supplier<Ingredient> ingredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.repairIngredientSupplier = new Lazy(ingredientSupplier);
    }

    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Environment(EnvType.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return 0.0F;
    }
}
