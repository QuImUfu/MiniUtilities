package onelemonyboi.miniutilities.init;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import onelemonyboi.miniutilities.ModRegistry;
<<<<<<< Updated upstream
import onelemonyboi.miniutilities.tileentities.MechanicalMinerTile;
import onelemonyboi.miniutilities.tileentities.DrumTile;
=======
import onelemonyboi.miniutilities.blocks.complexblocks.mechanicalblocks.tileentities.MechanicalMinerTile;
import onelemonyboi.miniutilities.blocks.complexblocks.mechanicalblocks.tileentities.DrumTile;
import onelemonyboi.miniutilities.blocks.complexblocks.mechanicalblocks.tileentities.MechanicalPlacerTile;
>>>>>>> Stashed changes

public class TEList {
    public static final RegistryObject<TileEntityType<DrumTile>> DrumTile = ModRegistry.TE.register("drum", () -> TileEntityType.Builder.create(DrumTile::new, BlockList.StoneDrum.get(), BlockList.IronDrum.get(), BlockList.ReinforcedLargeDrum.get(), BlockList.NetheriteReinforcedDrum.get(), BlockList.UnstableDrum.get()).build(null));
    public static final RegistryObject<TileEntityType<MechanicalMinerTile>> MechanicalMinerTile = ModRegistry.TE.register("mechanical_miner", () -> TileEntityType.Builder.create(() -> new MechanicalMinerTile(), BlockList.MechanicalMiner.get()).build(null));

    public static void register() {}
}
