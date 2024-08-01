package com.aslidongez.project.service.impl;
import com.aslidongez.project.entity.Envanter;
import com.aslidongez.project.repository.EnvanterRepository;
import com.aslidongez.project.service.EnvanterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvanterServiceImpl implements EnvanterService {
    public EnvanterServiceImpl(EnvanterRepository envanterRepository) {
        this.envanterRepository = envanterRepository;
    }


    EnvanterRepository envanterRepository;

    public List<Envanter> getAllEnvanters(){

        return envanterRepository.findAll();
    }

    @Override
    public Envanter getOneEnvanter(Long envanterSeriNo) {
        return envanterRepository.findById(envanterSeriNo).orElse(null);
    }

    @Override
    public Envanter saveOneEnvanter(Envanter newEnvanter) {
        return  envanterRepository.save(newEnvanter);
    }
    @Override
    public Envanter updateOneEnvanter(Long envanterSeriNo, Envanter newEnvanter){
        Optional<Envanter> envanter =envanterRepository.findById(envanterSeriNo);
        if(envanter.isPresent()){
            Envanter foundEnvanter=envanter.get();
            foundEnvanter.setEnvanterModel(newEnvanter.getEnvanterModel());
            foundEnvanter.setEnvanterMarkasi(newEnvanter.getEnvanterMarkasi());
            foundEnvanter.setEnvanterSeriNo(newEnvanter.getEnvanterSeriNo());
            foundEnvanter.setTip(newEnvanter.getTip());
           // foundEnvanter.setEnvanterTipi(newEnvanter.getEnvanterTipi());
            envanterRepository.save(foundEnvanter);
            return foundEnvanter;
        }
        else
            return null;

    }
    @Override
   public void deleteById(Long envanterSeriNo){
        envanterRepository.deleteById(envanterSeriNo);
    }

}
