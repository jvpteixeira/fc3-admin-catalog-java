package com.fullcycle.admin.catalog.domain.genre;

import com.fullcycle.admin.catalog.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

public class GenreID extends Identifier {
    private final String value;

    private GenreID(String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static GenreID unique(){
        return GenreID.from(UUID.randomUUID());
    }

    public static GenreID from(final String anId){
        return new GenreID(anId);
    }

    public static GenreID from(final UUID anId){
        return new GenreID(anId.toString().toLowerCase());
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreID genreId = (GenreID) o;
        return Objects.equals(value, genreId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
