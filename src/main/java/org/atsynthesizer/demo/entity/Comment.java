package org.atsynthesizer.demo.entity;




import org.thymeleaf.util.StringUtils;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "audiobook_id", nullable = false)
    private Audiobook audiobook;

    @Column(name = "text", length = 510, nullable = false)
    private String text;

    public Long getId() {
        return id;
    }

    @Column(name = "send_date_time", nullable = false)
    private Timestamp sendDateTime;

    @Transient
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    public String getSendDateString() {

        return sdf.format(sendDateTime);
    }

    public Audiobook getAudiobook() {
        return audiobook;
    }

    public void setAudiobook(Audiobook audiobook) {
        this.audiobook = audiobook;
    }

    public String getText() {
        return text;
    }

    public String getHtmlText() {
        return StringUtils.replace(text, "\n", "<br/>");
    }

    public void setText(String text) {
        this.text = text;
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
                ", user=" + user +
                ", audiobookId=" + audiobook +
                ", text='" + text + '\'' +
                ", sendDateTime=" + sendDateTime +
                '}';
    }


}
