package com.aslidongez.project.dto;

import com.aslidongez.project.entity.Birim;
import com.aslidongez.project.entity.Gorev;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class PersonelDto {
    private Long personelSicilNo;
    private String personelName;
    private String personelSurname;
    private Birim personelBirimi;
    private Gorev personelGorevi;

}
