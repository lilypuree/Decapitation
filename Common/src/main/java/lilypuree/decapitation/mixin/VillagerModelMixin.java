package lilypuree.decapitation.mixin;

import lilypuree.decapitation.HasHead;
import net.minecraft.client.model.VillagerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VillagerModel.class)
public abstract class VillagerModelMixin<T extends Entity> {
    
    @Shadow
    @Final
    private ModelPart head;
    
    @Shadow
    @Final
    private ModelPart hat;
    
    @Shadow
    @Final
    private ModelPart hatRim;
    
    @Shadow
    @Final
    protected ModelPart nose;
    
    @Inject(method = "setupAnim", at = @At("HEAD"))
    public void onSetupAnim(T entity, float param1, float param2, float param3, float param4, float param5, CallbackInfo ci) {
        if(entity instanceof HasHead headEntity) {
            boolean headless = headEntity.isHeadless();
            if(headless) {
                head.visible = false;
                hat.visible = false;
                hatRim.visible = false;
                nose.visible = false;
            } else {
                head.visible = true;
                hat.visible = true;
                hatRim.visible = true;
                nose.visible = true;
            }
        }
    }
    
}
