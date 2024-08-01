package com.aslidongez.project.repository;

import com.aslidongez.project.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aslidongez.project.entity.Envanter;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@Repository
public interface EnvanterRepository  extends JpaRepository<Envanter,Long>  {

    List<Envanter> findAll();

   // Envanter saveOneEnvanter(Envanter newEnvanter);

    //   OptionalLong findById(Long envanterSeriNo);


}
