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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "audiobook_id")
    private Audiobook audiobook;

    public Long getId() {
        return id;
    }

    @Column(name = "send_Date_Time", nullable = false)
    private Timestamp sendDateTime;


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
                ", user=" + user +
                ", audiobook=" + audiobook +
                ", sendDateTime=" + sendDateTime +
                '}';
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

    public Audiobook getAudiobook() {
        return audiobook;
    }

    public void setAudiobook(Audiobook audiobook) {
        this.audiobook = audiobook;
    }
}
