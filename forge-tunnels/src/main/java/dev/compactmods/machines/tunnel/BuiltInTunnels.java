package dev.compactmods.machines.tunnel;

import dev.compactmods.machines.api.core.CMRegistryKeys;
import dev.compactmods.machines.api.core.Constants;
import dev.compactmods.machines.api.tunnels.TunnelDefinition;
import dev.compactmods.machines.tunnel.definitions.BufferedItemTunnel;
import dev.compactmods.machines.tunnel.definitions.FluidTunnel;
import dev.compactmods.machines.tunnel.definitions.ForgeEnergyTunnel;
import dev.compactmods.machines.tunnel.definitions.redstone.RedstoneInTunnelDefinition;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class BuiltInTunnels {

    public static DeferredRegister<TunnelDefinition> REGISTRATION = DeferredRegister.create(CMRegistryKeys.TYPES_REG_KEY, Constants.MOD_ID);

    // ================================================================================================================
    //   TUNNEL TYPE DEFINITIONS
    // ================================================================================================================
    public static final RegistryObject<TunnelDefinition> ITEM_TUNNEL_DEF = REGISTRATION.register("item", BufferedItemTunnel::new);

    public static final RegistryObject<TunnelDefinition> FLUID_TUNNEL_DEF = REGISTRATION.register("fluid", FluidTunnel::new);

    public static final RegistryObject<TunnelDefinition> FORGE_ENERGY = REGISTRATION.register("energy", ForgeEnergyTunnel::new);

    public static final RegistryObject<TunnelDefinition> REDSTONE_IN = REGISTRATION.register("redstone_in", RedstoneInTunnelDefinition::new);

    public static void prepare() {

    }
}
