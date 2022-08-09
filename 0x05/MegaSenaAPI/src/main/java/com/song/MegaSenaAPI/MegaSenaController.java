package com.song.MegaSenaAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/megasena")
public class MegaSenaController {

    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas(){
        return "Seja bem vindo!";
    }

    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena(){
        List<Integer> numeros = gerarNumerosAleatoriosMegaSena();
        Collections.sort(numeros);
        return numeros;
    }

    public List<Integer> gerarNumerosAleatoriosMegaSena(){
        List<Integer> numerosMegaSena = new ArrayList<>();
        int numMinimo = 1;
        int numMaximo = 60;

        for (int i = 0; i < 6; i++){
            int num = (int) ((Math.random() * (numMaximo - numMinimo)) + numMinimo);

            if(numerosMegaSena.contains(num)){
                --i;
            } else {
                numerosMegaSena.add(num);
            }
        }

        return numerosMegaSena;
    }
}
