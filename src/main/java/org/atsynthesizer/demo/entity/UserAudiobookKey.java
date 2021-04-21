package org.atsynthesizer.demo.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class UserAudiobookKey implements Serializable {

    @Column(name = "user_id")
    Long userId;

    @Column(name = "audiobook_id")
    Long audiobookId;

    // standard constructors, getters, and setters
    // hashcode and equals implementation

    public UserAudiobookKey(){
    }

    public UserAudiobookKey(Long userId, Long audiobookId){
        this.userId = userId;
        this.audiobookId = audiobookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAudiobookKey ratingKey = (UserAudiobookKey) o;
        return Objects.equals(userId, ratingKey.userId) &&
                Objects.equals(audiobookId, ratingKey.audiobookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, audiobookId);
    }
}

