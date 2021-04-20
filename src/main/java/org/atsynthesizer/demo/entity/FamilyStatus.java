package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "familyStatus")
public class FamilyStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "title", length = 45, nullable = false)
    private String title;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
