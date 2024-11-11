package org.example.converter.Repo;

import org.example.converter.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserJpa extends JpaRepository<UserEntity, UUID> {
}
