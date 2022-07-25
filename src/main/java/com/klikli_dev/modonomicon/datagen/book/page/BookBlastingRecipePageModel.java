/*
 * SPDX-FileCopyrightText: 2022 klikli-dev
 *
 * SPDX-License-Identifier: MIT
 */

package com.klikli_dev.modonomicon.datagen.book.page;

import com.klikli_dev.modonomicon.api.ModonimiconConstants.Data.Page;
import org.jetbrains.annotations.NotNull;

public class BookBlastingRecipePageModel extends BookRecipePageModel {
    protected BookBlastingRecipePageModel(@NotNull String anchor) {
        super(Page.BLASTING_RECIPE, anchor);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends BookRecipePageModel.Builder<Builder> {
        protected Builder() {
            super();
        }

        public BookBlastingRecipePageModel build() {
            BookBlastingRecipePageModel model = new BookBlastingRecipePageModel(this.anchor);
            model.title1 = this.title1;
            model.recipeId1 = this.recipeId1;
            model.title2 = this.title2;
            model.recipeId2 = this.recipeId2;
            model.text = this.text;
            return model;
        }

        @Override
        public Builder getThis() {
            return this;
        }
    }
}
