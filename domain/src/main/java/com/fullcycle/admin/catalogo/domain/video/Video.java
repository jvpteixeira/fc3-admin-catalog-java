package com.fullcycle.admin.catalogo.domain.video;

import com.fullcycle.admin.catalogo.domain.AggregateRoot;
import com.fullcycle.admin.catalogo.domain.category.CategoryID;
import com.fullcycle.admin.catalogo.domain.genre.GenreID;
import com.fullcycle.admin.catalogo.domain.utils.InstantUtils;
import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;

import javax.swing.text.html.Option;
import java.time.Instant;
import java.time.Year;
import java.util.*;

public class Video extends AggregateRoot<VideoID> {

    private String title;
    private String description;
    private Year launchedAt;
    private double duration;

    private boolean opened;
    private boolean published;
    private Rating rating;

    private Instant createdAt;
    private Instant updatedAt;

    private ImageMedia banner;
    private ImageMedia thumbnail;
    private ImageMedia thumbnailHalf;

    private AudioVideoMedia trailer;
    private AudioVideoMedia video;

    private Set<CategoryID> categories;
    private Set<GenreID> genres;
//    private Set<CastMember> castMembers; TODO: Castmember


    private Video(
            final VideoID videoID,
            final String aTitle,
            final String aDescription,
            final Year aLaunchYear,
            final double aDuration,
            final boolean wasOpened,
            final boolean wasPublished,
            final Rating aRating,
            final Instant aCreationDate,
            final Instant aUpdatedDate,
            final ImageMedia aBanner,
            final ImageMedia aThumb,
            final ImageMedia aThumbHalf,
            final AudioVideoMedia aTrailer,
            final AudioVideoMedia aVideo,
            final Set<CategoryID> categories,
            final Set<GenreID> genres
//            final Set<CastMemberID> members TODO: CastMembers
    ) {
        super(videoID);
        this.title = aTitle;
        this.description = aDescription;
        this.launchedAt = aLaunchYear;
        this.duration = aDuration;
        this.opened = wasOpened;
        this.published = wasPublished;
        this.rating = aRating;
        this.createdAt = aCreationDate;
        this.updatedAt = aUpdatedDate;
        this.banner = aBanner;
        this.thumbnail = aThumb;
        this.thumbnailHalf = aThumbHalf;
        this.trailer = aTrailer;
        this.video = aVideo;
        this.categories = categories;
        this.genres = genres;
//        this.castMembers = members; TODO: CastMembers
    }

    @Override
    public void validate(ValidationHandler handler) {
        new VideoValidator(this, handler).validate();
    }

