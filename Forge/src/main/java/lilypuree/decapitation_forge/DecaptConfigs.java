package lilypuree.decapitation_forge;

import lilypuree.decapitation.CommonConfig;
import net.minecraftforge.common.ForgeConfigSpec;

public class DecaptConfigs implements CommonConfig {

    public static ForgeConfigSpec COMMON_CONFIG;
    private ForgeConfigSpec.BooleanValue disablePassive;
    private ForgeConfigSpec.ConfigValue<String> blackListedMobs;
    private ForgeConfigSpec.DoubleValue chance;

    public DecaptConfigs() {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        COMMON_BUILDER.comment("Decapitation Configs");
        disablePassive = COMMON_BUILDER
                .comment("Disable decapitation for passive mobs")
                .translation("decapitation.config.disablePassive")
                .define("disablePassive", false);
        blackListedMobs = COMMON_BUILDER
                .comment("\r\n Mobs to disable decapitation for"
                        + "\r\n Separate multiple entries with a comma."
                        + "\r\n"
                        + "\r\nExample: \"minecraft:pig,some_mod:some_mob\"")
                .translation("")
                .define("blackListedMobs", "");
        chance = COMMON_BUILDER
                .comment("Chance of mobs being decapitated")
                .translation("")
                .defineInRange("chance", 0.2, 0.0, 1.0);
        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    @Override
    public boolean disablePassiveDecapitation() {
        return disablePassive.get();
    }

    @Override
    public String blackListedMobs() {
        return blackListedMobs.get();
    }

    @Override
    public float decapitationChance() {
        return chance.get().floatValue();
    }
}
