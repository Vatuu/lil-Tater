package dev.vatuu.liltater.client.entityrenderer;

import dev.vatuu.liltater.LilTater;
import dev.vatuu.liltater.entity.UwotterEntity;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class UwotterEntityRenderer extends MobEntityRenderer<UwotterEntity, UwotterEntityModel> {

    private static final Identifier TEXTURE = new Identifier(LilTater.MOD_ID, "textures/entity/uwotter.png");

    public UwotterEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new UwotterEntityModel(), 0.5F);
    }

    public Identifier getTexture(UwotterEntity e) {
        return TEXTURE;
    }


    public static void register() {
        EntityRendererRegistry.INSTANCE.register(UwotterEntity.TYPE, (d, ctx) -> new UwotterEntityRenderer(d));
    }
}
