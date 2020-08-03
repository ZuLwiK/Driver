/*
package pl.zulwik.driver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zulwik.driver.dto.UserDTO;
import pl.zulwik.driver.model.UserEntity;

import java.text.ParseException;

@RestController
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService defaultUserService;
    private final ModelMapper modelMapper;

    @PostMapping("register")
    public void register(UserDTO userDTO) {
        defaultUserService.register(userDTO);
    }

    @GetMapping("/getByEmail")
    public ResponseEntity<UserDTO> getByEmail(String email) {
        UserEntity userEntity = defaultUserService.getByEmail(email);
        if (userEntity.equals(null)) {
            log.error("UserEntity with email: " + email + " does not exist");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(convertToDTO(userEntity));
    }

    private UserDTO convertToDTO(UserEntity userEntity) {
       return modelMapper.map(userEntity, UserDTO.class);
    }

    private UserEntity convertToEntity(UserDTO userDTO) throws ParseException {
        return modelMapper.map(userDTO, UserEntity.class);

    }
}
*/
