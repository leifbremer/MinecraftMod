package de.versioneins.testmod.init.items.armor;

import de.versioneins.testmod.init.items.ModItemInit;
import de.versioneins.testmod.init.tiers.ModArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.crafting.Ingredient;

public class ArmorMaterialInit {
    public static final ModArmorMaterial SILIZIUM = new ModArmorMaterial(
            new int[] {500, 1200, 600, 400},
            new int[] {11, 16, 15, 13},
            20,
            SoundEvents.BAMBOO_BREAK,
            0.25f,
            0.25f,
            () -> Ingredient.of(ModItemInit.SILIZIUM::get),
            "silizium"
    );
}
