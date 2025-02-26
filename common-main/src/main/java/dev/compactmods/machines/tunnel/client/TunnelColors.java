package dev.compactmods.machines.tunnel.client;

import dev.compactmods.machines.api.tunnels.ITunnelHolder;
import dev.compactmods.machines.api.tunnels.TunnelDefinition;
import dev.compactmods.machines.tunnel.ITunnelItem;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.Optional;

public class TunnelColors {

    public static final BlockColor BLOCK = (state, reader, position, tintIndex) -> {
        try {
            if(reader == null || position == null)
                return TunnelDefinition.NO_INDICATOR_COLOR;

            BlockEntity tile = reader.getBlockEntity(position);
            if (tile instanceof ITunnelHolder tunnel) {
                TunnelDefinition type = tunnel.getTunnelType();
                switch(tintIndex) {
                    case 0:
                        return type.ringColor();

                    case 1:
                        return type.indicatorColor();
                }
            }

            return TunnelDefinition.NO_INDICATOR_COLOR;
        }

        catch(Exception ex) {
            return TunnelDefinition.NO_INDICATOR_COLOR;
        }
    };

    public static final ItemColor ITEM = (stack, tintIndex) -> {
        Optional<TunnelDefinition> definition = ITunnelItem.getDefinition(stack);
        if(definition.isEmpty())
            return 0;

        TunnelDefinition actualDef = definition.get();
        if (tintIndex == 0) {
            return actualDef.ringColor();
        }

        return actualDef.indicatorColor();
    };
}
