package de.versioneins.testmod.init.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.Supplier;


public class CooldownBlock extends Block {
    public static final BooleanProperty COOLDOWN = BooleanProperty.create("cooldown");

    // Felder für das Item und die Cooldown-Dauer
    private final Supplier<? extends Item> itemSupplier;
    private final int cooldownTicks;

    public CooldownBlock(Supplier<? extends Item> itemSupplier, int cooldownTicks, Properties properties) {
        super(properties);
        this.itemSupplier = itemSupplier;
        this.cooldownTicks = cooldownTicks;
        this.registerDefaultState(this.stateDefinition.any().setValue(COOLDOWN, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COOLDOWN);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide() && !state.getValue(COOLDOWN)) {
            // Erzeuge einen ItemStack aus dem Supplier
            ItemStack stack = new ItemStack(itemSupplier.get());
            // Versuche, das Item ins Inventar zu legen
            if (!player.addItem(stack)) {
                player.drop(stack, false);
            }
            // Setze den Block in den Cooldown
            world.setBlock(pos, state.setValue(COOLDOWN, true), 3);
            // Planen des Ticks zum Zurücksetzen (cooldownTicks)
            world.scheduleTick(pos, this, this.cooldownTicks);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.CONSUME;
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        // Cooldown zurücksetzen
        world.setBlock(pos, state.setValue(COOLDOWN, false), 3);
    }
}
