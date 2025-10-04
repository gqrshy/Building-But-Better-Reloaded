package com.starfish_studios.bbb;

import com.starfish_studios.bbb.block.*;
import com.starfish_studios.bbb.item.DescriptionBlockItem;
import com.starfish_studios.bbb.registry.BBBBlocks;
import com.starfish_studios.bbb.registry.BBBItems;
import com.starfish_studios.bbb.registry.BBBWoodType;
import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import net.mehvahdjukaar.every_compat.api.*;
import net.mehvahdjukaar.moonlight.api.platform.ClientHelper;
import net.mehvahdjukaar.moonlight.api.set.leaves.LeavesType;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodTypeRegistry;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

import static com.starfish_studios.bbb.BuildingButBetter.MOD_ID;

public class BBBModule extends SimpleModule {

    // Trim, Beam, Beam Stairs, Beam Slab, Pallets, Supports, Balustrades, Walls, Frames, Lanterns, Ladders, Lattices
    
    public final SimpleEntrySet<WoodType, Block> trims;
    public final SimpleEntrySet<WoodType, Block> beams;
    public final SimpleEntrySet<WoodType, Block> beamStairs;
    public final SimpleEntrySet<WoodType, Block> beamSlabs;
    public final SimpleEntrySet<WoodType, Block> pallets;
    public final SimpleEntrySet<WoodType, Block> supports;
    public final SimpleEntrySet<WoodType, Block> balustrades;
    public final SimpleEntrySet<WoodType, Block> walls;
    public final SimpleEntrySet<WoodType, Block> frames;
    public final SimpleEntrySet<WoodType, Block> lanterns;
//    public final SimpleEntrySet<WoodType, Block> ladders;
    public final SimpleEntrySet<WoodType, Block> lattices;

    public static void init(String modId) {
        new BBBModule(MOD_ID);
    }

    @Override
    public void registerBlockColors(ClientHelper.BlockColorEvent event) {
        super.registerBlockColors(event);

        for (Map.Entry<WoodType, Block> entry : lattices.blocks.entrySet()) {
            ColorHandlerRegistry.registerBlockColors((state, world, pos, tintIndex) -> {
                        if (world == null || pos == null) {
                            return FoliageColor.getDefaultColor();
                        }
                        return BiomeColors.getAverageFoliageColor(world, pos);
                    }, entry.getValue());
        }
    }

