package com.goriant.nova.ucm.rest;

import com.goriant.nova.ucm.dto.ConfigurationDTO;
import com.goriant.nova.ucm.service.ConfigurationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/configuration")
public class ConfigurationController {

    private final ConfigurationService service;

    public ConfigurationController(ConfigurationService service) {
        this.service = service;
    }

    @PostMapping
    public String saveConfig(@RequestBody ConfigurationDTO config) {
        if (service.validate(config)) {
            service.save(config);
        } else {
            System.out.println("Error saving configuration due to Config NULL");
        }
        return "OK";
    }

    @GetMapping
    public ConfigurationDTO getById(@RequestParam Long id) {
        return service.getById(id);
    }
}
