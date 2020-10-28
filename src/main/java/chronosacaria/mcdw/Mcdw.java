package chronosacaria.mcdw;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import chronosacaria.mcdw.weapons.*;
//import chronosacaria.mcdw.entity.McdwEntities;



public class Mcdw implements ModInitializer {

    public static final String MOD_ID = "mcdw";

    public static final ItemGroup WEAPONS = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "weapons"),
            () -> new ItemStack(Claymores.SWORD_HEARTSTEALER));
    public static final ItemGroup RANGED = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "weapons/bows"),
            () -> new ItemStack(Bows.BOW_LONGBOW));

    @Override
    public void onInitialize() {

        // Melee Weapons
        Claymores.init();
        Curves.init();
        Daggers.init();
        Glaives.init();
        Katanas.init();
        Sickles.init();
        SoulDaggers.init();
        Scythes.init();
        Spears.init();
        Swords.init();
        Whips.init();
        Staves.init();
        Rapiers.init();
        Axes.init();
        DoubleAxes.init();
        Hammers.init();

        // Tools
        Picks.init();

        // Ranged
        Bows.init();
    }

    /*public static void register(){
        McdwEntities.register();
    }*/

    /*public static void registerServerboundPackets(){
        ServerSidePacketRegistry.INSTANCE.register(C2SRotateHeldItem.ID, C2SRotateHeldItem::onPacket);
    }*/
}
