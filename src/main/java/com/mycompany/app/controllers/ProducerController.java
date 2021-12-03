package com.mycompany.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.app.services.ProducerService;

@RestController
public class ProducerController {

    @GetMapping("/api/produce")
    public void produce() {
        ProducerService.produce();
    }
}
