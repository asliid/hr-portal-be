package com.aslidongez.project.repository;

import com.aslidongez.project.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

    List<Users> findAll();

    Boolean existsByUsername(String username);

    Optional<Users> findByUsername(String username);

  //  Users findByUsername(String username);
}
