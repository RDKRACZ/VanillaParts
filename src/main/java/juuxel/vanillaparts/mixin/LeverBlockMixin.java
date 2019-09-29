package juuxel.vanillaparts.mixin;

import alexiil.mc.lib.multipart.api.MultipartContainer;
import alexiil.mc.lib.multipart.api.NativeMultipart;
import juuxel.vanillaparts.VanillaParts;
import juuxel.vanillaparts.part.LeverPart;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeverBlock;
import net.minecraft.block.WallMountedBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Collections;
import java.util.List;

@Mixin(LeverBlock.class)
public class LeverBlockMixin extends WallMountedBlock implements NativeMultipart {
    private LeverBlockMixin(Settings settings) {
        super(settings);
    }

    @Override
    public List<MultipartContainer.MultipartCreator> getMultipartConversion(World world, BlockPos pos, BlockState state) {
        return Collections.singletonList(holder -> new LeverPart(VanillaParts.LEVER, holder, state.get(FACE), state.get(FACING), state.get(LeverBlock.POWERED)));
    }
}
