package com.aslidongez.project.service;

import com.aslidongez.project.dto.PersonelDto;
import com.aslidongez.project.entity.Envanter;
import com.aslidongez.project.entity.Personel;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface PersonelService {
    List<PersonelDto> getAllPersonels();

    Optional<Personel> findByPersonelTc(Long personelTc);
    Personel getOnePersonel(@PathVariable Long personelSicilNo);

    Personel saveOnePersonel(Personel newPersonel);

    Personel updateOnePersonel(Long personelSicilNo, Personel newPersonel);

    void deleteById(Long personelSicilNo);

    List<Personel> searchPersonel(Long personelSicilNo, String personelName);
}
