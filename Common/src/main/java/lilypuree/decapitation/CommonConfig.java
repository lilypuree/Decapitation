package lilypuree.decapitation;

import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityType;

import java.util.Arrays;

public interface CommonConfig {

    float decapitationChance();

    boolean disablePassiveDecapitation();

    String blackListedMobs();

    default boolean isMobInBlackList(EntityType<?> type) {
        String mobId = Registry.ENTITY_TYPE.getKey(type).toString();
        return Arrays.asList(blackListedMobs().split(",")).contains(mobId);
    }
}
