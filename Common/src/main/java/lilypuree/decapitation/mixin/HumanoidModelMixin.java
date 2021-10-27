package lilypuree.decapitation.mixin;

import lilypuree.decapitation.Constants;
import lilypuree.decapitation.HasHead;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HumanoidModel.class)
public abstract class HumanoidModelMixin<T extends LivingEntity> extends AgeableListModel<T> {
    
    @Shadow
    @Final
    public ModelPart head;
    
    @Shadow
    @Final
    public ModelPart hat;
    
    @Inject(method = "setupAnim(Lnet/minecraft/world/entity/LivingEntity;FFFFF)V", at = @At("HEAD"))
    public void onSetupAnim(T entity, float param1, float param2, float param3, float param4, float param5, CallbackInfo ci) {
        
        if(entity instanceof HasHead headEntity) {
            boolean headless = headEntity.isHeadless();
            if(headless) {
                head.visible = false;
                hat.visible = false;
            } else {
                head.visible = true;
                hat.visible = true;
            }
        }
    }
    
}
