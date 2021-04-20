package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "surname", length = 45, nullable = false)
    private String surname;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "patronymic", length = 45, nullable = false)
    private String patronymic;

    @Column(name = "birthDate",  nullable = false)
    private Date birthDate;

    @Column(name = "passportSeries", length = 45, nullable = false)
    private String passportSeries;

    @Column(name = "passportNumber", length = 45, nullable = false)
    private String passportNumber;

    @Column(name = "passportOrganization", length = 45, nullable = false)
    private String passportOrganization;

    @Column(name = "passportIssueDate",  nullable = false)
    private Date passportIssueDate;

    @Column(name = "identificationNumber", length = 45, nullable = false)
    private String identificationNumber;

    @Column(name = "birthPlace", length = 45, nullable = false)
    private String birthPlace;

    @ManyToOne
    @JoinColumn(name = "residenceTown_id", nullable = false)
    private Town residenceTown;

    @Column(name = "residenceAddress", length = 250, nullable = false)
    private String residenceAddress;

    @Column(name = "townPhone", length = 45, nullable = true)
    private String townPhone;

    @Column(name = "mobilePhone", length = 45, nullable = true)
    private String mobilePhone;

    @Column(name = "email", length = 45, nullable = true)
    private String email;

    @Column(name = "workPlace", length = 45, nullable = true)
    private String workPlace;

    @Column(name = "workPosition", length = 45, nullable = true)
    private String workPosition;

    @ManyToOne
    @JoinColumn(name = "registrationTown_id", nullable = false)
    private Town registrationTown;

    @ManyToOne
    @JoinColumn(name = "familyStatus_id", nullable = false)
    private FamilyStatus familyStatus;

    @ManyToOne
    @JoinColumn(name = "nationality_id", nullable = false)
    private Nationality nationality;

    @ManyToOne
    @JoinColumn(name = "disability_id", nullable = false)
    private Disability disability;

    @Column(name = "pensioner", nullable = false)
    private Boolean pensioner;

    @Column(name = "monthlyIncome", length = 45, nullable = true)
    private String monthlyIncome;

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passport) {
        this.passportSeries = passport;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportOrganization() {
        return passportOrganization;
    }

    public void setPassportOrganization(String passportOrganization) {
        this.passportOrganization = passportOrganization;
    }

    public Date getPassportIssueDate() {
        return passportIssueDate;
    }

    public void setPassportIssueDate(Date passportIssueDate) {
        this.passportIssueDate = passportIssueDate;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Town getResidenceTown() {
        return residenceTown;
    }

    public void setResidenceTown(Town residenceTown) {
        this.residenceTown = residenceTown;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getTownPhone() {
        return townPhone;
    }

    public void setTownPhone(String townPhone) {
        this.townPhone = townPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }

    public Town getRegistrationTown() {
        return registrationTown;
    }

    public void setRegistrationTown(Town registrationTown) {
        this.registrationTown = registrationTown;
    }



    public Boolean getPensioner() {
        return pensioner;
    }

    public void setPensioner(Boolean pensioner) {
        this.pensioner = pensioner;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public FamilyStatus getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(FamilyStatus familyStatus) {
        this.familyStatus = familyStatus;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Disability getDisability() {
        return disability;
    }

    public void setDisability(Disability disability) {
        this.disability = disability;
    }
}
