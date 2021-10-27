package lilypuree.decapitation.mixin;

import lilypuree.decapitation.HasHead;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(QuadrupedModel.class)
public abstract class QuadrupedModelMixin<T extends Entity> {
    
    @Shadow
    @Final
    protected ModelPart head;
    
    @Inject(method = "setupAnim", at = @At("HEAD"))
    public void onSetupAnim(T entity, float param1, float param2, float param3, float param4, float param5, CallbackInfo ci) {
        
        if(entity instanceof HasHead headEntity) {
            boolean headless = headEntity.isHeadless();
            if(headless) {
                head.visible = false;
            } else {
                head.visible = true;
            }
        }
    }
    
}
