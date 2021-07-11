package com.wynnkungz.wkom.common.block;

import com.wynnkungz.wkom.common.te.AlloySmelterTileEntity;
import com.wynnkungz.wkom.core.init.TileEntityTypesInit;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

public class AlloySmelterBlock extends Block {

	protected static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;

	public AlloySmelterBlock() {
		super(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY).hardnessAndResistance(3.5f)
				.harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.STONE).setRequiresTool());
		//set default Facing of the Block in case something will go wrong with the placement, so u don't have errors
		this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH));
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return TileEntityTypesInit.ALLOY_SMELTER_TILE_ENTITY_TYPE.get().create();
	}

	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		//lights the block up when powered with a light level of 13
		return state.get(BlockStateProperties.POWERED) ? 13 : 0;
	}

	@Override
	public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) {
		//rotates the block when placed in the direction of the HORIZONTAL_FACING Property
		return state.with(HORIZONTAL_FACING, direction.rotate(state.get(HORIZONTAL_FACING)));
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		//makes your block always look in the direction of the entity who placed the Block with the front side
		return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if(!worldIn.isRemote()) {
			TileEntity te = worldIn.getTileEntity(pos);
			if(te instanceof AlloySmelterTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (AlloySmelterTileEntity) te, pos);
			}
		}
		return ActionResultType.SUCCESS;
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		worldIn.setBlockState(pos, state.with(BlockStateProperties.POWERED, false));
	}
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(BlockStateProperties.POWERED);
		builder.add(HORIZONTAL_FACING);
	}

}
