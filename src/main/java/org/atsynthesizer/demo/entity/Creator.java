package org.atsynthesizer.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "creator")
public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title",  nullable = false)
    private String title;

    @Column(name = "author",  nullable = false)
    private boolean author;

    @Override
    public String toString() {
        return "Creator{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAuthor() {
        return author;
    }

    public void setAuthor(boolean author) {
        this.author = author;
    }

    public Boolean Author() { return author; }

    public Long getId() {
        return id;
    }
}
