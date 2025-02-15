package com.project.usermodule.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.usermodule.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {

    Optional<Users> findByEmail(String email);

}
