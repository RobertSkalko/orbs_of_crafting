package com.robertx22.orbs_of_crafting.configs;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class OrbsConfig {

    public static final ForgeConfigSpec SPEC;
    public static final OrbsConfig CONFIG;

    static {
        final Pair<OrbsConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(OrbsConfig::new);
        SPEC = specPair.getRight();
        CONFIG = specPair.getLeft();
    }


    public static OrbsConfig get() {
        return CONFIG;
    }

    //  public ForgeConfigSpec.IntValue REPAIR_INTERVAL;


    OrbsConfig(ForgeConfigSpec.Builder b) {
        b.comment("Orbs of Crafting Config TODO")
                .push("general");

        // REPAIR_INTERVAL = b.comment("Example, at default setting of 100 ticks, (1 second is 20 ticks), the repair kits will automatically repair player's gear every 5 seconds").defineInRange("repair_interval", 100, 1, 5000);

        b.pop();
    }


}
