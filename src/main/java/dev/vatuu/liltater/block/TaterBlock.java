package dev.vatuu.liltater.block;

import com.google.common.collect.Lists;
import dev.vatuu.liltater.LilTater;
import dev.vatuu.liltater.util.Registrable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

import java.util.List;

public abstract class TaterBlock extends Block implements Registrable {

    public static TaterBlock BLOCK;
    public static Item ITEM;

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty WALL = BooleanProperty.of("wall");

    private static final VoxelShape SHAPE = VoxelShapes.cuboid(6 / 16f, 0, 6 / 16f, 10 / 16f, 7 / 16f, 10 / 16f);
    private static final VoxelShape[] SHAPES_WALL = new VoxelShape[] {
            VoxelShapes.cuboid(6 / 16f, 5 / 16f, 0 / 16f, 10 / 16f, 12 / 16f, 4 / 16f),     //SOUTH
            VoxelShapes.cuboid(12 / 16f, 5 / 16f, 6 / 16f, 16 / 16f, 12 / 16f, 10 / 16f),   //WEST
            VoxelShapes.cuboid(6 / 16f, 5 / 16f, 12 / 16f, 10 / 16f, 12 / 16f, 16 / 16f),   //NORTH
            VoxelShapes.cuboid(0 / 16f, 5 / 16f, 6 / 16f, 4 / 16f, 12 / 16f, 10 / 16f),     //EAST
    };


    private String id;

    public TaterBlock(String id) {
        super(Settings.of(Material.ORGANIC));
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH).with(WALL, false));
        this.id = id;
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView view, BlockPos pos) {
        return true;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, EntityContext context) {
        return getShape(state);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext ePos) {
        return getShape(state);
    }

    private VoxelShape getShape(BlockState state) {
        if(state.get(WALL))
            return SHAPES_WALL[Math.abs(state.get(FACING).getHorizontal())];
        else
            return SHAPE;
    }

    @Override
    public boolean isSimpleFullBlock(BlockState state, BlockView view, BlockPos pos) {
        return false;
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContext.Builder builder) {
        return Lists.newArrayList(new ItemStack(this.asItem()));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
            Direction[] dir = ctx.getPlacementDirections();

            for(int i = 0; i < dir.length; ++i) {
                Direction direction = dir[i];

                BlockState state = this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite()).with(WALL, direction.getAxis() != Direction.Axis.Y);

                if (state.canPlaceAt(ctx.getWorld(), ctx.getBlockPos()))
                    return state;
            }

            return null;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = state.get(FACING);
        BlockPos blockPos = pos.offset(direction.getOpposite());
        BlockState blockState = world.getBlockState(blockPos);
        if(state.get(WALL))
            return blockState.isSideSolidFullSquare(world, blockPos, direction);
        else
            return sideCoversSmallSquare(world, pos.down(), Direction.UP);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(FACING).add(WALL));
    }

    public void register() {
        BLOCK = Registry.register(Registry.BLOCK, new Identifier(LilTater.MOD_ID, id), this);
        ITEM = Registry.register(Registry.ITEM, new Identifier(LilTater.MOD_ID, id), new BlockItem(this, new Item.Settings().rarity(Rarity.EPIC).group(LilTater.GROUP)));
    }
}