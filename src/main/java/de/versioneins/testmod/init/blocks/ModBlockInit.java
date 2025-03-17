package de.versioneins.testmod.init.blocks;



import de.versioneins.testmod.init.Main;
import de.versioneins.testmod.init.blocks.custom.Solarpanel;
import de.versioneins.testmod.init.blocks.custom.changeBlock;
import de.versioneins.testmod.init.items.ModItemInit;
import de.versioneins.testmod.init.worldgen.tree.RubberTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

    public static final RegistryObject<Block> SILIZIUM_BLOCK = BLOCKS.register("silizium_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(1, 1).requiresCorrectToolForDrops()));

    public static final RegistryObject<DropExperienceBlock> SILIZIUM_ORE = BLOCKS.register("silizium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    , UniformInt.of(4, 7)
                    ));

    public static final RegistryObject<DropExperienceBlock> DEEPSLATE_SILIZIUM_ORE = BLOCKS.register("deepslate_silizium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    , UniformInt.of(4, 7)
            ));

    public static final RegistryObject<DropExperienceBlock> NETHER_SILIZIUM_ORE = BLOCKS.register("nether_silizium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE)
                    , UniformInt.of(4, 7)
            ));

//    public static final RegistryObject<Block> COOLDOWN_BLOCK = BLOCKS.register("cooldown_block",
//            () -> new CooldownBlock(
//                    () -> ModItemInit.SILIZIUM.get(),
//                    20,
//                    Block.Properties.of()
//                    .strength(1.5f)
//                    .requiresCorrectToolForDrops()));


    //Colldown noch zufällig machen
    public static final RegistryObject<Block> RUBBER_FULL_LOG = BLOCKS.register("rubber_full_log",
            () -> new changeBlock(Block.Properties.of().strength(1,1), 200, ModItemInit.STICKY_RESIN, ModItemInit.RUBBER_TAP));


    public static final RegistryObject<Block> RUBBER_SAPLING = BLOCKS.register("rubber_sapling",
            () -> new SaplingBlock(new RubberTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> RUBBER_LOG = registerBlock("rubber_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f)));

    public static final RegistryObject<Block> RUBBER_LEAVES = registerBlock("rubber_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> RUBBER_WOOD = registerBlock("rubber_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(3f)));

    public static final RegistryObject<Block> STRIPPED_RUBBER_LOG = registerBlock("stripped_rubber_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final RegistryObject<Block> STRIPPED_RUBBER_WOOD = registerBlock("stripped_rubber_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));


    public static final RegistryObject<Block> SOLARPANEL = registerBlock("solarpanel",
            () -> new Solarpanel(BlockBehaviour.Properties.of().strength(1)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }



    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }




    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}
