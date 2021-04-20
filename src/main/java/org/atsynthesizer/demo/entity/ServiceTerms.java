package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "serviceTerms")
public class ServiceTerms {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private long id;
  private String title;
  private long serviceDuration;
  private double percents;
  private long type;
  private long currencyId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public long getServiceDuration() {
    return serviceDuration;
  }

  public void setServiceDuration(long serviceDuration) {
    this.serviceDuration = serviceDuration;
  }


  public double getPercents() {
    return percents;
  }

  public void setPercents(double percents) {
    this.percents = percents;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public long getCurrencyId() {
    return currencyId;
  }

  public void setCurrencyId(long currencyId) {
    this.currencyId = currencyId;
  }

}
