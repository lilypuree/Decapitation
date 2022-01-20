package lilypuree.decapitation;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Mob;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Constants {

	public static final String MOD_ID = "decapitation";
	public static final String MOD_NAME = "Decapitation";
	public static final Logger LOG = LogManager.getLogger(MOD_NAME);
    
//    public static float HEADLESS_CHANCE = 0.25f;
	public static CommonConfig config;
}