package de.versioneins.testmod.init.items;

import de.versioneins.testmod.init.blocks.ModBlockInit;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;



public class DetectorItem extends Item {
    public DetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;
            
            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));
                
                if(isValueableBlock(state)){
                    outputValueableCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundBlock = true;
                    break;
                    
                }
            }
            if(!foundBlock) {
                player.sendSystemMessage(Component.literal("nichts gefunden!"));
            }

        }
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), player -> player.broadcastBreakEvent(player.getUsedItemHand()));
        
        return InteractionResult.SUCCESS;
    }

    private void outputValueableCoordinates(BlockPos pos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found" + I18n.get(block.getDescriptionId()) + " at " +
           "(" + pos.getX() + "," + pos.getY() + "," + pos.getZ() + ")"     ));
    }

    private boolean isValueableBlock(BlockState state) {
        return state.is(ModBlockInit.SILIZIUM_ORE.get());
    }
    
    
}
