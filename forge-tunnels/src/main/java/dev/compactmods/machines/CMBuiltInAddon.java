package dev.compactmods.machines;

import dev.compactmods.machines.api.CompactMachinesAddon;
import dev.compactmods.machines.api.ICompactMachinesAddon;
import dev.compactmods.machines.api.inject.InjectField;
import dev.compactmods.machines.api.room.IRoomOwnerLookup;
import dev.compactmods.machines.api.room.registration.IRoomSpawnLookup;
import dev.compactmods.machines.tunnel.BuiltInTunnels;
import dev.compactmods.machines.upgrade.BuiltInUpgradeActions;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.function.Supplier;

@CompactMachinesAddon
public class CMBuiltInAddon implements ICompactMachinesAddon {

    @InjectField
    public Supplier<IRoomOwnerLookup> roomOwnerLookup;

    @InjectField
    public Supplier<IRoomSpawnLookup> roomSpawnLookup;

    private static CMBuiltInAddon INSTANCE;

    public CMBuiltInAddon() {
        INSTANCE = this;
        BuiltInTunnels.prepare();
        BuiltInUpgradeActions.prepare();
    }

    @Override
    public void afterRegistration() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        BuiltInTunnels.REGISTRATION.register(bus);
        BuiltInUpgradeActions.REGISTRATION.register(bus);
    }
}
