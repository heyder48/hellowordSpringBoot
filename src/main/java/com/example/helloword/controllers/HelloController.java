package com.example.helloword.controllers;

import com.example.helloword.services.HelloService;
import com.example.helloword.services.interfaces.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private IHelloService helloService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello!");
    }

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public ResponseEntity<String> hello(@PathVariable String name) {
        return ResponseEntity.ok("Hello " + name + "!");
    }

    @RequestMapping(value = "/hello/{nome}/horario", method = RequestMethod.GET)
    public ResponseEntity<String> horario(@PathVariable String nome) {
        return ResponseEntity.ok(helloService.horario(nome));
    }
}
