package com.aslidongez.project.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Data
@Entity
@Table(name="zimmet")
@Getter
@Setter
public class Zimmet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Otomatik olarak kullanicilara bir id tanımladim.
    @Column(name="zimmet_id")
    private Long zimmetId;

    @ManyToOne(fetch = FetchType.LAZY) //eager or lazy?
    @JoinColumn(name="personel_sicil_no", referencedColumnName = "personel_sicil_no")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Personel zimmetliPersonel;

    @ManyToOne(fetch = FetchType.LAZY) //eager or lazy?
    @JoinColumn(name="envanter_seri_no", referencedColumnName="envanter_seri_no")
    private Envanter zimmetliEnvanter;

    @ManyToOne(fetch = FetchType.EAGER) //eager or lazy?
    @JoinColumn(name="teslim_eden_personel",nullable = true) //columnu ekledim ,deger sifir olamaz dedim.
    @OnDelete(action = OnDeleteAction.CASCADE)//personel silindiginde o personelin bilgi alaninin silinmesini istiyorum.
    private Personel personelTeslimEden;
    @ManyToOne(fetch = FetchType.EAGER) //eager or lazy?
    @JoinColumn(name="teslim_alan_personel",nullable = true) //columnu ekledim ,deger sifir olabilir dedim.çunku urun personelde olabilir
    @OnDelete(action = OnDeleteAction.CASCADE)//personel silindiginde o personelin bilgi alaninin silinmesini istiyorum.
    private Personel personelTeslimAlan;
    @Column(name="envanter_alim_tarihi")
    private Date envanterAlimTarihi;
    @Column (name="envanter_teslim_tarihi")
    private Date envanterTeslimTarihi;
     @Column (name="statu")
     @Enumerated(EnumType.STRING)
     private Statu statu;

}
