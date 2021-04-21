package org.atsynthesizer.demo.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "audiobook")
public class Audiobook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "distributed",  nullable = false)
    private boolean distributed;

    @Column(name = "title", length = 45, nullable = false)
    private String title;

    @Column(name = "picture_path", length = 500, nullable = true)
    private String picturePath;

    @Column(name = "publication_year", nullable = true)
    private int publicationYear;

    @Column(name = "description", length = 2100, nullable = false)
    private String description;

    @Column(name = "add_date", nullable = false)
    private Timestamp addDate;

    @Column(name = "rating", nullable = false)
    private String rating;

    @ManyToOne
    @JoinColumn(name = "audiobook_file_id", nullable = false)
    private AudiobookFile audiobookFile;

        @ManyToMany
        @JoinTable(
                name = "audiobook_creator",
                joinColumns = @JoinColumn(name = "audiobook_id"),
                inverseJoinColumns = @JoinColumn(name = "creator_id"))
        private List<Creator> audiobookCreators;

        @ManyToMany
        @JoinTable(
                name = "audiobook_genre",
                joinColumns = @JoinColumn(name = "audiobook_id"),
                inverseJoinColumns = @JoinColumn(name = "genre_id"))
        private List<Genre> audiobookGenres;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isDistributed() {
        return distributed;
    }

    public void setDistributed(boolean distributed) {
        this.distributed = distributed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getAddDate() {
        return addDate;
    }

    public void setAddDate(Timestamp addDate) {
        this.addDate = addDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public AudiobookFile getAudiobookFile() {
        return audiobookFile;
    }

    public void setAudiobookFile(AudiobookFile audiobookFile) {
        this.audiobookFile = audiobookFile;
    }

    public List<Creator> getAudiobookCreators() {
        return audiobookCreators;
    }

    public void setAudiobookCreators(List<Creator> audiobookCreators) {
        this.audiobookCreators = audiobookCreators;
    }

    public List<Genre> getAudiobookGenres() {
        return audiobookGenres;
    }

    public void setAudiobookGenres(List<Genre> audiobookGenres) {
        this.audiobookGenres = audiobookGenres;
    }



    @Override
    public String toString() {
        return "Audiobook{" +
                "id=" + id +
                ", user=" + user +
                ", distributed='" + distributed + '\'' +
                ", title='" + title + '\'' +
                ", picturePath='" + picturePath + '\'' +
                ", publicationYear=" + publicationYear +
                ", description='" + description + '\'' +
                ", addDate=" + addDate +
                ", rating=" + rating +
                ", audiobookFile=" + audiobookFile +
               // ", audiobookCreators={" + audiobookCreators + '}' +
               // ", audiobookGenres={" + audiobookGenres + '}' +
                '}';
    }
}
