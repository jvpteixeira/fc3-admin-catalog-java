package com.fullcycle.admin.catalog.infrastructure.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public record CreateCategoryApiInput(
        @JsonProperty String name,
        @JsonProperty("description") String description,
        @JsonProperty("is_active") Boolean active
) {
}
