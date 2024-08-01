package com.aslidongez.project.dto;

import com.aslidongez.project.entity.Statu;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ZimmetDto {
    private PersonelDto personelDto;
    private EnvanterDto envanterDto;

    private Long zimmetId;
    private Statu statu;
}
