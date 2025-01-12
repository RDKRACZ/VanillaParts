/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. */

package juuxel.vanillaparts.mixin;

import alexiil.mc.lib.multipart.api.MultipartContainer;
import alexiil.mc.lib.multipart.api.NativeMultipart;
import juuxel.vanillaparts.lib.Exclusions;
import juuxel.vanillaparts.part.SlabPart;
import juuxel.vanillaparts.part.VpParts;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.SlabType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Collections;
import java.util.List;

@Mixin(SlabBlock.class)
abstract class SlabBlockMixin extends Block implements NativeMultipart {
    private SlabBlockMixin(Settings settings) {
        super(settings);
    }

    @Override
    public List<MultipartContainer.MultipartCreator> getMultipartConversion(World world, BlockPos pos, BlockState state) {
        if (Exclusions.isExcluded(state)) return null;
        SlabType type = state.get(SlabBlock.TYPE);
        if (type == SlabType.DOUBLE) return null;
        return Collections.singletonList(holder -> new SlabPart(VpParts.SLAB, holder, (SlabBlock) (Object) this, type == SlabType.TOP));
    }
}
