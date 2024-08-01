package com.aslidongez.project.service;
import com.aslidongez.project.entity.Envanter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


public interface EnvanterService {
    List<Envanter> getAllEnvanters();
   // Envanter createEnvanter(@RequestBody Envanter newEnvanter);

    Envanter getOneEnvanter(@PathVariable Long envanterSeriNo);

    Envanter saveOneEnvanter(Envanter newEnvanter);

    Envanter updateOneEnvanter(Long envanterSeriNo, Envanter newEnvanter);

    void deleteById(Long envanterSeriNo);
}
