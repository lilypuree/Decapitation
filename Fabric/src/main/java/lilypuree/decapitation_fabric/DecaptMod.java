package lilypuree.decapitation_fabric;

import lilypuree.decapitation.CommonMod;
import lilypuree.decapitation.Constants;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class DecaptMod  implements ModInitializer {
    
    @Override
    public void onInitialize() {
        AutoConfig.register(DecaptConfigs.class, JanksonConfigSerializer::new);
        Constants.config = AutoConfig.getConfigHolder(DecaptConfigs.class).getConfig();

        CommonMod.init();
    }
    
}
