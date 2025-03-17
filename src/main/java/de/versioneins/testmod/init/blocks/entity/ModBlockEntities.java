package de.versioneins.testmod.init.blocks.entity;

import de.versioneins.testmod.init.Main;
import de.versioneins.testmod.init.blocks.ModBlockInit;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Main.MODID);

    public static final RegistryObject<BlockEntityType<SolarpanelBlockEntity>> SOLARPANEL_BE =
            BLOCK_ENTITIES.register("solarpanel_be",
                    () -> BlockEntityType.Builder.of(SolarpanelBlockEntity::new,
                            ModBlockInit.SOLARPANEL.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
