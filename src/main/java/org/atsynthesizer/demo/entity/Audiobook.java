package org.atsynthesizer.demo.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "audiobook")
public class Audiobook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    
}
