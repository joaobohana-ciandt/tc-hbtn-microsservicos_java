package com.example.user.controller;

import com.example.user.exception.CPFException;
import com.example.user.exception.UserIdException;
import com.example.user.exception.UserNameException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id) {

        String msg;
        if(id > 0 && id < 100){
            msg = "You have entered a valid ID";
        } else {
            throw new UserIdException();
        }

        return msg;
    }

    @GetMapping("/user-name/{userName}")
    public String findUserByName(@PathVariable String userName) {

        String msg;
        if(userName.length() > 3 && userName.length() < 15){
            msg = "You have entered valid USERNAME";
        } else {
            throw new UserNameException();
        }

        return msg;
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) {

        String msg;
        boolean isCPFValid = isCPF(cpf);
        if(isCPFValid){
            msg = "You have entered valid CPF";
        } else {
            throw new CPFException();
        }

        return msg;
    }

    public boolean isCPF(String cpf) {
        return cpf.length() > 3 && cpf.length() < 15;
    }

}
