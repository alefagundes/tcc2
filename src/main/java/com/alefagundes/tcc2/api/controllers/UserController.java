package com.alefagundes.tcc2.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alefagundes.tcc2.domain.exceptions.NegocioException;
import com.alefagundes.tcc2.domain.exceptions.UserNotExistsException;
import com.alefagundes.tcc2.domain.model.Login;
import com.alefagundes.tcc2.domain.model.User;
import com.alefagundes.tcc2.domain.services.CadastroUserService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private CadastroUserService userService;

   /*  @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody @Valid User newUser) {
       try {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.salvar(newUser));
       }catch(UserNotExistsException e){
         throw new NegocioException(e.getMessage());
       }
    } */

   /*  @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody @Valid Login userLogin) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.login(userLogin));
    } */

    @GetMapping("/private")
    public String getMessage() {
        return "Hello user, you are authenticated";
    }
}
