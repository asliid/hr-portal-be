package com.aslidongez.project.controller;


import com.aslidongez.project.dto.PersonelDto;
import com.aslidongez.project.entity.Personel;
import com.aslidongez.project.mapper.PersonelMapper;
import com.aslidongez.project.mernis.QLMKPSPublicSoap;
import com.aslidongez.project.service.PersonelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personel")
@CrossOrigin("http://localhost:3000/")
public class PersonelController {


    public PersonelController(PersonelService personelService) {
        this.personelService = personelService;
    }

    private final PersonelService personelService ;
    //değişkenlerin sadece sınıfın içinde erişilebilir olduğunu ve bir kez atanıp daha sonra değiştirilemeyeceğini belirtir.
    @GetMapping
    public ResponseEntity <List<PersonelDto>> getAllPersonels() {
        List<PersonelDto> personels = personelService.getAllPersonels();       // Veritabanından listeyi alıp
        return ResponseEntity.ok(personels);   // Personel listesini PersonelDto listesine donusturdum.
    }

    @PostMapping
    public ResponseEntity<String> createPersonel(@RequestBody  Personel newPersonel) throws Exception {
        QLMKPSPublicSoap client =new QLMKPSPublicSoap();
        boolean isRealPerson= client.TCKimlikNoDogrula(Long.valueOf(newPersonel.getPersonelTc()),newPersonel.getPersonelName(),newPersonel.getPersonelSurname(),newPersonel.getPersonelBirthday());
        if (!isRealPerson) {
            return ResponseEntity.badRequest().body("TC kimlik numarası doğrulanamadı.");
        }

        Optional<Personel> existingPersonel = personelService.findByPersonelTc(newPersonel.getPersonelTc());
        if (existingPersonel.isPresent()) {
            return ResponseEntity.badRequest().body("Aynı TC kimlik numarasına sahip bir personel zaten var.");
        }

        personelService.saveOnePersonel(newPersonel);
        return ResponseEntity.ok("Personel kaydedildi.");
    }
    @GetMapping("/{personelSicilNo}")
    public Personel getOnePersonel(@PathVariable Long personelSicilNo){
        return personelService.getOnePersonel(personelSicilNo);
    }

    @PutMapping("/{personelSicilNo}/update")
    public Personel updatePersonel(@PathVariable Long personelSicilNo,@RequestBody Personel newPersonel){
        return personelService.updateOnePersonel(personelSicilNo,newPersonel);
    }
    @DeleteMapping("/{personelSicilNo}/delete")
    public void deleteOnePersonel(@PathVariable Long personelSicilNo){
        personelService.deleteById(personelSicilNo);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Personel>> searchPersonel(
            @RequestParam(required = false) Long personelSicilNo,
            @RequestParam(required = false) String personelName
    ) {
        List<Personel> personelList = personelService.searchPersonel(personelSicilNo, personelName);
        return ResponseEntity.ok(personelList);
    }


}