    public BBBModule(String modId) {
        super(modId, "bbb");

        SimpleModule bbb = new SimpleModule("bbb", "bbb");



        trims = SimpleEntrySet.builder(WoodType.class, "trim",
                        getModBlock("oak_trim"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new FacingConnectingBlock(BlockBehaviour.Properties.ofFullCopy(BBBBlocks.TRIM.get(BBBWoodType.OAK).get())))
                .addTag(modRes("trims"), Registries.BLOCK)
                .addTag(modRes("trims"), Registries.ITEM)
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/trim/oak_bottom"))
                .addTexture(modRes("block/trim/oak_middle"))
                .addTexture(modRes("block/trim/oak_none"))
                .addTexture(modRes("block/trim/oak_top"))
                .addTexture(modRes("block/trim/oak_top_face"))
                .build();
        
        this.addEntry(trims);
        
        beams = SimpleEntrySet.builder(WoodType.class, "beam",
                        getModBlock("oak_beam"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(BBBBlocks.BEAM.get(BBBWoodType.OAK).get())))
                .addTag(modRes("beams"), Registries.BLOCK)
                .addTag(modRes("beams"), Registries.ITEM)
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/beam/oak"))
                .addTexture(modRes("block/beam/oak_top"))
                .build();
        
        this.addEntry(beams);
        
        beamStairs = SimpleEntrySet.builder(WoodType.class, "beam_stairs",
                        getModBlock("oak_beam_stairs"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new StairBlock((Blocks.OAK_PLANKS.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(BBBBlocks.BEAM_STAIRS.get(BBBWoodType.OAK).get())))
                .addTag(modRes("beams"), Registries.BLOCK)
                .addTag(modRes("beams"), Registries.ITEM)
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/beam/oak"))
                .addTexture(modRes("block/beam/oak_top"))
                .build();
        
        this.addEntry(beamStairs);
        
        beamSlabs = SimpleEntrySet.builder(WoodType.class, "beam_slab",
                        getModBlock("oak_beam_slab"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new FacingSlabBlock(BlockBehaviour.Properties.ofFullCopy(BBBBlocks.BEAM_SLAB.get(BBBWoodType.OAK).get())))
                .addTag(modRes("beams"), Registries.BLOCK)
                .addTag(modRes("beams"), Registries.ITEM)
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/beam/oak"))
                .addTexture(modRes("block/beam/oak_top"))
                .build();
        
        this.addEntry(beamSlabs);
        
        pallets = SimpleEntrySet.builder(WoodType.class, "pallet",
                        getModBlock("oak_pallet"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new PalletBlock(BlockBehaviour.Properties.ofFullCopy(BBBBlocks.PALLET.get(BBBWoodType.OAK).get())))
                .addTag(modRes("pallets"), Registries.BLOCK)
                .addTag(modRes("pallets"), Registries.ITEM)
                .addCustomItem((wood, block, properties) -> new DescriptionBlockItem(block, properties))
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/pallet/oak_pallet"))
                .build();
        
        this.addEntry(pallets);
        
        supports = SimpleEntrySet.builder(WoodType.class, "support",
                        getModBlock("oak_support"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new SupportBlock(BlockBehaviour.Properties.ofFullCopy(BBBBlocks.SUPPORT.get(BBBWoodType.OAK).get())))
                .addTag(modRes("supports"), Registries.BLOCK)
                .addTag(modRes("supports"), Registries.ITEM)
                .addCustomItem((wood, block, properties) -> new DescriptionBlockItem(block, properties))
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/beam/oak"))
                .addTexture(modRes("block/beam/oak_top"))
                .build();

        this.addEntry(supports);

        balustrades = SimpleEntrySet.builder(WoodType.class, "balustrade",
                        getModBlock("oak_balustrade"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new BalustradeBlock(BlockBehaviour.Properties.ofFullCopy(BBBBlocks.BALUSTRADES.get(BBBWoodType.OAK).get())))
                .addTag(modRes("balustrades"), Registries.BLOCK)
                .addTag(modRes("balustrades"), Registries.ITEM)
                .addCustomItem((wood, block, properties) -> new DescriptionBlockItem(block, properties))
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/balustrade/oak_top"))
                .addTexture(modRes("block/balustrade/oak_sides"))
                .build();

        this.addEntry(balustrades);

        walls = SimpleEntrySet.builder(WoodType.class, "wall",
                        getModBlock("oak_wall"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new WoodenWallBlock(BlockBehaviour.Properties.ofFullCopy(BBBBlocks.WALL.get(BBBWoodType.OAK).get())))
                .addTag(modRes("wooden_walls"), Registries.BLOCK)
//                .addTag(modRes("wooden_walls"), Registries.ITEM)
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/beam/oak"))
                .addTexture(modRes("block/beam/oak_top"))
                .build();

        this.addEntry(walls);

        frames = SimpleEntrySet.builder(WoodType.class, "frame",
                        getModBlock("oak_frame"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(BBBBlocks.FRAMES.get(BBBWoodType.OAK).get())))
                .addTag(modRes("frames"), Registries.BLOCK)
                .addTag(modRes("frames"), Registries.ITEM)
                .addCustomItem((wood, block, properties) -> new DescriptionBlockItem(block, properties))
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/frame/oak"))
                .addTexture(modRes("block/frame/oak_sticks"))
                .build();

        this.addEntry(frames);

        lanterns = SimpleEntrySet.builder(WoodType.class, "lantern",
                        getModBlock("oak_lantern"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(BBBBlocks.LANTERN.get(BBBWoodType.OAK).get())))
                .addTag(modRes("lanterns"), Registries.BLOCK)
                .addTag(modRes("lanterns"), Registries.ITEM)
                .addCustomItem((wood, block, properties) -> new DescriptionBlockItem(block, properties))
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTextureM(modRes("block/lantern/oak"), modRes("block/lantern/lantern_mask"))
                .build();

        this.addEntry(lanterns);

//        ladders = SimpleEntrySet.builder(WoodType.class, "ladder",
//                        getModBlock("oak_ladder"), () -> WoodTypeRegistry.OAK_TYPE,
//                        w -> new BBBLadderBlock(1, BlockBehaviour.Properties.copy(BBBBlocks.OAK_LADDER)))
//                .addTag(modRes("ladders"), Registries.BLOCK)
//                .addTag(modRes("ladders"), Registries.ITEM)
//                .copyParentDrop()
//                .defaultRecipe()
//                .setTab(getModTab(MOD_ID))
//                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
//                .setRenderType(() -> RenderType::cutout)
//                .useMergedPalette()
//                .addTexture(modRes("block/ladder/oak/oak"))
//                .addTexture(modRes("block/ladder/spruce/spruce"))
//                .addTexture(modRes("block/ladder/birch/birch"))
//                .addTexture(modRes("block/ladder/jungle/jungle"))
//                .addTexture(modRes("block/ladder/acacia/acacia"))
//                .addTexture(modRes("block/ladder/dark_oak/dark_oak"))
//                .addTexture(modRes("block/ladder/mangrove/mangrove"))
//                .addTexture(modRes("block/ladder/cherry/cherry"))
//                .build();
//
//        this.addEntry(ladders);

        lattices = SimpleEntrySet.builder(WoodType.class, "lattice",
                        getModBlock("oak_lattice"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new LatticeBlock(BlockBehaviour.Properties.ofFullCopy(BBBBlocks.LATTICE.get(BBBWoodType.OAK).get())))
                .addTag(modRes("lattices"), Registries.BLOCK)
                .addTag(modRes("lattices"), Registries.ITEM)
                .addCustomItem((wood, block, properties) -> new DescriptionBlockItem(block, properties))
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/lattice/oak"))
                .addTexture(ResourceLocation.tryParse("minecraft:block/oak_log"))
                .addTexture(ResourceLocation.tryParse("minecraft:block/oak_log_top"))
                .build();

        this.addEntry(lattices);


        EveryCompatAPI.registerModule(bbb);
    }
}
