package dev.compactmods.machines.villager;

import dev.compactmods.machines.api.core.Constants;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID)
public class VillagerTradesEventHandler {

//    @SubscribeEvent
//    public static void onVillagerTrades(final VillagerTradesEvent trades) {
//        final var tinkerer = Villagers.TINKERER.get();
//        if(!trades.getType().equals(tinkerer))
//            return;
//
//        final var tradeList = trades.getTrades();
//        tradeList.get(1).add(Villagers.TEST_TRADE.get());
//    }
}
