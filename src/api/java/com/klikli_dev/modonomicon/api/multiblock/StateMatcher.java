/*
 * LGPL-3.0
 *
 * Copyright (C) 2022 Authors of Patchouli
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package com.klikli_dev.modonomicon.api.multiblock;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Objects;

/**
 * A composite element of a rendering block state, and a predicate to validate if the real state in the world is valid
 * or not. Used as the core building block for multiblocks.
 */
public interface StateMatcher {

    /**
     * The state matcher type Id for serialization.
     */
    ResourceLocation getId();

    /**
     * Gets the state displayed by this state matcher for rendering the multiblock page type and the in-world preview.
     *
     * @param ticks World ticks, to allow cycling the state shown.
     */
    BlockState getDisplayedState(long ticks);

    /**
     * Returns a predicate that validates whether the given state is acceptable. This should check the passed in
     * blockstate instead of requerying it from the world, for both performance and correctness reasons -- the state may
     * be rotated for multiblock matching.
     */
    TriPredicate<BlockGetter, BlockPos, BlockState> getStatePredicate();

    /**
     * Serializes the state matcher to the given buffer.
     */
    void toNetwork(FriendlyByteBuf buffer);

}
