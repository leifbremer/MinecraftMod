package de.versioneins.testmod.init.tiers;

import de.versioneins.testmod.init.Main;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class TagInit {

    public static final TagKey<Block> NEEDS_SILIZIUM_TOOL = tag("needs_silizium_tool");

    private static TagKey<Block> tag(String name)
    {
        return BlockTags.create(new ResourceLocation(Main.MODID, name));
    }
}
