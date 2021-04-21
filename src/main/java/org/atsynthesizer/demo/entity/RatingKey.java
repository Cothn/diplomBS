package org.atsynthesizer.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class RatingKey implements Serializable {

    @Column(name = "user_id")
    Long userId;

    @Column(name = "audiobook_id")
    Long audiobookId;

    // standard constructors, getters, and setters
    // hashcode and equals implementation

    public RatingKey(){
    }

    public RatingKey(Long userId, Long audiobookId){
        this.userId = userId;
        this.audiobookId = audiobookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingKey ratingKey = (RatingKey) o;
        return Objects.equals(userId, ratingKey.userId) &&
                Objects.equals(audiobookId, ratingKey.audiobookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, audiobookId);
    }


}

