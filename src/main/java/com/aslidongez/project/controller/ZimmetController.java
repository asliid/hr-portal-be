package com.aslidongez.project.controller;
import com.aslidongez.project.dto.ZimmetDto;
import com.aslidongez.project.entity.Envanter;
import com.aslidongez.project.entity.Personel;
import com.aslidongez.project.entity.Zimmet;
import com.aslidongez.project.request.ZimmetCreateRequest;
import com.aslidongez.project.response.ZimmetResponse;
import com.aslidongez.project.service.ZimmetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zimmet")
@CrossOrigin("http://localhost:3000/")
public class ZimmetController {
    @Autowired
    ZimmetService zimmetService;

    @GetMapping("/zimmetler")
    public ResponseEntity <List<ZimmetDto>> getAllZimmet() {
        List<ZimmetDto> zimmets = zimmetService.getAllZimmet();
        return ResponseEntity.ok(zimmets);
    }

    @GetMapping("/envanterAlanPersonel")
    public List<Personel> filterPersonel(
            @RequestParam(required = false) Long personelSicilNo,
            @RequestParam(required = false) String personelName
    ) {
        return zimmetService.filterPersonel(personelSicilNo, personelName);

    }

    @GetMapping("/depo")
    public ResponseEntity<List<Envanter>> getAvailableEnvanter() {
        List<Envanter> availableEnvanters = zimmetService.getAvailableEnvanter();
        return ResponseEntity.ok(availableEnvanters);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createZimmet(@RequestBody ZimmetCreateRequest newZimmetRequest) {
        try {
            ZimmetResponse response = zimmetService.createZimmet(newZimmetRequest);
            return ResponseEntity.ok("Zimmet başarıyla oluşturuldu. ID: " + response.getZimmetId());
        } catch (IllegalArgumentException e) {
            // Hatalı durumlar için uygun hata mesajlarını döndür
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            // Genel hata durumları için uygun bir mesaj
            return ResponseEntity.status(500).body("Sunucu hatası: " + e.getMessage());
        }
    }
    @PutMapping("/{zimmetId}/geri-al")
    public ZimmetResponse geriAlZimmet(@PathVariable Long zimmetId) {
        return zimmetService.geriAlZimmet(zimmetId);
    }

    @GetMapping("/personel/{personelSicilNo}/zimmet")
    public List<ZimmetResponse> getZimmetlerByPersonel(@PathVariable Long personelSicilNo) {
        return zimmetService.getZimmetlerByPersonel(personelSicilNo);
    }


}