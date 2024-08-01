package com.aslidongez.project.service.impl;
import com.aslidongez.project.dto.EnvanterDto;
import com.aslidongez.project.dto.PersonelDto;
import com.aslidongez.project.dto.ZimmetDto;
import com.aslidongez.project.entity.*;

import com.aslidongez.project.repository.EnvanterRepository;
import com.aslidongez.project.repository.PersonelRepository;
import com.aslidongez.project.repository.ZimmetRepository;
import com.aslidongez.project.request.ZimmetCreateRequest;
import com.aslidongez.project.response.PersonelResponse;
import com.aslidongez.project.response.ZimmetResponse;
import com.aslidongez.project.service.ZimmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZimmetServiceImpl implements ZimmetService {


    public ZimmetServiceImpl(ZimmetRepository zimmetRepository,EnvanterRepository envanterRepository, PersonelRepository personelRepository) {
        this.zimmetRepository = zimmetRepository;
        this.envanterRepository = envanterRepository;
        this.personelRepository = personelRepository;
    }
    @Autowired
    ZimmetRepository zimmetRepository;
    EnvanterRepository envanterRepository;
    PersonelRepository personelRepository;

    public Zimmet getOneZimmetById(Long zimmetId){
        return zimmetRepository.findById(zimmetId).orElse(null);

    }
    public List<Personel> filterPersonel(Long personelSicilNo, String personelName) {
        return personelRepository.findByPersonelSicilNoAndPersonelName(personelSicilNo, personelName);
    }
    @Override
    public List<Envanter> getAvailableEnvanter() {
        // Tüm envanterleri çek
        List<Envanter> allEnvanters = envanterRepository.findAll();

        // Müsait olan envanterleri tutacak liste
        List<Envanter> availableEnvanters = new ArrayList<>();

        for (Envanter envanter : allEnvanters) {
            // Envanterin mevcut zimmet kayıtlarını kontrol et
            List<Zimmet> existingZimmet = zimmetRepository.findByZimmetliEnvanter_EnvanterSeriNo(envanter.getEnvanterSeriNo());

            boolean isAvailable = true;

            for (Zimmet zimmet : existingZimmet) {
                if (zimmet.getStatu() == Statu.PERSONEL) {
                    isAvailable = false;
                    break;
                }
            }

            // Eğer envanter zimmet kayıtlarında yoksa ya da sadece DEPO statüsündeyse müsait olarak kabul et
            if (isAvailable) {
                availableEnvanters.add(envanter);
            }
        }

        return availableEnvanters;
    }



    public ZimmetResponse createZimmet(ZimmetCreateRequest newZimmetRequest) {
        Personel personel = personelRepository.findById(newZimmetRequest.getPersonelSicilNo()).orElse(null);
        Envanter envanter = envanterRepository.findById(newZimmetRequest.getEnvanterId()).orElse(null);

        if (personel == null || envanter == null) {
            throw new IllegalArgumentException("Personel veya envanter bulunamadı.");
        }

        // Aynı personelin aynı envanteri iki kez zimmetlemesini engelle
        List<Zimmet> existingZimmetForPersonelAndEnvanter = zimmetRepository.findByZimmetliPersonel_PersonelSicilNoAndZimmetliEnvanter_EnvanterSeriNo(personel.getPersonelSicilNo(), envanter.getEnvanterSeriNo());
        if (!existingZimmetForPersonelAndEnvanter.isEmpty()) {
            throw new IllegalArgumentException("Bu envanter zaten bu personele zimmetlenmiş.");
        }

        // Envanterin mevcut zimmet kayıtlarını kontrol et
        List<Zimmet> existingZimmet = zimmetRepository.findByZimmetliEnvanter_EnvanterSeriNoAndStatu(envanter.getEnvanterSeriNo(), Statu.valueOf("PERSONEL"));
        if (!existingZimmet.isEmpty()) {
            throw new IllegalArgumentException("Bu envanter başka bir personelde bulunmaktadır.");
        }

        Zimmet zimmet = new Zimmet();
        zimmet.setZimmetliPersonel(personel);
        zimmet.setZimmetliEnvanter(envanter);
        zimmet.setEnvanterAlimTarihi(newZimmetRequest.getEnvanterAlimTarihi());
        zimmet.setPersonelTeslimEden(personel);
        zimmet.setEnvanterTeslimTarihi(newZimmetRequest.getEnvanterAlimTarihi());
        zimmet.setStatu((newZimmetRequest.getStatu()));
        zimmet.setPersonelTeslimAlan(personel);
        zimmet = zimmetRepository.save(zimmet);
        return convertToZimmetResponse(zimmet);
    }
    private ZimmetResponse convertToZimmetResponse(Zimmet zimmet) {
        ZimmetResponse response = new ZimmetResponse();
        response.setZimmetId(zimmet.getZimmetId());
      //  response.setEnvanterTipi(zimmet.getZimmetliEnvanter().getEnvanterTipi().getEnvanterTipAdi());
        response.setEnvanterMarka(zimmet.getZimmetliEnvanter().getEnvanterMarkasi());
        response.setEnvanterModel(zimmet.getZimmetliEnvanter().getEnvanterModel());
        response.setTip(zimmet.getZimmetliEnvanter().getTip());
        response.setEnvanterAlimTarihi(zimmet.getEnvanterAlimTarihi());
        response.setEnvanterTeslimTarihi(zimmet.getEnvanterTeslimTarihi());
        response.setStatu(zimmet.getStatu());
        return response;
    }

    private PersonelResponse convertToPersonelResponse(Personel personel) {
        PersonelResponse response = new PersonelResponse();
        response.setSicilNo(personel.getPersonelSicilNo());
        response.setPersonelName(personel.getPersonelName());
        response.setPersonelSurname(personel.getPersonelSurname());
        response.setPersonelBirimi(personel.getPersonelBirimi());
        return response;
    }

    @Override
    public ZimmetResponse geriAlZimmet(Long zimmetId) {
        Zimmet zimmet = zimmetRepository.findById(zimmetId).orElse(null);
        Envanter envanter = zimmet.getZimmetliEnvanter();
        zimmet.setStatu(Statu.valueOf("DEPO"));
        envanterRepository.save(envanter);
        zimmet = zimmetRepository.save(zimmet);
        return convertToZimmetResponse(zimmet);
    }

    @Override
    public List<ZimmetDto> getAllZimmet() {
        List <Zimmet> zimmets=zimmetRepository.findAll();
        List<ZimmetDto> dtos=new ArrayList<>();
        for (Zimmet zimmet : zimmets) {
            PersonelDto personelDto=new PersonelDto();
            EnvanterDto envanterDto=new EnvanterDto();
            ZimmetDto zimmetDto=new ZimmetDto();

            zimmetDto.setZimmetId(zimmet.getZimmetId());
            zimmetDto.setStatu(zimmet.getStatu());

            Personel personel = zimmet.getZimmetliPersonel();
            personelDto.setPersonelSicilNo(personel.getPersonelSicilNo());
            personelDto.setPersonelName(personel.getPersonelName());
            personelDto.setPersonelSurname(personel.getPersonelSurname());
            personelDto.setPersonelGorevi(personel.getPersonelGorevi());
            personelDto.setPersonelBirimi(personel.getPersonelBirimi());

            Envanter envanter = zimmet.getZimmetliEnvanter();
            envanterDto.setEnvanterMarkasi(envanter.getEnvanterMarkasi());
            envanterDto.setTip(envanter.getTip());
            envanterDto.setEnvanterModel(envanter.getEnvanterModel());
            zimmetDto.setPersonelDto(personelDto);
            zimmetDto.setEnvanterDto(envanterDto);
            dtos.add(zimmetDto);
        }
        return dtos;

    }

    @Override
    public List<ZimmetResponse> getZimmetlerByPersonel(Long personelSicilNo) {
        Personel personel = personelRepository.findById(personelSicilNo).orElse(null);
        List<Zimmet> zimmetler = zimmetRepository.findByZimmetliPersonel(personel);
        return zimmetler.stream().map(this::convertToZimmetResponse).collect(Collectors.toList());
    }

}

