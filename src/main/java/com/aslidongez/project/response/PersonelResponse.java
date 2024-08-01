package com.aslidongez.project.response;

import com.aslidongez.project.entity.Birim;

public class PersonelResponse {
    private Long sicilNo;
    private String personelName;
    private String personelSurname;

    public Long getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(Long sicilNo) {
        this.sicilNo = sicilNo;
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


    public Birim getPersonelBirimi() {
        return PersonelBirimi;
    }

    public void setPersonelBirimi(Birim personelBirimi) {
        PersonelBirimi = personelBirimi;
    }

    private Birim PersonelBirimi;


}
