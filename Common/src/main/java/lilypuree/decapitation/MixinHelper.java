package lilypuree.decapitation;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

import java.util.Random;

public class MixinHelper {

    private static Random random = new Random();

    public static void setData(Entity entity, SynchedEntityData data, EntityDataAccessor<Boolean> accessor, Level level) {

        if (!level.isClientSide()) {
            float rand = level.random.nextFloat();
            boolean headLess = canBeHeadless(entity) && rand < Constants.config.decapitationChance();
            data.set(accessor, headLess);
        }
    }


    private static boolean canBeHeadless(Entity entity) {
        if (!(entity instanceof Enemy) && Constants.config.disablePassiveDecapitation()) return false;
        EntityType<?> type = entity.getType();
        return type != EntityType.PLAYER && !Constants.config.isMobInBlackList(type);
    }
}
