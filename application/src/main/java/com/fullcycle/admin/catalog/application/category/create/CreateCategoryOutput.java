package com.fullcycle.admin.catalog.application.category.create;

import com.fullcycle.admin.catalog.domain.category.Category;
import com.fullcycle.admin.catalog.domain.category.CategoryID;

public record CreateCategoryOutput(
        CategoryID id
){
    public static CreateCategoryOutput from(final String anId){
        return new CreateCategoryOutput(CategoryID.from(anId));
    }

    public static CreateCategoryOutput from(final Category aCategory){
        return new CreateCategoryOutput(aCategory.getId());
    }
}
