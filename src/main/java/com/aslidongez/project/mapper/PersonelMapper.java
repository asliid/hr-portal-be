package com.aslidongez.project.mapper;

import com.aslidongez.project.dto.PersonelDto;
import com.aslidongez.project.entity.Personel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonelMapper {
    PersonelDto convertPersonelToPersonelDto(Personel personel);
    List<Personel> convertPersonelsToPersonelsDto(List<Personel> personel);
}
