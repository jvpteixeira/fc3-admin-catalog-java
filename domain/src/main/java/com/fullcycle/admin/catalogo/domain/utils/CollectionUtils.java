package com.fullcycle.admin.catalogo.domain.utils;

import com.fullcycle.admin.catalogo.domain.Identifier;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class CollectionUtils {

    private CollectionUtils() {
    }

    public static <IN,OUT> Set<OUT> mapTo(final Set<IN> ids, final Function<IN, OUT> mapper) {
        return ids.stream().map(mapper).collect(Collectors.toSet());
    }
}
