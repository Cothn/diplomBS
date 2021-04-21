package org.atsynthesizer.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "query")
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "audiobook_id", nullable = false)
    private Long audiobookId;

    public Long getId() {
        return id;
    }

    @Column(name = "send_DateTime", nullable = false)
    private Timestamp sendDateTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAudiobookId() {
        return audiobookId;
    }

    public void setAudiobookId(Long audiobookId) {
        this.audiobookId = audiobookId;
    }

    public Timestamp getSendDateTime() {
        return sendDateTime;
    }

    public void setSendDateTime(Timestamp sendDateTime) {
        this.sendDateTime = sendDateTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "Id=" + id +
                ", userId=" + userId +
                ", audiobookId=" + audiobookId +
                ", sendDateTime=" + sendDateTime +
                '}';
    }


}
