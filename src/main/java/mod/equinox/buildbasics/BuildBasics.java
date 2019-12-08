package mod.equinox.buildbasics;

import mod.equinox.buildbasics.block.ModBlocks;
import mod.equinox.buildbasics.setup.ClientProxy;
import mod.equinox.buildbasics.setup.IProxy;
import mod.equinox.buildbasics.setup.ModSetup;
import mod.equinox.buildbasics.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.world.biome.BirchForestBiome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import mod.equinox.buildbasics.block.ModBlocks.*;

import java.util.stream.Collectors;

import static mod.equinox.buildbasics.block.ModBlocks.*;


// The value here should match an entry in the META-INF/mods.toml file
@Mod("buildbasics")
public class BuildBasics {

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static ModSetup setup = new ModSetup();

    private static final Logger LOGGER = LogManager.getLogger();

    public BuildBasics() {
        // Register the setup method for mod loading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        setup.init();
        proxy.init();
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().registerAll(
                    //SMOOTH_STONE_STAIRS,
                    POLISHED_STONE, SMALL_STONE_BRICKS, STONE_PILLAR, GRANITE_BRICKS, SMALL_GRANITE_BRICKS, GRANITE_PILLAR, CHISELED_GRANITE,
                    DIORITE_BRICKS, SMALL_DIORITE_BRICKS, DIORITE_PILLAR, CHISELED_DIORITE, ANDESITE_BRICKS, SMALL_ANDESITE_BRICKS, ANDESITE_PILLAR, CHISELED_ANDESITE, TERRACOTTA_BRICKS,
                    WHITE_TERRACOTTA_BRICKS, ORANGE_TERRACOTTA_BRICKS, MAGENTA_TERRACOTTA_BRICKS, LIGHT_BLUE_TERRACOTTA_BRICKS, YELLOW_TERRACOTTA_BRICKS, LIME_TERRACOTTA_BRICKS, PINK_TERRACOTTA_BRICKS, GRAY_TERRACOTTA_BRICKS,
                    LIGHT_GRAY_TERRACOTTA_BRICKS, CYAN_TERRACOTTA_BRICKS, PURPLE_TERRACOTTA_BRICKS, BLUE_TERRACOTTA_BRICKS, BROWN_TERRACOTTA_BRICKS, GREEN_TERRACOTTA_BRICKS, RED_TERRACOTTA_BRICKS, BLACK_TERRACOTTA_BRICKS,
                    WHITE_GLAZED_TERRACOTTA_PILLAR, ORANGE_GLAZED_TERRACOTTA_PILLAR, MAGENTA_GLAZED_TERRACOTTA_PILLAR, LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR, YELLOW_GLAZED_TERRACOTTA_PILLAR, LIME_GLAZED_TERRACOTTA_PILLAR, PINK_GLAZED_TERRACOTTA_PILLAR, GRAY_GLAZED_TERRACOTTA_PILLAR,
                    LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR, CYAN_GLAZED_TERRACOTTA_PILLAR, PURPLE_GLAZED_TERRACOTTA_PILLAR, BLUE_GLAZED_TERRACOTTA_PILLAR, BROWN_GLAZED_TERRACOTTA_PILLAR, GREEN_GLAZED_TERRACOTTA_PILLAR, RED_GLAZED_TERRACOTTA_PILLAR, BLACK_GLAZED_TERRACOTTA_PILLAR,
                    WHITE_PURPUR, ORANGE_PURPUR, MAGENTA_PURPUR, LIGHT_BLUE_PURPUR, YELLOW_PURPUR, LIME_PURPUR, PINK_PURPUR, GRAY_PURPUR,
                    LIGHT_GRAY_PURPUR, CYAN_PURPUR, PURPLE_PURPUR, BLUE_PURPUR, BROWN_PURPUR, GREEN_PURPUR, RED_PURPUR, BLACK_PURPUR,
                    IRON_CHAIN,
                    PRISMARINE_TILES, PRISMARINE_PILLAR, CHISELED_PRISMARINE, DARK_PRISMARINE_BRICKS, DARK_PRISMARINE_TILES, DARK_PRISMARINE_PILLAR, CHISELED_DARK_PRISMARINE, ABYSSAL_LANTERN,
                    SMALL_END_STONE_BRICKS, END_STONE_TILES, END_STONE_PILLAR,
                    OAK_BOARDS, SPRUCE_BOARDS, BIRCH_BOARDS, JUNGLE_BOARDS, ACACIA_BOARDS, DARK_OAK_BOARDS,
                    OAK_GLASS_DOOR, SPRUCE_GLASS_DOOR, BIRCH_GLASS_DOOR, JUNGLE_GLASS_DOOR, ACACIA_GLASS_DOOR, DARK_OAK_GLASS_DOOR, IRON_GLASS_DOOR, GLASS_DOOR,
                    WHITE_CANDLE, ORANGE_CANDLE, MAGENTA_CANDLE, LIGHT_BLUE_CANDLE, YELLOW_CANDLE, LIME_CANDLE, PINK_CANDLE, GRAY_CANDLE,
                    LIGHT_GRAY_CANDLE, CYAN_CANDLE, PURPLE_CANDLE, BLUE_CANDLE, BROWN_CANDLE, GREEN_CANDLE, RED_CANDLE, BLACK_CANDLE,
                    POLISHED_STONE_STAIRS, SMALL_STONE_BRICK_STAIRS, GRANITE_BRICK_STAIRS, SMALL_GRANITE_BRICK_STAIRS, DIORITE_BRICK_STAIRS, SMALL_DIORITE_BRICK_STAIRS, ANDESITE_BRICK_STAIRS, SMALL_ANDESITE_BRICK_STAIRS
            );
            if (ModList.get().isLoaded("bloomful")) {
                event.getRegistry().registerAll(
                        WISTERIA_BOARDS, WISTERIA_GLASS_DOOR
                );
            }
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties building = new Item.Properties()
                    .group(ItemGroup.BUILDING_BLOCKS);
            Item.Properties decoration = new Item.Properties()
                    .group(ItemGroup.DECORATIONS);
            Item.Properties redstone = new Item.Properties()
                    .group(ItemGroup.REDSTONE);
            //event.getRegistry().register(new BlockItem(SMOOTH_STONE_STAIRS, building).setRegistryName("smooth_stone_stairs"));
            event.getRegistry().register(new BlockItem(POLISHED_STONE, building).setRegistryName("polished_stone"));
            event.getRegistry().register(new BlockItem(SMALL_STONE_BRICKS, building).setRegistryName("small_stone_bricks"));
            event.getRegistry().register(new BlockItem(STONE_PILLAR, building).setRegistryName("stone_pillar"));
            event.getRegistry().register(new BlockItem(GRANITE_BRICKS, building).setRegistryName("granite_bricks"));
            event.getRegistry().register(new BlockItem(SMALL_GRANITE_BRICKS, building).setRegistryName("small_granite_bricks"));
            event.getRegistry().register(new BlockItem(GRANITE_PILLAR, building).setRegistryName("granite_pillar"));
            event.getRegistry().register(new BlockItem(CHISELED_GRANITE, building).setRegistryName("chiseled_granite"));
            event.getRegistry().register(new BlockItem(DIORITE_BRICKS, building).setRegistryName("diorite_bricks"));
            event.getRegistry().register(new BlockItem(SMALL_DIORITE_BRICKS, building).setRegistryName("small_diorite_bricks"));
            event.getRegistry().register(new BlockItem(DIORITE_PILLAR, building).setRegistryName("diorite_pillar"));
            event.getRegistry().register(new BlockItem(CHISELED_DIORITE, building).setRegistryName("chiseled_diorite"));
            event.getRegistry().register(new BlockItem(ANDESITE_BRICKS, building).setRegistryName("andesite_bricks"));
            event.getRegistry().register(new BlockItem(SMALL_ANDESITE_BRICKS, building).setRegistryName("small_andesite_bricks"));
            event.getRegistry().register(new BlockItem(ANDESITE_PILLAR, building).setRegistryName("andesite_pillar"));
            event.getRegistry().register(new BlockItem(CHISELED_ANDESITE, building).setRegistryName("chiseled_andesite"));
            event.getRegistry().register(new BlockItem(TERRACOTTA_BRICKS, building).setRegistryName("terracotta_bricks"));
            event.getRegistry().register(new BlockItem(WHITE_TERRACOTTA_BRICKS, building).setRegistryName("white_terracotta_bricks"));
            event.getRegistry().register(new BlockItem(ORANGE_TERRACOTTA_BRICKS, building).setRegistryName("orange_terracotta_bricks"));
            event.getRegistry().register(new BlockItem(MAGENTA_TERRACOTTA_BRICKS, building).setRegistryName("magenta_terracotta_bricks"));
            event.getRegistry().register(new BlockItem(LIGHT_BLUE_TERRACOTTA_BRICKS, building).setRegistryName("light_blue_terracotta_bricks"));
            event.getRegistry().register(new BlockItem(YELLOW_TERRACOTTA_BRICKS, building).setRegistryName("yellow_terracotta_bricks"));
            event.getRegistry().register(new BlockItem(LIME_TERRACOTTA_BRICKS, building).setRegistryName("lime_terracotta_bricks"));
            event.getRegistry().register(new BlockItem(PINK_TERRACOTTA_BRICKS, building).setRegistryName("pink_terracotta_bricks"));
            event.getRegistry().register(new BlockItem(GRAY_TERRACOTTA_BRICKS, building).setRegistryName("gray_terracotta_bricks"));
            event.getRegistry().register(new BlockItem(LIGHT_GRAY_TERRACOTTA_BRICKS, building).setRegistryName("light_gray_terracotta_bricks"));
            event.getRegistry().register(new BlockItem(CYAN_TERRACOTTA_BRICKS, building).setRegistryName("cyan_terracotta_bricks"));
            event.getRegistry().register(new BlockItem(PURPLE_TERRACOTTA_BRICKS, building).setRegistryName("purple_terracotta_bricks"));
            event.getRegistry().register(new BlockItem(BLUE_TERRACOTTA_BRICKS, building).setRegistryName("blue_terracotta_bricks"));
            event.getRegistry().register(new BlockItem(BROWN_TERRACOTTA_BRICKS, building).setRegistryName("brown_terracotta_bricks"));
            event.getRegistry().register(new BlockItem(GREEN_TERRACOTTA_BRICKS, building).setRegistryName("green_terracotta_bricks"));
            event.getRegistry().register(new BlockItem(RED_TERRACOTTA_BRICKS, building).setRegistryName("red_terracotta_bricks"));
            event.getRegistry().register(new BlockItem(BLACK_TERRACOTTA_BRICKS, building).setRegistryName("black_terracotta_bricks"));
            event.getRegistry().register(new BlockItem(WHITE_GLAZED_TERRACOTTA_PILLAR, decoration).setRegistryName("white_glazed_terracotta_pillar"));
            event.getRegistry().register(new BlockItem(ORANGE_GLAZED_TERRACOTTA_PILLAR, decoration).setRegistryName("orange_glazed_terracotta_pillar"));
            event.getRegistry().register(new BlockItem(MAGENTA_GLAZED_TERRACOTTA_PILLAR, decoration).setRegistryName("magenta_glazed_terracotta_pillar"));
            event.getRegistry().register(new BlockItem(LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR, decoration).setRegistryName("light_blue_glazed_terracotta_pillar"));
            event.getRegistry().register(new BlockItem(YELLOW_GLAZED_TERRACOTTA_PILLAR, decoration).setRegistryName("yellow_glazed_terracotta_pillar"));
            event.getRegistry().register(new BlockItem(LIME_GLAZED_TERRACOTTA_PILLAR, decoration).setRegistryName("lime_glazed_terracotta_pillar"));
            event.getRegistry().register(new BlockItem(PINK_GLAZED_TERRACOTTA_PILLAR, decoration).setRegistryName("pink_glazed_terracotta_pillar"));
            event.getRegistry().register(new BlockItem(GRAY_GLAZED_TERRACOTTA_PILLAR, decoration).setRegistryName("gray_glazed_terracotta_pillar"));
            event.getRegistry().register(new BlockItem(LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR, decoration).setRegistryName("light_gray_glazed_terracotta_pillar"));
            event.getRegistry().register(new BlockItem(CYAN_GLAZED_TERRACOTTA_PILLAR, decoration).setRegistryName("cyan_glazed_terracotta_pillar"));
            event.getRegistry().register(new BlockItem(PURPLE_GLAZED_TERRACOTTA_PILLAR, decoration).setRegistryName("purple_glazed_terracotta_pillar"));
            event.getRegistry().register(new BlockItem(BLUE_GLAZED_TERRACOTTA_PILLAR, decoration).setRegistryName("blue_glazed_terracotta_pillar"));
            event.getRegistry().register(new BlockItem(BROWN_GLAZED_TERRACOTTA_PILLAR, decoration).setRegistryName("brown_glazed_terracotta_pillar"));
            event.getRegistry().register(new BlockItem(GREEN_GLAZED_TERRACOTTA_PILLAR, decoration).setRegistryName("green_glazed_terracotta_pillar"));
            event.getRegistry().register(new BlockItem(RED_GLAZED_TERRACOTTA_PILLAR, decoration).setRegistryName("red_glazed_terracotta_pillar"));
            event.getRegistry().register(new BlockItem(BLACK_GLAZED_TERRACOTTA_PILLAR, decoration).setRegistryName("black_glazed_terracotta_pillar"));
            event.getRegistry().register(new BlockItem(WHITE_PURPUR, building).setRegistryName("white_purpur_block"));
            event.getRegistry().register(new BlockItem(ORANGE_PURPUR, building).setRegistryName("orange_purpur_block"));
            event.getRegistry().register(new BlockItem(MAGENTA_PURPUR, building).setRegistryName("magenta_purpur_block"));
            event.getRegistry().register(new BlockItem(LIGHT_BLUE_PURPUR, building).setRegistryName("light_blue_purpur_block"));
            event.getRegistry().register(new BlockItem(YELLOW_PURPUR, building).setRegistryName("yellow_purpur_block"));
            event.getRegistry().register(new BlockItem(LIME_PURPUR, building).setRegistryName("lime_purpur_block"));
            event.getRegistry().register(new BlockItem(PINK_PURPUR, building).setRegistryName("pink_purpur_block"));
            event.getRegistry().register(new BlockItem(GRAY_PURPUR, building).setRegistryName("gray_purpur_block"));
            event.getRegistry().register(new BlockItem(LIGHT_GRAY_PURPUR, building).setRegistryName("light_gray_purpur_block"));
            event.getRegistry().register(new BlockItem(CYAN_PURPUR, building).setRegistryName("cyan_purpur_block"));
            event.getRegistry().register(new BlockItem(PURPLE_PURPUR, building).setRegistryName("purple_purpur_block"));
            event.getRegistry().register(new BlockItem(BLUE_PURPUR, building).setRegistryName("blue_purpur_block"));
            event.getRegistry().register(new BlockItem(BROWN_PURPUR, building).setRegistryName("brown_purpur_block"));
            event.getRegistry().register(new BlockItem(GREEN_PURPUR, building).setRegistryName("green_purpur_block"));
            event.getRegistry().register(new BlockItem(RED_PURPUR, building).setRegistryName("red_purpur_block"));
            event.getRegistry().register(new BlockItem(BLACK_PURPUR, building).setRegistryName("black_purpur_block"));
            event.getRegistry().register(new BlockItem(PRISMARINE_TILES, building).setRegistryName("prismarine_tiles"));
            event.getRegistry().register(new BlockItem(PRISMARINE_PILLAR, building).setRegistryName("prismarine_pillar"));
            event.getRegistry().register(new BlockItem(CHISELED_PRISMARINE, building).setRegistryName("chiseled_prismarine"));
            event.getRegistry().register(new BlockItem(DARK_PRISMARINE_BRICKS, building).setRegistryName("dark_prismarine_bricks"));
            event.getRegistry().register(new BlockItem(DARK_PRISMARINE_TILES, building).setRegistryName("dark_prismarine_tiles"));
            event.getRegistry().register(new BlockItem(DARK_PRISMARINE_PILLAR, building).setRegistryName("dark_prismarine_pillar"));
            event.getRegistry().register(new BlockItem(CHISELED_DARK_PRISMARINE, building).setRegistryName("chiseled_dark_prismarine"));
            event.getRegistry().register(new BlockItem(ABYSSAL_LANTERN, building).setRegistryName("abyssal_lantern"));
            event.getRegistry().register(new BlockItem(SMALL_END_STONE_BRICKS, building).setRegistryName("small_end_stone_bricks"));
            event.getRegistry().register(new BlockItem(END_STONE_TILES, building).setRegistryName("end_stone_tiles"));
            event.getRegistry().register(new BlockItem(END_STONE_PILLAR, building).setRegistryName("end_stone_pillar"));
            event.getRegistry().register(new BlockItem(OAK_BOARDS, building).setRegistryName("oak_boards"));
            event.getRegistry().register(new BlockItem(SPRUCE_BOARDS, building).setRegistryName("spruce_boards"));
            event.getRegistry().register(new BlockItem(BIRCH_BOARDS, building).setRegistryName("birch_boards"));
            event.getRegistry().register(new BlockItem(JUNGLE_BOARDS, building).setRegistryName("jungle_boards"));
            event.getRegistry().register(new BlockItem(ACACIA_BOARDS, building).setRegistryName("acacia_boards"));
            event.getRegistry().register(new BlockItem(DARK_OAK_BOARDS, building).setRegistryName("dark_oak_boards"));
            event.getRegistry().register(new BlockItem(IRON_CHAIN, decoration).setRegistryName("iron_chain"));
            event.getRegistry().register(new BlockItem(OAK_GLASS_DOOR, redstone).setRegistryName("oak_glass_door"));
            event.getRegistry().register(new BlockItem(SPRUCE_GLASS_DOOR, redstone).setRegistryName("spruce_glass_door"));
            event.getRegistry().register(new BlockItem(BIRCH_GLASS_DOOR, redstone).setRegistryName("birch_glass_door"));
            event.getRegistry().register(new BlockItem(JUNGLE_GLASS_DOOR, redstone).setRegistryName("jungle_glass_door"));
            event.getRegistry().register(new BlockItem(ACACIA_GLASS_DOOR, redstone).setRegistryName("acacia_glass_door"));
            event.getRegistry().register(new BlockItem(DARK_OAK_GLASS_DOOR, redstone).setRegistryName("dark_oak_glass_door"));
            event.getRegistry().register(new BlockItem(IRON_GLASS_DOOR, redstone).setRegistryName("iron_glass_door"));
            event.getRegistry().register(new BlockItem(GLASS_DOOR, redstone).setRegistryName("glass_door"));
            event.getRegistry().register(new BlockItem(WHITE_CANDLE, decoration).setRegistryName("white_candle"));
            event.getRegistry().register(new BlockItem(ORANGE_CANDLE, decoration).setRegistryName("orange_candle"));
            event.getRegistry().register(new BlockItem(MAGENTA_CANDLE, decoration).setRegistryName("magenta_candle"));
            event.getRegistry().register(new BlockItem(LIGHT_BLUE_CANDLE, decoration).setRegistryName("light_blue_candle"));
            event.getRegistry().register(new BlockItem(YELLOW_CANDLE, decoration).setRegistryName("yellow_candle"));
            event.getRegistry().register(new BlockItem(LIME_CANDLE, decoration).setRegistryName("lime_candle"));
            event.getRegistry().register(new BlockItem(PINK_CANDLE, decoration).setRegistryName("pink_candle"));
            event.getRegistry().register(new BlockItem(GRAY_CANDLE, decoration).setRegistryName("gray_candle"));
            event.getRegistry().register(new BlockItem(LIGHT_GRAY_CANDLE, decoration).setRegistryName("light_gray_candle"));
            event.getRegistry().register(new BlockItem(CYAN_CANDLE, decoration).setRegistryName("cyan_candle"));
            event.getRegistry().register(new BlockItem(PURPLE_CANDLE, decoration).setRegistryName("purple_candle"));
            event.getRegistry().register(new BlockItem(BLUE_CANDLE, decoration).setRegistryName("blue_candle"));
            event.getRegistry().register(new BlockItem(BROWN_CANDLE, decoration).setRegistryName("brown_candle"));
            event.getRegistry().register(new BlockItem(GREEN_CANDLE, decoration).setRegistryName("green_candle"));
            event.getRegistry().register(new BlockItem(RED_CANDLE, decoration).setRegistryName("red_candle"));
            event.getRegistry().register(new BlockItem(BLACK_CANDLE, decoration).setRegistryName("black_candle"));

            event.getRegistry().register(new BlockItem(POLISHED_STONE_STAIRS, building).setRegistryName("polished_stone_stairs"));
            event.getRegistry().register(new BlockItem(SMALL_STONE_BRICK_STAIRS, building).setRegistryName("small_stone_brick_stairs"));
            event.getRegistry().register(new BlockItem(GRANITE_BRICK_STAIRS, building).setRegistryName("granite_brick_stairs"));
            event.getRegistry().register(new BlockItem(SMALL_GRANITE_BRICK_STAIRS, building).setRegistryName("small_granite_brick_stairs"));

            if (ModList.get().isLoaded("bloomful")) {
                event.getRegistry().register(new BlockItem(WISTERIA_BOARDS, building).setRegistryName("wisteria_boards"));
                event.getRegistry().register(new BlockItem(WISTERIA_GLASS_DOOR, redstone).setRegistryName("wisteria_glass_door"));
            }
        }
    }
}
