package de.versioneins.testmod.init;

import de.versioneins.testmod.init.items.ModItemInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabInit {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Main.MODID);


    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = TABS.register("example_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.example_tab"))
                    .withSearchBar()
                    .icon(ModItemInit.SILIZIUM_BLOCK_ITEM.get()::getDefaultInstance)
                    .displayItems((displayParams, output) -> {
                       output.accept(ModItemInit.SILIZIUM_BLOCK_ITEM.get());
                       output.accept(ModItemInit.PHOENIX_FEATHER.get());
                        output.accept(ModItemInit.RUBBER_FULL_LOG_ITEM.get());
                        output.accept(ModItemInit.DETECTOR.get());
                        output.accept(ModItemInit.SILIZIUM_BOOTS.get());
                        output.accept(ModItemInit.SILIZIUM_SWORD.get());
                        output.accept(ModItemInit.SILIZIUM_LEGGINGS.get());
                        output.accept(ModItemInit.SILIZIUM_CHESTPLATE.get());
                        output.accept(ModItemInit.SILIZIUM_HELMET.get());
                        output.accept(ModItemInit.SILIZIUM_ORE_ITEM.get());
                        output.accept(ModItemInit.RUBBER.get());
                        output.accept(ModItemInit.SILIZIUM.get());
                        output.accept(ModItemInit.RUBBER_FULL_LOG_ITEM.get());
                        output.accept(ModItemInit.STICKY_RESIN.get());
                        output.accept(ModItemInit.RUBBER_TAP.get());
                        output.accept(ModItemInit.RUBBER_SAPLING_ITEM.get());



                    })
                    .build()

    );

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event){

    }
}
