package com.robertx22.orbs_of_crafting;

import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.connect.IMixinConnector;

public class MixinConnector implements IMixinConnector {

    @Override
    public void connect() {
        Mixins.addConfiguration(
                "orbs_of_crafting-mixins.json"
        );
    }
}