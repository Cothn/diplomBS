package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "currentDate")
public class CurrentDate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private long id;
  private Date currentDate;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public java.sql.Date getCurrentDate() {
    return currentDate;
  }

  public void setCurrentDate(java.sql.Date currentDate) {
    this.currentDate = currentDate;
  }

}
