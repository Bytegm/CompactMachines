package dev.compactmods.machines.command.subcommand;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import dev.compactmods.machines.CompactMachines;
import dev.compactmods.machines.api.core.CMCommands;
import dev.compactmods.machines.api.core.Messages;
import dev.compactmods.machines.config.ServerConfig;
import dev.compactmods.machines.i18n.TranslationUtil;
import dev.compactmods.machines.machine.item.BoundCompactMachineItem;
import dev.compactmods.machines.room.graph.CompactRoomProvider;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.world.item.ItemStack;

public class CMGiveMachineSubcommand {

    public static LiteralArgumentBuilder<CommandSourceStack> make() {
        final var subRoot = Commands.literal("give")
                .requires(cs -> cs.hasPermission(ServerConfig.giveMachineLevel()));

        subRoot.then(Commands.argument("player", EntityArgument.player())
                .then(Commands.argument("dev/compactmods/machines/api/room", StringArgumentType.string())
                        .executes(CMGiveMachineSubcommand::giveMachine)));

        return subRoot;
    }

    private static int giveMachine(CommandContext<CommandSourceStack> ctx) throws CommandSyntaxException {
        final var src = ctx.getSource();
        final var player = EntityArgument.getPlayer(ctx, "player");
        final var roomCode = StringArgumentType.getString(ctx, "dev/compactmods/machines/api/room");

        var roomProvider = CompactRoomProvider.instance(src.getServer());
        roomProvider.forRoom(roomCode).ifPresentOrElse(room -> {
            ItemStack newItem = BoundCompactMachineItem.createForRoom(room);
            if (!player.addItem(newItem)) {
                src.sendFailure(TranslationUtil.command(CMCommands.CANNOT_GIVE_MACHINE));
            } else {
                src.sendSuccess(TranslationUtil.command(CMCommands.MACHINE_GIVEN, player.getDisplayName()), true);
            }
        }, () -> {
            CompactMachines.LOGGER.error("Error giving player a new machine block: room not found.");
            src.sendFailure(TranslationUtil.message(Messages.UNKNOWN_ROOM_CHUNK, roomCode));
        });

        return 0;
    }
}

