package com.aslidongez.project.repository;
import com.aslidongez.project.entity.Personel;
import com.aslidongez.project.entity.Zimmet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.lang.String;
import java.util.Optional;

@Repository
@EnableJpaRepositories(basePackages = {"com.aslidongez.project.repository"})

public interface PersonelRepository extends JpaRepository<Personel ,Long>  {

    List<Personel> findAll();
    Optional<Personel> findByPersonelTc(Long personelTc);
   // Personel getOnePersonel(@PathVariable Long personelSicilNo);
    List<Personel> findByPersonelSicilNoAndPersonelName(Long personelSicilNo, String personelName);

    List<Personel> findByPersonelSicilNo(Long personelSicilNo);

    List<Personel> findByPersonelNameAndPersonelSurname(String personelName, String personelSurname);

    List<Personel> findByPersonelNameContainingIgnoreCase(String personelName);

}
