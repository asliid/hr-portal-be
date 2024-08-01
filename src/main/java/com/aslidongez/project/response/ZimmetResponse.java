package com.aslidongez.project.response;

import com.aslidongez.project.entity.Statu;
import com.aslidongez.project.entity.Tip;

import java.util.Date;

public class ZimmetResponse {
    private Long zimmetId;
    private Tip tip;
    private String envanterMarka;
    private String envanterModel;
    private Date envanterAlimTarihi;
    private Statu statu;
    private Date envanterTeslimTarihi;
    public Statu getStatu() {
        return statu;
    }

    public void setStatu(Statu statu) {
        this.statu = statu;
    }

    public Long getZimmetId() {
        return zimmetId;
    }

    public void setZimmetId(Long zimmetId) {
        this.zimmetId = zimmetId;
    }


    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    public String getEnvanterMarka() {
        return envanterMarka;
    }

    public void setEnvanterMarka(String envanterMarka) {
        this.envanterMarka = envanterMarka;
    }

    public String getEnvanterModel() {
        return envanterModel;
    }

    public void setEnvanterModel(String envanterModel) {
        this.envanterModel = envanterModel;
    }

    public Date getEnvanterAlimTarihi() {
        return envanterAlimTarihi;
    }

    public void setEnvanterAlimTarihi(Date envanterAlimTarihi) {
        this.envanterAlimTarihi = envanterAlimTarihi;
    }

    public Date getEnvanterTeslimTarihi() {
        return envanterTeslimTarihi;
    }

    public void setEnvanterTeslimTarihi(Date envanterTeslimTarihi) {
        this.envanterTeslimTarihi = envanterTeslimTarihi;
    }


}
