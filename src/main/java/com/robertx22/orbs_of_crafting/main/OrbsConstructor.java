package com.robertx22.orbs_of_crafting.main;

import com.robertx22.library_of_exile.registry.ExileRegistryEventClass;
import com.robertx22.library_of_exile.registry.helpers.ExileKeyHolder;
import com.robertx22.library_of_exile.registry.helpers.OrderedModConstructor;
import com.robertx22.orbs_of_crafting.register.Modifications;
import com.robertx22.orbs_of_crafting.register.Orbs;
import com.robertx22.orbs_of_crafting.register.Requirements;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.Arrays;
import java.util.List;

public class OrbsConstructor extends OrderedModConstructor {
    public OrbsConstructor(String modid, IEventBus modbus) {
        super(modid, modbus);
    }

    @Override
    public List<ExileRegistryEventClass> getRegisterEvents() {
        return Arrays.asList(

        );
    }

    @Override
    public List<ExileKeyHolder> getAllKeyHolders() {
        return Arrays.asList(
                Modifications.INSTANCE,
                Requirements.INSTANCE,
                Orbs.INSTANCE
        );
    }

    @Override
    public void registerDeferredContainers(IEventBus iEventBus) {
        OrbsOfCraftingMain.initDeferred();
    }

    @Override
    public void registerDeferredEntries() {
        OrbsOfCraftingMain.initDeferredEntries();
    }

    @Override
    public void registerDatabases() {
        OrbDatabase.INSTANCE.initDatabases();
    }

    @Override
    public void registerDatabaseEntries() {
   
    }
}
