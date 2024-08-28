package com.aslidongez.project.mapper;

import com.aslidongez.project.dto.PersonelDto;
import com.aslidongez.project.entity.Personel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-28T11:57:43+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class PersonelMapperImpl implements PersonelMapper {

    @Override
    public PersonelDto convertPersonelToPersonelDto(Personel personel) {
        if ( personel == null ) {
            return null;
        }

        PersonelDto personelDto = new PersonelDto();

        personelDto.setPersonelSicilNo( personel.getPersonelSicilNo() );
        personelDto.setPersonelName( personel.getPersonelName() );
        personelDto.setPersonelSurname( personel.getPersonelSurname() );
        personelDto.setPersonelBirimi( personel.getPersonelBirimi() );
        personelDto.setPersonelGorevi( personel.getPersonelGorevi() );

        return personelDto;
    }

    @Override
    public List<Personel> convertPersonelsToPersonelsDto(List<Personel> personel) {
        if ( personel == null ) {
            return null;
        }

        List<Personel> list = new ArrayList<Personel>( personel.size() );
        for ( Personel personel1 : personel ) {
            list.add( personel1 );
        }

        return list;
    }
}
