package com.fullcycle.admin.catalog.domain.genre;

import com.fullcycle.admin.catalog.domain.AggregateRoot;
import com.fullcycle.admin.catalog.domain.category.CategoryID;
import com.fullcycle.admin.catalog.domain.validation.ValidationHandler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Genre extends AggregateRoot<GenreID> {
    private String name;
    private boolean active;
    private List<CategoryID> categories;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;


    public Genre(final GenreID genreId,
                 final String name,
                 final boolean active,
                 final List<CategoryID> categories,
                 final Instant createdAt,
                 final Instant updatedAt,
                 final Instant deletedAt) {
        super(genreId);
        this.name = name;
        this.active = active;
        this.categories = categories;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static Genre newGenre(final String aName, final boolean isActive){
        final var anId = GenreID.unique();
        final var now = Instant.now();
        final var deletedAt = isActive ? null : now;
        return new Genre(anId, aName, isActive, new ArrayList<>(), now, now, deletedAt);
    }


    @Override
    public void validate(ValidationHandler handler) {

    }

    public String getName() {
        return name;
    }

    public List<CategoryID> getCategories() {
        //Somente quem está dentro da entidade pode modificar, senão começamos a ter um modelo anêmico
        return Collections.unmodifiableList(categories);
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }
}
