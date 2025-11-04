package br.com.cuidapet.cuidapet.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/alive")
public class ImAliveController {

    public ResponseEntity<String> ImAlive() {
        return ResponseEntity.ok("I AM I AM I AM");
    }

}
