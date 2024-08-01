package com.aslidongez.project.repository;

import com.aslidongez.project.entity.Personel;
import com.aslidongez.project.entity.Statu;
import com.aslidongez.project.entity.Zimmet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories(basePackages = {"com.aslidongez.project.repository"})
public interface ZimmetRepository extends JpaRepository<Zimmet, Long>{

  //  List<Zimmet> findByPersonelNameAndPersonelSurname(String personelSicilNo, String personelSurname);
  //  List<Zimmet> findByPersonelSicilNo(Long personelSicilNo);
  List<Zimmet> findByZimmetliEnvanter_EnvanterSeriNoAndStatu(Long envanterSeriNo, Statu statu);
    List<Zimmet> findByZimmetliPersonel_PersonelSicilNoAndZimmetliEnvanter_EnvanterSeriNo(Long personelSicilNo, Long envanterSeriNo);

   List<Zimmet> findAll();
    List<Zimmet> findByZimmetliPersonel(Personel personel);
   // List<Zimmet> findByStatu(String depo);
   List<Zimmet> findByStatu(Statu statu);

    List<Zimmet> findByZimmetliEnvanter_EnvanterSeriNo(Long envanterSeriNo);

}
