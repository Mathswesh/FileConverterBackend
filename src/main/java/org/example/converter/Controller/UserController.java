package org.example.converter.Controller;

import org.example.converter.DTO.RestDto;
import org.example.converter.DTO.UserDto;
import org.example.converter.Entity.UserEntity;
import org.example.converter.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @PostMapping("/savedata")
    public void save(@Valid @RequestBody UserDto user){
        RestDto restDto = new RestDto();
        restDto.setFirstname(user.getFirstname());
        restDto.setEmail(user.getEmail());
        restDto.setPassword(user.getPassword());

        userService.save(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the request entity with headers and body
        HttpEntity<RestDto> request = new HttpEntity<RestDto>(restDto, headers);

        // Send POST request
        ResponseEntity<String> response = restTemplate.exchange( "http://localhost:8081/practise23/user/data", HttpMethod.POST, request, String.class);

        // Check for success and return the response body
        if (response.getStatusCode() == HttpStatus.OK) {
//            return response.getBody();
        } else {
            throw new RuntimeException("Failed to send POST request");
        }
    }

    @GetMapping("{id}")
    public UserEntity getById(@Valid @PathVariable UUID id){
        return userService.getById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@Valid @PathVariable  UUID id){
        userService.deleteById(id);
    }


//    @PutMapping("")
//    public UserDto update(@Valid UserDto user){
//        return userService.update(user);
//    }
}
