package de.versioneins.testmod.init.items;


import de.versioneins.testmod.init.items.armor.ArmorMaterialInit;
import de.versioneins.testmod.init.Main;
import de.versioneins.testmod.init.tiers.TierInit;
import de.versioneins.testmod.init.blocks.ModBlockInit;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class ModItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    public static final RegistryObject<Item> PHOENIX_FEATHER = ITEMS.register("phoenix_feather",
            () -> new Item(new Item.Properties()
                    .stacksTo(4)
                    .durability(20)
                    .rarity(Rarity.create("MAGICAL", ChatFormatting.LIGHT_PURPLE))));

    public static final RegistryObject<Item> WAND = ITEMS.register("wand",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .rarity(Rarity.create("MAGICAL", ChatFormatting.LIGHT_PURPLE))
                    .fireResistant()
                    .durability(40)));

    public static final RegistryObject<Item> SILIZIUM = ITEMS.register("silizium",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.RARE)));

    public static final RegistryObject<Item> SILIZIUM_BLOCK_ITEM = ITEMS.register("silizium_block",
            () -> new BlockItem(ModBlockInit.SILIZIUM_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<SwordItem> SILIZIUM_SWORD = ITEMS.register("silizium_sword",
            () -> new SwordItem(
                    TierInit.TIER_SILIZIUM,
                    6,
                    10,
                    new Item.Properties()
                    .rarity(Rarity.EPIC))
            );

    public static final RegistryObject<ArmorItem> SILIZIUM_HELMET = ITEMS.register("silizium_helmet",
            () -> new ArmorItem(
                    ArmorMaterialInit.SILIZIUM,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
            ));

    public static final RegistryObject<ArmorItem> SILIZIUM_LEGGINGS = ITEMS.register("silizium_leggings",
            () -> new ArmorItem(
                    ArmorMaterialInit.SILIZIUM,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties()
            ));

    public static final RegistryObject<ArmorItem> SILIZIUM_BOOTS = ITEMS.register("silizium_boots",
            () -> new ArmorItem(
                    ArmorMaterialInit.SILIZIUM,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties()
            ));

    public static final RegistryObject<ArmorItem> SILIZIUM_CHESTPLATE = ITEMS.register("silizium_chestplate",
            () -> new ArmorItem(
                    ArmorMaterialInit.SILIZIUM,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
            ));

    public static final RegistryObject<Item> SILIZIUM_ORE_ITEM = ITEMS.register("silizium_ore",
            () -> new BlockItem(ModBlockInit.SILIZIUM_ORE.get(),
                    new Item.Properties()
            ));

    public static final RegistryObject<Item> DEEPSLATE_SILIZIUM_ORE_ITEM = ITEMS.register("deepslate_silizium_ore",
            () -> new BlockItem(ModBlockInit.DEEPSLATE_SILIZIUM_ORE.get(),
                    new Item.Properties()
            ));

    public static final RegistryObject<Item> NETHER_SILIZIUM_ORE_ITEM = ITEMS.register("nether_silizium_ore",
            () -> new BlockItem(ModBlockInit.NETHER_SILIZIUM_ORE.get(),
                    new Item.Properties()
            ));

    public static final RegistryObject<Item> RUBBER_FULL_LOG_ITEM = ITEMS.register("rubber_full_log",
            () -> new BlockItem(ModBlockInit.RUBBER_FULL_LOG.get(), new Item.Properties()));


    public static final RegistryObject<Item> DETECTOR = ITEMS.register("detector",
            () -> new DetectorItem(new Item.Properties().durability(100)
            ));

    public static final RegistryObject<Item> RUBBER_SAPLING_ITEM = ITEMS.register("rubber_sapling",
            () -> new BlockItem(ModBlockInit.RUBBER_SAPLING.get(), new Item.Properties()));

    public static final RegistryObject<Item> RUBBER = ITEMS.register("rubber",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> RUBBER_TAP = ITEMS.register("rubber_tap",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .durability(20)
                    .rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> STICKY_RESIN = ITEMS.register("sticky_resin",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.COMMON)));






    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
