package org.atsynthesizer.demo.entity;

import javax.persistence.*;

@Entity
@IdClass(RatingKey.class)
@Table(name = "Rating")
public class Rating {
    @Id
    private Long userId;

    @Id
    private Long audiobookId;

    @Column(name = "value",  nullable = false)
    private int value;

    @Override
    public String toString() {
        return "Rating{" +
                "userId=" + userId +
                ", audiobookId=" + audiobookId +
                ", value=" + value +
                '}';
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getAudiobookId() {
        return audiobookId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setAudiobookId(Long audiobookId) {
        this.audiobookId = audiobookId;
    }

}
