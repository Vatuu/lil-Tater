package dev.vatuu.liltater.entity;

import dev.vatuu.liltater.client.entityrenderer.HmpfEntityRenderer;
import dev.vatuu.liltater.client.entityrenderer.UwotterEntityRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public final class Entities {

    public static void init() {
        UwotterEntity.register();
        HmpfEntity.register();
    }

    @Environment(EnvType.CLIENT)
    public static void initRenderer() {
        UwotterEntityRenderer.register();
        HmpfEntityRenderer.register();
    }
}
