package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "account")
public class Account {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private int id;
  private String number;
  private String title;

  @ManyToOne
  @JoinColumn(name = "client_id", nullable = false)
  private Client client;

  private String codeFromPlan;
  private int activity;
  private int debit;
  private int credit;
  private int saldo;


  public long getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }


  public String getCodeFromPlan() {
    return codeFromPlan;
  }

  public void setCodeFromPlan(String codeFromPlan) {
    this.codeFromPlan = codeFromPlan;
  }


  public int getActivity() {
    return activity;
  }

  public void setActivity(int activity) {
    this.activity = activity;
  }


  public int getDebit() {
    return debit;
  }

  public void setDebit(int debit) {
    this.debit = debit;
  }


  public int getCredit() {
    return credit;
  }

  public void setCredit(int credit) {
    this.credit = credit;
  }


  public int getSaldo() {
    return saldo;
  }

  public void setSaldo(int saldo) {
    this.saldo = saldo;
  }

}
