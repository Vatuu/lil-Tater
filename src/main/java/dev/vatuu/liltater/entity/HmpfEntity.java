package dev.vatuu.liltater.entity;

import dev.vatuu.liltater.LilTater;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class HmpfEntity extends HostileEntity {

    public static EntityType<HmpfEntity> TYPE;
    public static Item SPAWN_EGG;

    public HmpfEntity(EntityType<HmpfEntity> type, World w) {
        super(type, w);
    }

    public HmpfEntity(World w) {
        super(TYPE, w);
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
        this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(2.0D);
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(2.0D);
    }

    public static void register() {
        TYPE = Registry.register(Registry.ENTITY_TYPE, new Identifier(LilTater.MOD_ID, "hmpf"), FabricEntityTypeBuilder.create(EntityCategory.MONSTER, (EntityType.EntityFactory<HmpfEntity>) HmpfEntity::new)
                .size(new EntityDimensions(0.325F, 0.15F, true))
                .build());
        SPAWN_EGG = Registry.register(Registry.ITEM, new Identifier(LilTater.MOD_ID, "hmpf_egg"), new SpawnEggItem(TYPE, 0x00000, 0xFFFFFF, new Item.Settings().group(LilTater.GROUP)));

    }
}
