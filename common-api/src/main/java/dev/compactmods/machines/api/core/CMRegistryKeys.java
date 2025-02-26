package dev.compactmods.machines.api.core;

import dev.compactmods.machines.api.upgrade.RoomUpgradeAction;
import dev.compactmods.machines.api.tunnels.TunnelDefinition;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import static dev.compactmods.machines.api.core.Constants.MOD_ID;

public interface CMRegistryKeys {

    ResourceKey<Registry<TunnelDefinition>> TYPES_REG_KEY = ResourceKey.createRegistryKey(new ResourceLocation(MOD_ID, "tunnel_types"));

    ResourceKey<Registry<RoomUpgradeAction>> UPGRADE_ACTIONS = ResourceKey.createRegistryKey(new ResourceLocation(MOD_ID, "upgrade_actions"));
}
