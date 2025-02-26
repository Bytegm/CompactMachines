package dev.compactmods.machines.api.core;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public interface CMTags {
    TagKey<Item> ROOM_UPGRADE_ITEM = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Constants.MOD_ID, "room_upgrade"));
    TagKey<Item> MACHINE_ITEM = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Constants.MOD_ID, "machine"));
    TagKey<Block> MACHINE_BLOCK = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(Constants.MOD_ID, "machine"));

    TagKey<Item> SOLID_WALL_ITEMS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Constants.MOD_ID, "solid_walls"));
    TagKey<Block> SOLID_WALL_BLOCKS = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(Constants.MOD_ID, "solid_walls"));
}
