package org.atsynthesizer.demo.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title",  nullable = false)
    private String title;
/*
    @Transient
    @OneToMany(mappedBy = "role")
    private Set<User> users;
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
    */

    public Role() {
    }

    public Role(Long id) {
        this.id = id;
    }

    public Role(Long id, String title) {
        this.id = id;
        this.title = title;
    }



    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getAuthority() {
        return getTitle();
    }
}
