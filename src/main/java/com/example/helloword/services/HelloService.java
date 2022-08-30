package com.example.helloword.services;

import com.example.helloword.services.interfaces.IHelloService;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class HelloService implements IHelloService {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(HelloService.class);

    @Override
    public String horario(String name){
        logger.info("Método horario(String name) chamado");
        logger.info("Transformando a primeira letra do nome em maiúscula");
        String nome = name.substring(0, 1).toUpperCase() + name.substring(1);
        logger.info("Retornando o horário para "+nome);
        return "Hello "+ nome+"! Agora são " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm") ) + ", não se esqueça!";
    }
}
