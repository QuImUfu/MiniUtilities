package onelemonyboi.miniutilities.blocks.complexblocks.solarpanels;

import com.google.common.collect.Lists;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import onelemonyboi.lemonlib.blocks.block.BlockBase;
import onelemonyboi.miniutilities.trait.BlockBehaviours;

import javax.annotation.Nullable;
import java.util.List;

public class SolarPanelController extends BlockBase {
    public SolarPanelController() {
        super(Properties.create(Material.IRON), BlockBehaviours.solarPanelController);
    }

    public boolean controllerPresent(World world, BlockPos pos, List<BlockPos> blockPosList) {
        for (Direction d : Direction.Plane.HORIZONTAL) {
            if (!world.isAreaLoaded(pos.offset(d), 1) || blockPosList.contains(pos.offset(d))) continue;
            BlockState state = world.getBlockState(pos.offset(d));
            if (state.getBlock() instanceof SolarPanelBlock || state.getBlock() instanceof LunarPanelBlock) {
                blockPosList.add(pos.offset(d));
                return controllerPresent(world, pos.offset(d), blockPosList);
            }
            if (state.getBlock() instanceof SolarPanelController) return true;
        }
        return false;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (controllerPresent(world, pos, Lists.newArrayList(pos))) world.destroyBlock(pos, true);
        super.onBlockPlacedBy(world, pos, state, placer, stack);
    }
}