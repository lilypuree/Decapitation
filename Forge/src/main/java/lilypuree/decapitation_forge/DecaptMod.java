package lilypuree.decapitation_forge;


import lilypuree.decapitation.CommonMod;
import lilypuree.decapitation.Constants;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(Constants.MOD_ID)
public class DecaptMod {
    public DecaptMod() {
        Constants.config = new DecaptConfigs();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DecaptConfigs.COMMON_CONFIG);

        CommonMod.init();
    }
}
