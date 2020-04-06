package dev.vatuu.liltater.item;

import dev.vatuu.liltater.LilTater;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class Items {

    public static Item ARMOR_TATER_HEAD;
    public static Item ARMOR_TATER_CHEST;
    public static Item ARMOR_TATER_LEGS;
    public static Item ARMOR_TATER_BOOTS;

    public static void init() {
        ARMOR_TATER_HEAD = Registry.register(Registry.ITEM,
                new Identifier(LilTater.MOD_ID, "tater_armor_head"),
                new ArmorItem(TaterArmorMaterials.TATER, EquipmentSlot.HEAD, new Item.Settings().group(LilTater.GROUP)));
        ARMOR_TATER_CHEST = Registry.register(Registry.ITEM,
                new Identifier(LilTater.MOD_ID, "tater_armor_chest"),
                new ArmorItem(TaterArmorMaterials.TATER, EquipmentSlot.CHEST, new Item.Settings().group(LilTater.GROUP)));
        ARMOR_TATER_LEGS = Registry.register(Registry.ITEM,
                new Identifier(LilTater.MOD_ID, "tater_armor_legs"),
                new ArmorItem(TaterArmorMaterials.TATER, EquipmentSlot.LEGS, new Item.Settings().group(LilTater.GROUP)));
        ARMOR_TATER_BOOTS = Registry.register(Registry.ITEM,
                new Identifier(LilTater.MOD_ID, "tater_armor_boots"),
                new ArmorItem(TaterArmorMaterials.TATER, EquipmentSlot.FEET, new Item.Settings().group(LilTater.GROUP)));
    }
}
