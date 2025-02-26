package dev.compactmods.machines.upgrade;

import dev.compactmods.machines.api.core.Tooltips;
import dev.compactmods.machines.api.upgrade.RoomUpgradeHelper;
import dev.compactmods.machines.i18n.TranslationUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RoomUpgradeItem extends Item {

    public RoomUpgradeItem(Properties props) {
        super(props);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> info, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            info.add(TranslationUtil.tooltip(Tooltips.TUTORIAL_APPLY_ROOM_UPGRADE).withStyle(ChatFormatting.ITALIC));
        } else {
            info.add(TranslationUtil.tooltip(Tooltips.HINT_HOLD_SHIFT).withStyle(ChatFormatting.DARK_GRAY));
        }

        // Show upgrade type while sneaking, or if advanced tooltips are on
        if (Screen.hasShiftDown() || flag.isAdvanced()) {
            RoomUpgradeHelper.getUpgradeId(stack).ifPresent(upgType -> {
                info.add(TranslationUtil.tooltip(Tooltips.ROOM_UPGRADE_TYPE, upgType).withStyle(ChatFormatting.DARK_GRAY));
            });
        }
    }
}
