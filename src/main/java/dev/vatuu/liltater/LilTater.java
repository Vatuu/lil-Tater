package dev.vatuu.liltater;

import dev.vatuu.liltater.block.Blocks;
import dev.vatuu.liltater.block.LilTaterBlock;
import dev.vatuu.liltater.entity.Entities;
import dev.vatuu.liltater.item.Items;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class LilTater implements ModInitializer {

    public static final String MOD_ID = "lil_tater";

    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "group"), () -> new ItemStack(LilTaterBlock.ITEM));

    @Override
    public void onInitialize() {
        Blocks.init();
        Entities.init();
        Items.init();
    }
}
