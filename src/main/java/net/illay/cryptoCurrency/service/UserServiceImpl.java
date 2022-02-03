package net.illay.cryptoCurrency.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.illay.cryptoCurrency.entity.User;
import net.illay.cryptoCurrency.model.UserModel;
import net.illay.cryptoCurrency.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UpdatePriceService updatePriceService;

    @Autowired
    private CoinService coinService;

    public void save(UserModel userModel) throws JsonProcessingException {
        User user = User.builder()
                .name(userModel.getName())
                .code(userModel.getCode())
                .price(updatePriceService.getCurrentPrice(coinService.getCoinBySymbol(userModel.getCode())))
                .build();
        userRepository.save(user);
    }

    public List<User> getUsersByCode(String code){
        return userRepository.findUsersByCode(code);
    }
}
