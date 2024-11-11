package org.example.converter.Service.ServiceImpl;

import lombok.AllArgsConstructor;
import org.example.converter.DTO.UserDto;
import org.example.converter.Entity.UserEntity;
import org.example.converter.Repo.UserJpa;
import org.example.converter.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserJpa userJpa;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(UserDto userDto){
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        userJpa.save(userEntity);
    }

    @Override
    public UserEntity getById(UUID id){
        return userJpa.findById(id).get();
    }

    @Override
    public void deleteById(UUID id){
        userJpa.deleteById(id);
    }
//
//    @Override
//    public UserDto update(UserDto user){
//        return userJpa.save(user)
//    }

}
