package com.robertx22.orbs_of_crafting.main;

import com.robertx22.library_of_exile.registry.register_info.HardcodedRegistration;
import com.robertx22.library_of_exile.registry.register_info.ModRequiredRegisterInfo;
import com.robertx22.library_of_exile.registry.register_info.SeriazableRegistration;
import net.minecraft.resources.ResourceLocation;

public class OrbsRef {
    public static String MODID = "orbs_of_crafting";
    public static HardcodedRegistration HARDCODED = new HardcodedRegistration(MODID);
    public static SeriazableRegistration SERIAZABLE = new SeriazableRegistration(MODID);
    public static ModRequiredRegisterInfo REGISTER_INFO = new ModRequiredRegisterInfo(MODID);

    public static ResourceLocation id(String id) {
        return new ResourceLocation(MODID, id);
    }

}
