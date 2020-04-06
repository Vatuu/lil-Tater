package dev.vatuu.liltater.client.entityrenderer;

import com.google.common.collect.ImmutableList;
import dev.vatuu.liltater.entity.HmpfEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.CompositeEntityModel;

public class HmpfEntityModel extends CompositeEntityModel<HmpfEntity> {

    private final ModelPart tater;

    public HmpfEntityModel() {
        this.textureHeight = this.textureWidth = 16;
        this.tater = new ModelPart(this, 0, 0);
        this.tater.addCuboid(0, 0, 0, 4, 2, 4);
    }

    public void setAngles(HmpfEntity hmpf, float f, float g, float h, float i, float j) {
    }

    public Iterable<ModelPart> getParts() {
        return ImmutableList.of(this.tater);
    }
}
