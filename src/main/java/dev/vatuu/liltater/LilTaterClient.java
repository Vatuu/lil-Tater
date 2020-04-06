package dev.vatuu.liltater;

import dev.vatuu.liltater.entity.Entities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class LilTaterClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Entities.initRenderer();
    }
}
