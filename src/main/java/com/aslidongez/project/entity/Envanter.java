package com.aslidongez.project.entity;


import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
@Getter
@Setter
@Table(name="envanter")
public class Envanter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Otomatik olarak kullanicilara bir id tanımladim.
    @Column(name="envanter_seri_no")
    private Long envanterSeriNo;

    @Column(name="envanter_markasi")
    private String envanterMarkasi;
    @Column(name="envanter_model")
    private String envanterModel;
    @Column (name="tip")
    @Enumerated(EnumType.STRING)
    private  Tip tip;


}
