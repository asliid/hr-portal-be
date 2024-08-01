package com.aslidongez.project.dto;

import com.aslidongez.project.entity.Tip;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class EnvanterDto {

    private Tip tip;

    private String envanterMarkasi;

    private String envanterModel;
}
