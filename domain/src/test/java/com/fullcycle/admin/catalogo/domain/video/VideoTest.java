package com.fullcycle.admin.catalogo.domain.video;

import com.fullcycle.admin.catalogo.domain.category.CategoryID;
import com.fullcycle.admin.catalogo.domain.genre.Genre;
import com.fullcycle.admin.catalogo.domain.genre.GenreID;
import com.fullcycle.admin.catalogo.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.Set;

public class VideoTest {

    @Test
    public void givenValidParams_whenCallsNewVideo_shouldInstantiate(){
//        // given
//        final var expectedTitle = "System Design Interviews";
//        final var expectedDescription =
//        """
//                Mauris est lectus, rutrum id scelerisque vel, sagittis eu augue. Etiam pulvinar dolor in ante feugiat, sed congue ante venenatis. Integer quis nunc non arcu molestie placerat in quis ipsum. Morbi in purus interdum, malesuada purus in, mollis lacus. Donec cursus molestie interdum. Nunc aliquet felis elit, nec tristique dolor auctor eget.
//        """;
//        final var expectedLaunchedAt = Year.of(2022);
//        final var expectedDuration = 120.0;
//        final var expectedOpened = false;
//        final var expectedPublished = false;
//        final var expectedRating = Rating.L;
//        final var expectedCategories = Set.of(CategoryID.unique());
//        final var expectedGenres = Set.of(GenreID.unique());
//        final var expectedMembers = Set.of(CastMemberID.unique());
//
//        // when
//
//        final var actualVideo = Video.newVideo(
//                expectedTitle,
//                expectedDescription,
//                expectedLaunchedAt,
//                expectedDuration,
//                expectedOpened,
//                expectedPublished,
//                expectedRating,
//                expectedCategories,
//                expectedGenres,
//                expectedMembers
//        );
//
//        // then
//        Assertions.assertNotNull(actualVideo);
//        Assertions.assertNotNull(actualVideo.getId());
//        Assertions.assertEquals(expectedTitle, actualVideo.getTitle());
//        Assertions.assertEquals(expectedDescription, actualVideo.getDescription());
//        Assertions.assertEquals(expectedLaunchedAt, actualVideo.getLaunchedAt());
//        Assertions.assertEquals(expectedDuration, actualVideo.getDuration());
//        Assertions.assertEquals(expectedOpened, actualVideo.getOpened());
//        Assertions.assertEquals(expectedPublished, actualVideo.getPublished());
//        Assertions.assertEquals(expectedRating, actualVideo.getRating());
//        Assertions.assertEquals(expectedCategories, actualVideo.getCategories());
//        Assertions.assertEquals(expectedGenres, actualVideo.getGenres());
//        Assertions.assertEquals(expectedMembers, actualVideo.getMembers());
//        Assertions.assertTrue(actualVideo.getVideo().isEmpty());
//        Assertions.assertTrue(actualVideo.getTrailer().isEmpty());
//        Assertions.assertTrue(actualVideo.getBanner().isEmpty());
//        Assertions.assertTrue(actualVideo.getThumbernail().isEmpty());
//        Assertions.assertTrue(actualVideo.getThumbernailHalf().isEmpty());
//
//        Assertions.assertDoesNotThrow(() -> actualVideo.validate(new ThrowsValidationHandler()));
    }
}
