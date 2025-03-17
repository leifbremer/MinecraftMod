package de.versioneins.testmod.init.worldgen;

import de.versioneins.testmod.init.Main;
import de.versioneins.testmod.init.blocks.ModBlockInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;



public class ModConfiguredFeature {
//    public static final ResourceKey<ConfiguredFeature<?, ? >>OVERWORLD_SILIZIUM_ORE_KEY = registerKey("silizium_ore");
//    public static final ResourceKey<ConfiguredFeature<?, ? >>NETHER_SILIZIUM_ORE_KEY = registerKey("nether_silizium_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBBER_KEY = registerKey("rubber_configured_feature");

    //  public static void boostrap(BootstapContext<ConfiguredFeature<?, ? >> context) {
//        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
//        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
//        RuleTest netherrackReplaceable = new BlockMatchTest(Blocks.NETHERRACK);
//
//        List<OreConfiguration.TargetBlockState> overworldLithiumOres = List.of(OreConfiguration.target(stoneReplaceable,
//                ModBlockInit.SILIZIUM_ORE.get().defaultBlockState()),
//                OreConfiguration.target(deepslateReplaceable, ModBlockInit.DEEPSLATE_SILIZIUM_ORE.get().defaultBlockState()));
//
//        register(context, OVERWORLD_SILIZIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldLithiumOres, 9));
//        register(context, NETHER_SILIZIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceable, ModBlockInit.NETHER_SILIZIUM_ORE.get().defaultBlockState(), 9));

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Main.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
