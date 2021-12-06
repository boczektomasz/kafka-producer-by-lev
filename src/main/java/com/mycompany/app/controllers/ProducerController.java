package com.mycompany.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.app.services.ProducerService;

@Controller
public class ProducerController {

    // parametrization of variables declared in resources/application.properties:
    @Value("${TOPIC_NAME}")
    private String topic_name;

    @Value("${BOOTSTRAP_SERVERS}")
    private String bootstrap_servers;

    @GetMapping("/api/produce")
    public String produce(Model model) {

        return "produce";
    }

    @GetMapping("/api/produce/create-message")
    public String produce(@RequestParam(value = "message") String message, Model model) {
        ProducerService.produce(message, topic_name, bootstrap_servers);
        return "produce";
    }
}
