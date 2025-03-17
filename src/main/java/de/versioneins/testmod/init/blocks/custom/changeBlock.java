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

public class changeBlock extends Block {
    public static final BooleanProperty COOLDOWN = BooleanProperty.create("cooldown");
    private final int cooldownTicks;
    private final Supplier<? extends Item> itemSupplier;
    public static final BooleanProperty RUBBER = BooleanProperty.create("rubber");
    private final Supplier<? extends Item> userItem;

    public changeBlock(Properties pProperties, int cooldownTicks,Supplier<? extends Item> itemSupplier, Supplier<? extends Item> userItem) {
        super(pProperties);
        this.cooldownTicks = cooldownTicks;
        this.itemSupplier = itemSupplier;
        this.userItem = userItem;
        this.registerDefaultState(this.stateDefinition.any().setValue(COOLDOWN, false).setValue(RUBBER, false));

    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getItemInHand(hand);
        if (heldItem.getItem() == userItem.get()) {
            if (!world.isClientSide() && !state.getValue(COOLDOWN)) {
                // Ändere den State, damit der Block jetzt das Rubber Log aussehen soll
                BlockState newState = state.setValue(RUBBER, true);
                world.setBlock(pos, newState, 3);

                // Optional: Gib dem Spieler ein Item
                ItemStack stack = new ItemStack(itemSupplier.get());
                if (!player.addItem(stack)) {
                    player.drop(stack, false);
                }
                if (!player.isCreative()) {
                    heldItem.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));
                }

                // Setze den Block in den Cooldown
                world.setBlock(pos, newState.setValue(COOLDOWN, true), 3);
                world.scheduleTick(pos, this, this.cooldownTicks);



                return InteractionResult.SUCCESS;
            }
            return InteractionResult.CONSUME;
        }
        return super.use(state, world, pos, player, hand, hit);
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        // Setze den State zurück: Cooldown ist vorbei und der Block sieht wieder aus wie ChangeBlock
        world.setBlock(pos, state.setValue(COOLDOWN, false).setValue(RUBBER, false), 3);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COOLDOWN, RUBBER);
    }
    }

