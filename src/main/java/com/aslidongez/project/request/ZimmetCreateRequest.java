package com.aslidongez.project.request;

import com.aslidongez.project.entity.Envanter;
import com.aslidongez.project.entity.Personel;
import com.aslidongez.project.entity.Statu;
import lombok.Data;

import java.util.Date;

@Data
public class ZimmetCreateRequest {

    private Long personelSicilNo;
    private Long envanterId;
    private Date envanterAlimTarihi;
    private Statu statu;

    public Statu getStatu() {
        return statu;
    }

    public void setStatu(Statu statu) {
        this.statu = statu;
    }


    public Long getPersonelSicilNo() {
        return personelSicilNo;
    }

    public void setPersonelSicilNo(Long personelSicilNo) {
        this.personelSicilNo = personelSicilNo;
    }

    public Long getEnvanterId() {
        return envanterId;
    }

    public void setEnvanterId(Long envanterId) {
        this.envanterId = envanterId;
    }

    public Date getEnvanterAlimTarihi() {
        return envanterAlimTarihi;
    }

    public void setEnvanterAlimTarihi(Date envanterAlimTarihi) {
        this.envanterAlimTarihi = envanterAlimTarihi;
    }

}
