package dev.vatuu.liltater.entity;

import dev.vatuu.liltater.LilTater;
import dev.vatuu.liltater.block.IrritaterBlock;
import dev.vatuu.liltater.block.LilTaterBlock;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class UwotterEntity extends MobEntity {

    public static EntityType<UwotterEntity> TYPE;
    public static Item SPAWN_EGG;

    private static final Ingredient BREEDING_INGREDIENT = Ingredient.ofItems(LilTaterBlock.ITEM, IrritaterBlock.ITEM);


    public UwotterEntity(EntityType<UwotterEntity> type, World w) {
        super(type, w);
    }

    public UwotterEntity(World w) {
        this(TYPE, w);
    }

    public void writeCustomDataToTag(CompoundTag tag) {
        super.writeCustomDataToTag(tag);
    }

    public void readCustomDataFromTag(CompoundTag tag) {
        super.readCustomDataFromTag(tag);
    }

    public UwotterEntity createChild(PassiveEntity e) {
        return TYPE.create(this.world);
    }

    public boolean isBreedingItem(ItemStack stack) {
        return BREEDING_INGREDIENT.test(stack);
    }

    public boolean canSpawn(WorldView world) {
        return world.intersectsEntities(this);
    }

    @Override
    public void tick() {
        super.tick();
    }

    public static void register() {
        TYPE = Registry.register(Registry.ENTITY_TYPE, new Identifier(LilTater.MOD_ID, "uwotter"), FabricEntityTypeBuilder.create(EntityCategory.CREATURE, (EntityType.EntityFactory<UwotterEntity>) UwotterEntity::new)
                .size(new EntityDimensions(2, 2, false))
                .build());
        SPAWN_EGG = Registry.register(Registry.ITEM, new Identifier(LilTater.MOD_ID, "uwotter_egg"), new SpawnEggItem(TYPE, 0x00000, 0xFFFFFF, new Item.Settings().group(LilTater.GROUP)));
    }
}
