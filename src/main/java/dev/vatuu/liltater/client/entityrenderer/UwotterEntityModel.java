package dev.vatuu.liltater.client.entityrenderer;

import com.google.common.collect.ImmutableList;
import dev.vatuu.liltater.entity.UwotterEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.CompositeEntityModel;
import net.minecraft.util.math.MathHelper;

public class UwotterEntityModel extends CompositeEntityModel<UwotterEntity> {

    private final ModelPart leg1;
    private final ModelPart leg2;
    private final ModelPart mainBody;
    private final ModelPart field_23356;
    private final ModelPart field_23357;
    private final ModelPart field_23358;
    private final ModelPart field_23359;
    private final ModelPart field_23360;
    private final ModelPart field_23361;

    public UwotterEntityModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.leg1 = new ModelPart(this, 0, 32);
        this.leg1.setPivot(-4.0F, 8.0F, 0.0F);
        this.leg1.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F, 0.0F);
        this.leg2 = new ModelPart(this, 0, 32);
        this.leg2.setPivot(4.0F, 8.0F, 0.0F);
        this.leg2.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F, 0.0F);
        this.mainBody = new ModelPart(this, 0, 0);
        this.mainBody.setPivot(0.0F, 1.0F, 0.0F);
        this.mainBody.addCuboid(-8.0F, -6.0F, -8.0F, 16.0F, 14.0F, 16.0F, 0.0F);
        this.field_23356 = new ModelPart(this, 16, 65);
        this.field_23356.setPivot(-8.0F, 4.0F, -8.0F);
        this.field_23356.addCuboid(-12.0F, 0.0F, 0.0F, 12.0F, 0.0F, 16.0F, 0.0F, true);
        this.method_26415(this.field_23356, 0.0F, 0.0F, -1.2217305F);
        this.field_23357 = new ModelPart(this, 16, 49);
        this.field_23357.setPivot(-8.0F, -1.0F, -8.0F);
        this.field_23357.addCuboid(-12.0F, 0.0F, 0.0F, 12.0F, 0.0F, 16.0F, 0.0F, true);
        this.method_26415(this.field_23357, 0.0F, 0.0F, -1.134464F);
        this.field_23358 = new ModelPart(this, 16, 33);
        this.field_23358.setPivot(-8.0F, -5.0F, -8.0F);
        this.field_23358.addCuboid(-12.0F, 0.0F, 0.0F, 12.0F, 0.0F, 16.0F, 0.0F, true);
        this.method_26415(this.field_23358, 0.0F, 0.0F, -0.87266463F);
        this.field_23359 = new ModelPart(this, 16, 33);
        this.field_23359.setPivot(8.0F, -6.0F, -8.0F);
        this.field_23359.addCuboid(0.0F, 0.0F, 0.0F, 12.0F, 0.0F, 16.0F, 0.0F);
        this.method_26415(this.field_23359, 0.0F, 0.0F, 0.87266463F);
        this.field_23360 = new ModelPart(this, 16, 49);
        this.field_23360.setPivot(8.0F, -2.0F, -8.0F);
        this.field_23360.addCuboid(0.0F, 0.0F, 0.0F, 12.0F, 0.0F, 16.0F, 0.0F);
        this.method_26415(this.field_23360, 0.0F, 0.0F, 1.134464F);
        this.field_23361 = new ModelPart(this, 16, 65);
        this.field_23361.setPivot(8.0F, 3.0F, -8.0F);
        this.field_23361.addCuboid(0.0F, 0.0F, 0.0F, 12.0F, 0.0F, 16.0F, 0.0F);
        this.method_26415(this.field_23361, 0.0F, 0.0F, 1.2217305F);
        this.mainBody.addChild(this.field_23356);
        this.mainBody.addChild(this.field_23357);
        this.mainBody.addChild(this.field_23358);
        this.mainBody.addChild(this.field_23359);
        this.mainBody.addChild(this.field_23360);
        this.mainBody.addChild(this.field_23361);
    }

    public void setAngles(UwotterEntity striderEntity, float f, float g, float h, float i, float j) {
        g = Math.min(0.25F, g);
        if (striderEntity.getPassengerList().size() <= 0) {
            this.mainBody.pitch = j * 0.017453292F;
            this.mainBody.yaw = i * 0.017453292F;
        } else {
            this.mainBody.pitch = 0.0F;
            this.mainBody.yaw = 0.0F;
        }

        float k = 1.5F;
        this.mainBody.roll = 0.1F * MathHelper.sin(f * 1.5F) * 4.0F * g;
        this.mainBody.pivotY = 2.0F;
        ModelPart var10000 = this.mainBody;
        var10000.pivotY -= 2.0F * MathHelper.cos(f * 1.5F) * 2.0F * g;
        this.leg2.pitch = MathHelper.sin(f * 1.5F * 0.5F) * 2.0F * g;
        this.leg1.pitch = MathHelper.sin(f * 1.5F * 0.5F + 3.1415927F) * 2.0F * g;
        this.leg2.roll = 0.17453292F * MathHelper.cos(f * 1.5F * 0.5F) * g;
        this.leg1.roll = 0.17453292F * MathHelper.cos(f * 1.5F * 0.5F + 3.1415927F) * g;
        this.leg2.pivotY = 8.0F + 2.0F * MathHelper.sin(f * 1.5F * 0.5F + 3.1415927F) * 2.0F * g;
        this.leg1.pivotY = 8.0F + 2.0F * MathHelper.sin(f * 1.5F * 0.5F) * 2.0F * g;
        this.field_23356.roll = -1.2217305F;
        this.field_23357.roll = -1.134464F;
        this.field_23358.roll = -0.87266463F;
        this.field_23359.roll = 0.87266463F;
        this.field_23360.roll = 1.134464F;
        this.field_23361.roll = 1.2217305F;
        float l = MathHelper.cos(f * 1.5F + 3.1415927F) * g;
        var10000 = this.field_23356;
        var10000.roll += l * 1.3F;
        var10000 = this.field_23357;
        var10000.roll += l * 1.2F;
        var10000 = this.field_23358;
        var10000.roll += l * 0.6F;
        var10000 = this.field_23359;
        var10000.roll += l * 0.6F;
        var10000 = this.field_23360;
        var10000.roll += l * 1.2F;
        var10000 = this.field_23361;
        var10000.roll += l * 1.3F;
        float m = 1.0F;
        float n = 1.0F;
        var10000 = this.field_23356;
        var10000.roll += 0.05F * MathHelper.sin(h * 1.0F * -0.4F);
        var10000 = this.field_23357;
        var10000.roll += 0.1F * MathHelper.sin(h * 1.0F * 0.2F);
        var10000 = this.field_23358;
        var10000.roll += 0.1F * MathHelper.sin(h * 1.0F * 0.4F);
        var10000 = this.field_23359;
        var10000.roll += 0.1F * MathHelper.sin(h * 1.0F * 0.4F);
        var10000 = this.field_23360;
        var10000.roll += 0.1F * MathHelper.sin(h * 1.0F * 0.2F);
        var10000 = this.field_23361;
        var10000.roll += 0.05F * MathHelper.sin(h * 1.0F * -0.4F);
    }

    public void method_26415(ModelPart modelPart, float f, float g, float h) {
        modelPart.pitch = f;
        modelPart.yaw = g;
        modelPart.roll = h;
    }

    public Iterable<ModelPart> getParts() {
        return ImmutableList.of(this.mainBody, this.leg2, this.leg1);
    }
}
