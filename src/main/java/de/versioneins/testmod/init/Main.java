package de.versioneins.testmod.init;

import com.mojang.logging.LogUtils;
import de.versioneins.testmod.init.blocks.ModBlockInit;
import de.versioneins.testmod.init.blocks.entity.ModBlockEntities;
import de.versioneins.testmod.init.items.ModItemInit;

import de.versioneins.testmod.init.screen.ModMenuTypes;
import de.versioneins.testmod.init.screen.SolarpanelScreen;
import de.versioneins.testmod.init.worldgen.tree.ModTreeDecoratorTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Main.MODID)


public class Main {
    public static final String MODID = "testmod";
    private static final Logger LOGGER = LogUtils.getLogger();


    public Main() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
       modEventBus.addListener(this::commonSetup);

        ModItemInit.register(modEventBus);
        ModBlockInit.register(modEventBus);
        CreativeTabInit.TABS.register(modEventBus);
        ModTreeDecoratorTypes.register(modEventBus);



        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);


    }




    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }



    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                // Stelle sicher, dass der Rubber Sapling transparent gerendert wird
                net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlockInit.RUBBER_SAPLING.get(), RenderType.cutout());

                // Falls du andere transparente Blöcke hast, kannst du sie hier ebenfalls hinzufügen
                net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlockInit.RUBBER_LEAVES.get(), RenderType.cutout());
            });

            MenuScreens.register(ModMenuTypes.SOLARPANEL_MENU.get(), SolarpanelScreen::new);
        }
    }


}
