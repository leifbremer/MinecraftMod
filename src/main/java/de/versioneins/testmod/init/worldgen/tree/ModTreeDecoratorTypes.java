package de.versioneins.testmod.init.worldgen.tree;



import de.versioneins.testmod.init.Main;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModTreeDecoratorTypes {
    // Erstelle ein DeferredRegister für TreeDecoratorType
    public static final DeferredRegister<TreeDecoratorType<?>> DECORATOR_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.TREE_DECORATOR_TYPES, Main.MODID);

    // Registriere deinen benutzerdefinierten Decorator-Typ
    public static final RegistryObject<TreeDecoratorType<ModRubberTreeDecorator>> RUBBER_DECORATOR =
            DECORATOR_TYPES.register("rubber",
                    () -> new TreeDecoratorType<>(ModRubberTreeDecorator.CODEC));

    // Diese Methode rufst du in deiner Mod-Hauptklasse auf
    public static void register(IEventBus eventBus) {
        DECORATOR_TYPES.register(eventBus);
    }
}
