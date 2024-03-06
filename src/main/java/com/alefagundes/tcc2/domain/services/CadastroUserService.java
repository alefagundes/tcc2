package com.alefagundes.tcc2.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alefagundes.tcc2.domain.exceptions.NegocioException;
import com.alefagundes.tcc2.domain.exceptions.UserExistsException;
import com.alefagundes.tcc2.domain.exceptions.UserNotExistsException;
import com.alefagundes.tcc2.domain.model.Login;
import com.alefagundes.tcc2.domain.model.User;
import com.alefagundes.tcc2.domain.repository.UserRepository;

@Service
public class CadastroUserService {
    public static final String MSG_USER_NOT_EXISTS = "Usuario com email: %s não cadastrado no sistema.";
    public static final String MSG_USER_EXISTS = "Usuario com email: %s já cadastrado no sistema.";

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserRepository userRepository;


    public User salvar(User user){
        if(userRepository.existsByEmail(user.getEmail())){
            throw  new UserExistsException(String.format(MSG_USER_EXISTS, user.getEmail()));
        }
        //codificacao da senha do usuario para salvar no banco
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User buscarOuFalhar(String email){
        return userRepository.findByEmail(email).orElseThrow(() 
        -> new UserNotExistsException(String.format(MSG_USER_NOT_EXISTS, email)));
    }

    public User validateUser(Login userLogin){
        User userSearch = buscarOuFalhar(userLogin.getEmail());
        if(!passwordEncoder().matches(userLogin.getPassword(), userSearch.getPassword())){
            throw new NegocioException("Usuario ou senha incorretos");
        }
        return userSearch;
    }

    public String login(Login userLogin){
        User user = validateUser(userLogin); 
        String token = user.getNome() + user.getId();
        return token;
    }

}
