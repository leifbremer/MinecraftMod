package de.versioneins.testmod.init.tiers;

import de.versioneins.testmod.init.items.ModItemInit;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class TierInit {
    public static final ForgeTier TIER_SILIZIUM = new ForgeTier(
            4,
            1800,
            1.5f,
            6,
            20,
            TagInit.NEEDS_SILIZIUM_TOOL,
            () -> Ingredient.of(ModItemInit.SILIZIUM::get)


    );
}
