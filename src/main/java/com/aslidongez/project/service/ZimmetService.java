package com.aslidongez.project.service;

import com.aslidongez.project.dto.ZimmetDto;
import com.aslidongez.project.entity.Envanter;
import com.aslidongez.project.entity.Personel;
import com.aslidongez.project.entity.Zimmet;
import com.aslidongez.project.request.ZimmetCreateRequest;
import com.aslidongez.project.response.ZimmetResponse;

import java.util.List;


public interface ZimmetService  {


     Zimmet getOneZimmetById(Long zimmetId);
     List<ZimmetDto> getAllZimmet();

     List<Personel> filterPersonel(Long personelSicilNo, String personelName);

     List<Envanter> getAvailableEnvanter();
     List<ZimmetResponse> getZimmetlerByPersonel(Long personelSicilNo);
     ZimmetResponse createZimmet(ZimmetCreateRequest newZimmetRequest);

     ZimmetResponse geriAlZimmet(Long zimmetId);

}
