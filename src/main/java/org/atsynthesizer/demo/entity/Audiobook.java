package org.atsynthesizer.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @NotNull
    @Column(name = "distributed",  nullable = false)
    private boolean distributed;

    @NotNull
    @Column(name = "title", length = 45, nullable = false)
    private String title;

    @Column(name = "picture_path", length = 500, nullable = true)
    private String picturePath;

    @Column(name = "publication_year", nullable = true)
    private int publicationYear;

    @NotNull
    @Column(name = "description", length = 2100, nullable = false)
    private String description;

    @NotNull
    @Column(name = "add_date", nullable = false)
    private Timestamp addDate;

    @NotNull
    @Column(name = "rating", nullable = false)
    private Double rating;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "audiobook_file_id", nullable = false)
    private AudiobookFile audiobookFile;


    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @OneToMany(mappedBy="audiobook", cascade = CascadeType.ALL)
    private List<Comment> comments;

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

    @Transient
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Audiobook() {
    }

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

    public String getAddDateString() {

        return sdf.format(addDate);
    }



    public void setAddDate(Timestamp addDate) {
        this.addDate = addDate;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
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

     public String getAuthorsString(int maxCount) {
         List<Creator> authors = new ArrayList<>(audiobookCreators);
         authors.removeIf(el -> (!el.Author()));

         Creator author = authors.get(0);
         String result = author.getTitle();

         int i = 1;
         author = authors.get(i);
         while ((i < maxCount) && !Objects.isNull(author)){
             result += ", "+ author.getTitle();
             i++;
             author = authors.get(i);
         }
         result += ".";
         return result;
    }

    public void setAudiobookCreators(List<Creator> audiobookCreators) {
        this.audiobookCreators = audiobookCreators;
    }

    public List<Genre> getAudiobookGenres() {
        return audiobookGenres;
    }

    public String getGenresString(int maxCount) {
        Genre genre = audiobookGenres.get(0);
        String result = genre.getTitle();

        int i = 1;
        genre = audiobookGenres.get(i);
        while ((i < maxCount) && !Objects.isNull(genre)){
            result += ", "+ genre.getTitle();
            i++;
            genre = audiobookGenres.get(i);
        }
        result += ".";

        return result;
    }

    public void setAudiobookGenres(List<Genre> audiobookGenres) {
        this.audiobookGenres = audiobookGenres;
    }

    public String getPerformersString(int maxCount) {
        List<Creator> performers = new ArrayList<>(audiobookCreators);
        performers.removeIf(el -> (el.Author()));

        Creator performer = performers.get(0);
        String result = performer.getTitle();

        int i = 1;
        performer = performers.get(i);
        while ((i < maxCount) && !Objects.isNull(performer)){
            result += ", "+ performer.getTitle();
            i++;
            performer = performers.get(i);
        }
        result += ".";
        return result;
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
                ", audiobookCreators={" + audiobookCreators + '}' +
                ", audiobookGenres={" + audiobookGenres + '}' +
                '}';
    }
}
