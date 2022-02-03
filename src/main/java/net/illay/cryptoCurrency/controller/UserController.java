package net.illay.cryptoCurrency.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.illay.cryptoCurrency.model.UserModel;
import net.illay.cryptoCurrency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cryptoCurrency/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel userModel) throws JsonProcessingException {
        userService.save(userModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
