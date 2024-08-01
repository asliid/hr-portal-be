package com.aslidongez.project.service.impl;

import com.aslidongez.project.dto.PersonelDto;
import com.aslidongez.project.entity.Envanter;
import com.aslidongez.project.entity.Personel;
import com.aslidongez.project.entity.Users;
import com.aslidongez.project.mapper.PersonelMapper;
import com.aslidongez.project.repository.PersonelRepository;
import com.aslidongez.project.service.PersonelService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonelServiceImpl implements PersonelService {


    public PersonelServiceImpl(PersonelRepository personelRepository) {
        this.personelRepository = personelRepository;
    }

    PersonelRepository personelRepository;
    ModelMapper modelMapper;
    @Override
    public List<PersonelDto> getAllPersonels() {
        List <Personel> personels=personelRepository.findAll();
        List<PersonelDto> dtos=new ArrayList<>();
        for(int i =0; i<personels.size();i++){
            PersonelDto tempDTO=new PersonelDto();
            tempDTO.setPersonelName(personels.get(i).getPersonelName());
            tempDTO.setPersonelSurname(personels.get(i).getPersonelSurname());
            tempDTO.setPersonelGorevi(personels.get(i).getPersonelGorevi());
            tempDTO.setPersonelBirimi(personels.get(i).getPersonelBirimi());
            tempDTO.setPersonelSicilNo(personels.get(i).getPersonelSicilNo());
            dtos.add(tempDTO);
        }
        return dtos;
    }
    public List<Personel> searchPersonel(Long personelSicilNo, String personelName) {
        if (personelSicilNo != null) {
            return personelRepository.findByPersonelSicilNo(personelSicilNo);
        } else if (personelName != null && !personelName.isEmpty()) {
            return personelRepository.findByPersonelNameContainingIgnoreCase(personelName);
        } else {
            return personelRepository.findAll();
        }
    }

    @Override
    public Personel getOnePersonel(Long personelSicilNo) {
        return personelRepository.findById(personelSicilNo).orElse(null);
    }
    @Override
    public Optional<Personel> findByPersonelTc(Long personelTc) {
        return personelRepository.findByPersonelTc(personelTc);
    }

    @Override
    public Personel saveOnePersonel(Personel newPersonel) {
        return  personelRepository.save(newPersonel);
    }


    @Override
    public Personel updateOnePersonel(Long personelSicilNo, Personel newPersonel) {
        Optional<Personel> personel =personelRepository.findById(personelSicilNo);
        if(personel.isPresent()){
            Personel foundPersonel=personel.get();
            foundPersonel.setPersonelBirimi(newPersonel.getPersonelBirimi());
            foundPersonel.setPersonelBirthday(newPersonel.getPersonelBirthday());
            foundPersonel.setPersonelEdu(newPersonel.getPersonelEdu());
            foundPersonel.setPersonelGorevi(newPersonel.getPersonelGorevi());
            foundPersonel.setPersonelGender(newPersonel.getPersonelGender());
            foundPersonel.setPersonelName(newPersonel.getPersonelName());
            foundPersonel.setPersonelTc(newPersonel.getPersonelTc());
            foundPersonel.setPersonelSurname(newPersonel.getPersonelSurname());
            foundPersonel.setPersonelSicilNo(newPersonel.getPersonelSicilNo());
            foundPersonel.setActivity(newPersonel.getActivity());
            foundPersonel.setPersonelGorevi(newPersonel.getPersonelGorevi());
            foundPersonel.setPhoto(newPersonel.getPhoto());
            foundPersonel.setAyrilmaNedeni(newPersonel.getAyrilmaNedeni());
            foundPersonel.setIseCikisTarihi(newPersonel.getIseCikisTarihi());
            foundPersonel.setIseGirisTarihi(newPersonel.getIseGirisTarihi());
            foundPersonel.setIlkUnvan(newPersonel.getIlkUnvan());
            foundPersonel.setIlkPozisyon(newPersonel.getIlkPozisyon());
            foundPersonel.setMedeniDurum(newPersonel.getMedeniDurum());
            personelRepository.save(foundPersonel);
            return foundPersonel;
        }
        else
            return null;
    }

    public void deleteById(Long personelSicilNo) {
        if (personelRepository.existsById(personelSicilNo)) {
            personelRepository.deleteById(personelSicilNo);
        } else {
            // Handle case where personel does not exist
            throw new EntityNotFoundException("Personel with Sicil No " + personelSicilNo + " not found");
        }
    }
}
