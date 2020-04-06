package dev.vatuu.liltater.client.entityrenderer;

import dev.vatuu.liltater.LilTater;
import dev.vatuu.liltater.entity.HmpfEntity;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class HmpfEntityRenderer extends MobEntityRenderer<HmpfEntity, HmpfEntityModel> {

    private static final Identifier TEXTURE = new Identifier(LilTater.MOD_ID, "textures/tater/irritater.png");

    public HmpfEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new HmpfEntityModel(), 0.25F);
    }

    public Identifier getTexture(HmpfEntity e) {
        return TEXTURE;
    }


    public static void register() {
        EntityRendererRegistry.INSTANCE.register(HmpfEntity.TYPE, (d, ctx) -> new HmpfEntityRenderer(d));
    }
}