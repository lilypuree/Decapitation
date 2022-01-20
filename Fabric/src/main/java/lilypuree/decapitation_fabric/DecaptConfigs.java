package lilypuree.decapitation_fabric;

import lilypuree.decapitation.CommonConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "decapitation")
public class DecaptConfigs implements ConfigData, CommonConfig {

    @ConfigEntry.Gui.Tooltip(count = 0)
    @Comment("Disable decapitation for passive mobs")
    public boolean disablePassive = false;

    @ConfigEntry.Gui.Tooltip(count = 0)
    @Comment("""
            Mobs to disable decapitation for
            Separate multiple entries with a comma.
                        
            Example: \"minecraft:pig,some_mod:some_mob\"
            """)
    public String blacklist = "";

    @ConfigEntry.Gui.Tooltip(count = 0)
    @Comment("Chance of mobs being decapitated")
    @ConfigEntry.BoundedDiscrete(min = 0, max = 1)
    public float chance = 0.2f;


    @Override
    public float decapitationChance() {
        return chance;
    }

    @Override
    public boolean disablePassiveDecapitation() {
        return disablePassive;
    }

    @Override
    public String blackListedMobs() {
        return blacklist;
    }
}
