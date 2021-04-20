package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "serviceContract")
public class ServiceContract {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private int id;
  private int sum;
  private java.sql.Date startDate;
  private java.sql.Date endDate;


  @ManyToOne
  @JoinColumn(name = "percentAccount_id", nullable = false)
  private Account percentAccount;

  @ManyToOne
  @JoinColumn(name = "activeAccount_id", nullable = false)
  private Account  activeAccount;

  @ManyToOne
  @JoinColumn(name = "serviceTerms_id", nullable = false)
  private ServiceTerms serviceTerms;

  @ManyToOne
  @JoinColumn(name = "client_id", nullable = false)
  private Client client;



  public java.sql.Date getStartDate() {
    return startDate;
  }

  public void setStartDate(java.sql.Date startDate) {
    this.startDate = startDate;
  }


  public java.sql.Date getEndDate() {
    return endDate;
  }

  public void setEndDate(java.sql.Date endDate) {
    this.endDate = endDate;
  }


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;
  }

  public Account getPercentAccount() {
    return percentAccount;
  }

  public void setPercentAccount(Account percentAccount) {
    this.percentAccount = percentAccount;
  }

  public Account getActiveAccount() {
    return activeAccount;
  }

  public void setActiveAccount(Account activeAccount) {
    this.activeAccount = activeAccount;
  }

  public ServiceTerms getServiceTerms() {
    return serviceTerms;
  }

  public void setServiceTerms(ServiceTerms serviceTerms) {
    this.serviceTerms = serviceTerms;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}
