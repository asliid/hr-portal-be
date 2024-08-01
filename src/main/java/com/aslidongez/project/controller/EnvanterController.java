package com.aslidongez.project.controller;

import com.aslidongez.project.entity.Envanter;
import com.aslidongez.project.service.EnvanterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/envanter")
@CrossOrigin("http://localhost:3000/")
public class EnvanterController {

    public EnvanterController(EnvanterService envanterService) {
        this.envanterService = envanterService;
    }

    private EnvanterService envanterService;
    @GetMapping
    public List<Envanter> getAllEnvanters(){
        return envanterService.getAllEnvanters();
    }
    @PostMapping
    public Envanter createEnvanter(@RequestBody Envanter newEnvanter){
        return envanterService.saveOneEnvanter(newEnvanter);
    }
    @GetMapping("/{envanterSeriNo}")
    public Envanter getOneEnvanter(@PathVariable Long envanterSeriNo){
        return envanterService.getOneEnvanter(envanterSeriNo);
    }

    @PutMapping("/{envanterSeriNo}/update")
    public Envanter updateEnvanter(@PathVariable Long envanterSeriNo,@RequestBody Envanter newEnvanter){
       return envanterService.updateOneEnvanter(envanterSeriNo,newEnvanter);
    }
    @DeleteMapping("/{envanterSeriNo}/delete")
    public void deleteOneEnvanter(@PathVariable Long envanterSeriNo){
        envanterService.deleteById(envanterSeriNo);
    }

}
