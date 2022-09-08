package com.fullcycle.admin.catalog.infrastructure.category.presenters;

import com.fullcycle.admin.catalog.application.category.retrieve.get.CategoryOutput;
import com.fullcycle.admin.catalog.infrastructure.category.models.CategoryAPIOutput;

import java.util.function.Function;

public interface CategoryApiPresenter {

    Function<CategoryOutput, CategoryAPIOutput> present =
            output -> new CategoryAPIOutput(
                    output.id().getValue(),
                    output.name(),
                    output.description(),
                    output.isActive(),
                    output.createdAt(),
                    output.updatedAt(),
                    output.deletedAt()
            );

    static CategoryAPIOutput present(final CategoryOutput output){
        return new CategoryAPIOutput(
                output.id().getValue(),
                output.name(),
                output.description(),
                output.isActive(),
                output.createdAt(),
                output.updatedAt(),
                output.deletedAt()
        );
    }
}
