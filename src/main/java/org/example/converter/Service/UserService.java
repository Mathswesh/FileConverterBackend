package org.example.converter.Service;

import org.example.converter.DTO.UserDto;
import org.example.converter.Entity.UserEntity;

import java.util.UUID;

public interface UserService {
    void save(UserDto user);
    UserEntity getById(UUID id);
    void deleteById(UUID id);
//    UserDto update(UserDto user);
}
