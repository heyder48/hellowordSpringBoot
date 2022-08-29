package com.example.helloword.controllers;

import com.example.helloword.services.HelloService;
import com.example.helloword.services.interfaces.IHelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //instânciar o Logger
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private IHelloService helloService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> hello() {
        logger.info("Endpoint /hello chamado");
        return ResponseEntity.ok("Hello!");
    }

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public ResponseEntity<String> hello(@PathVariable String name) {
        logger.info("Endpoint /hello/"+name+" chamado");

        return ResponseEntity.ok("Hello " + name + "!");
    }

    @RequestMapping(value = "/hello/{nome}/horario", method = RequestMethod.GET)
    public ResponseEntity<String> horario(@PathVariable String nome) {
        logger.info("Endpoint /hello/"+nome+"/horario chamado");
        logger.info("Retornando horário para "+nome);
        logger.info("Chamando o serviço HelloService e o método horario(String name)");
        return ResponseEntity.ok(helloService.horario(nome));
    }
}
