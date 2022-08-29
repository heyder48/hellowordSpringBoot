package com.example.helloword.services;

import com.example.helloword.services.interfaces.IHelloService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class HelloService implements IHelloService {

    @Override
    public String horario(String name){
        //passar nome para primeira letra para maiusculo
        String nome = name.substring(0, 1).toUpperCase() + name.substring(1);

        return "Hello "+ nome+"! Agora são " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm") ) + ", não se esqueça!";
    }
}
