package com.izibiz.repository.repository;

import com.izibiz.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{
   Optional<UserEntity> findUserByMail(String mail);

}
