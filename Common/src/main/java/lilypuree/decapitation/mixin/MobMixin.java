package lilypuree.decapitation.mixin;

import com.mojang.datafixers.kinds.Const;
import lilypuree.decapitation.Constants;
import lilypuree.decapitation.HasHead;
import lilypuree.decapitation.MixinHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mob.class)
public abstract class MobMixin extends LivingEntity implements HasHead {
    private static final EntityDataAccessor<Boolean> HEADLESS = SynchedEntityData.defineId(Mob.class, EntityDataSerializers.BOOLEAN);
    
    protected MobMixin(EntityType<? extends LivingEntity> param0, Level param1) {
        
        super(param0, param1);
    }
    
    @Inject(method = "<init>", at = @At("RETURN"))
    private void onConstruction(EntityType<? extends Mob> entityType, Level level, CallbackInfo ci) {
    
        MixinHelper.setData(this, entityData, HEADLESS, level);
//        entityData.set(HEADLESS, canBeHeadless(entityType) && level.random.nextFloat() < Constants.HEADLESS_CHANCE);
    }
    
    @Inject(method = "defineSynchedData", at = @At("RETURN"))
    private void onDefineSyncedData(CallbackInfo ci) {
        entityData.define(HEADLESS, false);
    }
    
    @Inject(method = "addAdditionalSaveData", at = @At("RETURN"))
    private void onAddSaveData(CompoundTag tag, CallbackInfo ci) {
        
        if(isHeadless()) {
            tag.putBoolean("Headless", this.isHeadless());
        }
    }
    
    @Inject(method = "readAdditionalSaveData", at = @At("RETURN"))
    private void onReadSaveData(CompoundTag tag, CallbackInfo ci) {
        
        this.setHeadless(tag.getBoolean("Headless"));
    }
    
    public boolean isHeadless() {
        return entityData.get(HEADLESS);
    }
    
    private void setHeadless(boolean headless) {
        entityData.set(HEADLESS, headless);
    }

}
