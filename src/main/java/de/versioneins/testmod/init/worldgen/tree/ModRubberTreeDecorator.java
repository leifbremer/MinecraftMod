package de.versioneins.testmod.init.worldgen.tree;

import com.mojang.serialization.Codec;
import de.versioneins.testmod.init.blocks.ModBlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;



public class ModRubberTreeDecorator extends TreeDecorator {
    public static final Codec<ModRubberTreeDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(ModRubberTreeDecorator::new, (decorator) -> {
        return decorator.probability;
    }).codec();
    private final float probability;

    @Override
    protected TreeDecoratorType<?> type() {
        return ModTreeDecoratorTypes.RUBBER_DECORATOR.get();
    }

    public ModRubberTreeDecorator(float probability) {
        this.probability = probability;
    }
    @Override
    public void place(TreeDecorator.Context pContext) {
        RandomSource randomsource = pContext.random();
        pContext.logs().forEach((logpos) -> {
            if (randomsource.nextFloat() < this.probability) {
                pContext.setBlock(logpos, ModBlockInit.RUBBER_FULL_LOG.get().defaultBlockState());
            }
        });


    }
}





