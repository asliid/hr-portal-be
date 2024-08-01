package com.aslidongez.project.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.Getter;

@Data
@Entity
//@Table(uniqueConstraints = {@UniqueConstraint(name="personel",columnNames = { "personel_tc"})})
@Table(name="personel")
public class Personel {
    @Id
    @Column(name="personel_sicil_no")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "personel_seq"
    )
    @SequenceGenerator(  //Otomatik olarak kullanicilara bir id tanımladim.
            name = "personel_seq",
            sequenceName = "personel_sequence",
            allocationSize = 2, //Artis miktari.
            initialValue = 101 //Kactan baslayacagi
    )
    private Long personelSicilNo;

    @Column(name="personel_name")
    @Size (min=3 , max=50)
    private String personelName;
    @Column(name="personel_surname")
    @Size (min=2 , max=50)
    private String personelSurname;
    @Column(name="personel_gender")
    //@Size(max=1)
    @Enumerated(EnumType.STRING)
    private Gender personelGender;
    @Column(name="personel_birthday")
    private Integer personelBirthday;

    @Column(name="personel_tc",unique = true)
    private Long personelTc;
    @Enumerated(EnumType.STRING)
    @Column(name="medeni_durum")
    private Medeni medeniDurum;

    @Enumerated(EnumType.STRING)
    @Column(name="personel_edu")
    private Education personelEdu;
    @Enumerated(EnumType.STRING)
    @Column(name="personel_birimi")
    private Birim personelBirimi;
    @Enumerated(EnumType.STRING)
    @Column(name="personel_görevi")
    private Gorev personelGorevi;
    @Enumerated(EnumType.STRING)
    @Column(name="personel_activity")
    private Active activity;
    @Column(name="personel_photo",nullable = false)
    @Lob
    private String photo;
    @Column(name="is_giris_tarihi",nullable = false)
    private Date iseGirisTarihi;
    @Column(name="is_cikis_tarihi",nullable = false)
    private Date iseCikisTarihi;
    @Column (name="ilk_pozisyon",nullable = false)
    private String ilkPozisyon;
    @Column (name="ilk_unvan",nullable = false)
    private String ilkUnvan;
    @Column (name="ayrilma_nedeni",nullable = false)
    @Lob
    private String ayrilmaNedeni;


    public Long getPersonelSicilNo() {
        return personelSicilNo;
    }

    public void setPersonelSicilNo(Long personelSicilNo) {
        this.personelSicilNo = personelSicilNo;
    }

    public String getPersonelName() {
        return personelName;
    }

    public void setPersonelName(String personelName) {
        this.personelName = personelName;
    }

    public String getPersonelSurname() {
        return personelSurname;
    }

    public void setPersonelSurname(String personelSurname) {
        this.personelSurname = personelSurname;
    }

    public Gender getPersonelGender() {
        return personelGender;
    }

    public void setPersonelGender(Gender personelGender) {
        this.personelGender = personelGender;
    }

    public Integer getPersonelBirthday() {
        return personelBirthday;
    }

    public void setPersonelBirthday(Integer personelBirthday) {
        this.personelBirthday = personelBirthday;
    }

    public Medeni getMedeniDurum() {
        return medeniDurum;
    }

    public void setMedeniDurum(Medeni medeniDurum) {
        this.medeniDurum = medeniDurum;
    }

    public Long getPersonelTc() {
        return personelTc;
    }

    public void setPersonelTc(Long personelTc) {
        this.personelTc = personelTc;
    }

    public Education getPersonelEdu() {
        return personelEdu;
    }

    public void setPersonelEdu(Education personelEdu) {
        this.personelEdu = personelEdu;
    }

    public Birim getPersonelBirimi() {
        return personelBirimi;
    }

    public void setPersonelBirimi(Birim personelBirimi) {
        this.personelBirimi = personelBirimi;
    }

    public Gorev getPersonelGorevi() {
        return personelGorevi;
    }

    public void setPersonelGorevi(Gorev personelGorevi) {
        this.personelGorevi = personelGorevi;
    }

    public Active getActivity() {
        return activity;
    }

    public void setActivity(Active activity) {
        this.activity = activity;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public Date getIseGirisTarihi() {
        return iseGirisTarihi;
    }

    public void setIseGirisTarihi(Date iseGirisTarihi) {
        this.iseGirisTarihi = iseGirisTarihi;
    }

    public Date getIseCikisTarihi() {
        return iseCikisTarihi;
    }

    public void setIseCikisTarihi(Date iseCikisTarihi) {
        this.iseCikisTarihi = iseCikisTarihi;
    }

    public String getIlkPozisyon() {
        return ilkPozisyon;
    }

    public void setIlkPozisyon(String ilkPozisyon) {
        this.ilkPozisyon = ilkPozisyon;
    }

    public String getIlkUnvan() {
        return ilkUnvan;
    }

    public void setIlkUnvan(String ilkUnvan) {
        this.ilkUnvan = ilkUnvan;
    }

    public String getAyrilmaNedeni() {
        return ayrilmaNedeni;
    }

    public void setAyrilmaNedeni(String ayrilmaNedeni) {
        this.ayrilmaNedeni = ayrilmaNedeni;
    }




}