    public Video update(
        final String aTitle,
        final String aDescription,
        final Year aLaunchYear,
        final double aDuration,
        final boolean wasOpened,
        final boolean wasPublished,
        final Rating aRating,
        final Set<CategoryID> categories,
        final Set<GenreID> genres
    ){
        this.title = aTitle;
        this.description = aDescription;
        this.launchedAt = aLaunchYear;
        this.duration = aDuration;
        this.opened = wasOpened;
        this.published = wasPublished;
        this.rating = aRating;
        this.setCategories(categories);
        this.setGenres(genres);
//        this.setCastMembers(members); TODO: Implementar CastMembers
        this.updatedAt = InstantUtils.now();
        return this;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Year getLaunchedAt() {
        return launchedAt;
    }

    public void setLaunchedAt(final Year launchedAt) {
        this.launchedAt = launchedAt;
    }

    public double getDuration() {
        return duration;
    }


    public boolean getOpened() {
        return opened;
    }

    public boolean getPublished() {
        return published;
    }

    public Rating getRating() {
        return rating;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Optional<ImageMedia> getBanner() {
        return Optional.ofNullable(banner);
    }

    public Video setBanner(ImageMedia banner) {
        this.banner = banner;
        this.updatedAt = InstantUtils.now();
        return this;
    }

    public Optional<ImageMedia> getThumbnail() {
        return Optional.ofNullable(thumbnail);
    }

    public Video setThumbnail(ImageMedia thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public Optional<ImageMedia> getThumbnailHalf() {
        return Optional.ofNullable(thumbnailHalf);
    }

    public Video setThumbnailHalf(ImageMedia thumbnailHalf) {
        this.thumbnailHalf = thumbnailHalf;
        return this;
    }

    public Optional<AudioVideoMedia> getTrailer() {
        return Optional.of(trailer);
    }

    public Video setTrailer(AudioVideoMedia trailer) {
        this.trailer = trailer;
        this.updatedAt = InstantUtils.now();
        return this;
    }

    public Optional<AudioVideoMedia> getVideo() {
        return Optional.of(video);
    }

    public Video setVideo(AudioVideoMedia video) {
        this.video = video;
        this.updatedAt = InstantUtils.now();
        return this;
    }

    public Set<CategoryID> getCategories() {
        return categories != null ? Collections.unmodifiableSet(categories) : Collections.emptySet();
    }

    private void setCategories(Set<CategoryID> categories) {
        this.categories = categories;
    }

    public Set<GenreID> getGenres() {
        return genres != null ? Collections.unmodifiableSet(genres) : Collections.emptySet();
    }

    private void setGenres(final Set<GenreID> genres) {
        this.genres = genres != null ? new HashSet<>(genres) : Collections.emptySet();
    }
    //TODO: Getters and Setters of CastMembers

    public static Video newVideo(
        final String aTitle,
        final String aDescription,
        final Year aLaunchYear,
        final double aDuration,
        final boolean wasOpened,
        final boolean wasPublished,
        final Rating aRating,
        final Set<CategoryID> categories,
        final Set<GenreID> genres
//      final Set<CastMemberID> members TODO: CastMembers)
    ) {
        final var now = InstantUtils.now();
        final var anId = VideoID.unique();
        return new Video(
            anId,
            aTitle,
            aDescription,
            aLaunchYear,
            aDuration,
            wasOpened,
            wasPublished,
            aRating,
            now,
            now,
            null,
            null,
            null,
            null,
            null,
            categories,
            genres
        );
    }

//    public static Video newVideo(
//            final Video aVideo
//    ) {
//        return new Video(
//            aVideo.getId(),
//            aVideo.getTitle(),
//            aVideo.getDescription(),
//            aVideo.getLaunchedAt(),
//            aVideo.getDuration(),
//            aVideo.getOpened(),
//            aVideo.getCreatedAt(),
//            aVideo.getUpdatedAt(),
//            aVideo.getBanner().orElse(null),
//            aVideo.getThumbnail().orElse(null),
//            aVideo.getThumbnailHalf().orElse(null),
//            aVideo.getTrailer().orElse(null),
//            aVideo.getVideo().orElse(null),
//            new HashSet<>(aVideo.getCategories()),
//            new HashSet<>(aVideo.getGenres())
//            //                new HashSet<>(aVideo.getCastMembers()), TODO: CastMembers
//        );
//    }

    public static Video with(
            final VideoID videoID,
            final String aTitle,
            final String aDescription,
            final Year aLaunchYear,
            final double aDuration,
            final boolean wasOpened,
            final boolean wasPublished,
            final Rating aRating,
            final Instant aCreationDate,
            final Instant aUpdatedDate,
            final ImageMedia aBanner,
            final ImageMedia aThumb,
            final ImageMedia aThumbHalf,
            final AudioVideoMedia aTrailer,
            final AudioVideoMedia aVideo,
            final Set<CategoryID> categories,
            final Set<GenreID> genres
    ){
        return new Video(
            videoID,
            aTitle,
            aDescription,
            aLaunchYear,
            aDuration,
            wasOpened,
            wasPublished,
            aRating,
            aCreationDate,
            aUpdatedDate,
            aBanner,
            aThumb,
            aThumbHalf,
            aTrailer,
            aVideo,
            categories,
            genres
        );
    }
}
