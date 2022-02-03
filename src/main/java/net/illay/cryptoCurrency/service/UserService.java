package net.illay.cryptoCurrency.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.illay.cryptoCurrency.entity.User;
import net.illay.cryptoCurrency.model.UserModel;

import java.util.List;

public interface UserService {

    void save(UserModel userModel) throws JsonProcessingException;
    List<User> getUsersByCode(String code);
}
