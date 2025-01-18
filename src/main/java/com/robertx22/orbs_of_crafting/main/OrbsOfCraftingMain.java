package com.robertx22.orbs_of_crafting.main;

import com.robertx22.library_of_exile.main.ApiForgeEvents;
import com.robertx22.library_of_exile.registry.util.ExileRegistryUtil;
import com.robertx22.orbs_of_crafting.configs.OrbsConfig;
import com.robertx22.orbs_of_crafting.lang.OrbWords;
import com.robertx22.orbs_of_crafting.misc.OnClick;
import com.robertx22.orbs_of_crafting.register.ExileCurrency;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.CachedOutput;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod("orbs_of_crafting")
public class OrbsOfCraftingMain {

    public static boolean RUN_DEV_TOOLS = false;

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OrbsRef.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OrbsRef.MODID);


    public OrbsOfCraftingMain() {

        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            bus.addListener(OrbClientInit::onInitializeClient);
        });

        if (RUN_DEV_TOOLS) {
            ExileRegistryUtil.setCurrentRegistarMod(OrbsRef.MODID);
        }

        new OrbsConstructor(OrbsRef.MODID, bus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, OrbsConfig.SPEC);

        bus.addListener(this::commonSetupEvent);

        OnClick.register();

        ApiForgeEvents.registerForgeEvent(PlayerEvent.PlayerLoggedInEvent.class, event -> {
            if (RUN_DEV_TOOLS) {
                new OrbDataGen().run(CachedOutput.NO_CACHE);
            }
        });

        System.out.println("Orbs of Crafting loaded.");
    }

    public static void initDeferred() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        CREATIVE_TAB.register(bus);
    }

    public static void initDeferredEntries() {

        CREATIVE_TAB.register("tab", () -> new CreativeModeTab.Builder(CreativeModeTab.Row.TOP, 2)
                .icon(() -> Items.DIAMOND.getDefaultInstance())
                .title(OrbWords.MOD_NAME.get().withStyle(ChatFormatting.DARK_PURPLE, ChatFormatting.BOLD))
                .displayItems(new CreativeModeTab.DisplayItemsGenerator() {
                    @Override
                    public void accept(CreativeModeTab.ItemDisplayParameters param, CreativeModeTab.Output output) {
                        for (Item item : ExileCurrency.CACHED_MAP.get().keySet()) {
                            output.accept(item);
                        }
                    }
                })
                .build());
    }


    public void commonSetupEvent(FMLCommonSetupEvent event) {
        ComponentInit.reg();
    }
}
