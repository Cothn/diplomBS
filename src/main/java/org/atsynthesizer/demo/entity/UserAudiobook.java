package org.atsynthesizer.demo.entity;

import javax.persistence.*;

@Entity
@IdClass(UserAudiobokKey.class)
@Table(name = "user_audiobook")
public class UserAudiobook {
    @Id
    private Long userId;

    @Id
    private Long audiobookId;

    @ManyToOne
    @MapsId("audiobookId")
    @JoinColumn(name = "audiobook_id")
    private Audiobook userAudiobook;

    @Override
    public String toString() {
        return "UserAudiobook{" +
                "userId=" + userId +
                ", audiobookId=" + audiobookId +
                ", audiobook=" + userAudiobook +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public Long getAudiobookId() {
        return audiobookId;
    }

    public Audiobook getUserAudiobook() {
        return userAudiobook;
    }

    public void setUserAudiobook(Audiobook userAudiobook) {
        this.userAudiobook = userAudiobook;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setAudiobookId(Long audiobookId) {
        this.audiobookId = audiobookId;
    }
}
