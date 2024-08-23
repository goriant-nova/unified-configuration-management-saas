package com.goriant.nova.ucm.rest;

import com.goriant.nova.ucm.dto.ConfigurationDTO;
import com.goriant.nova.ucm.entity.Configuration;
import com.goriant.nova.ucm.service.ConfigurationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ClientInfoStatus;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/configuration",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ConfigurationController {

    private final ConfigurationService service;

    public ConfigurationController(ConfigurationService service) {
        this.service = service;
    }

    @PostMapping
    public String createConfig(@RequestBody ConfigurationDTO config) {
        if (service.validate(config)) {
            service.save(config);
        } else {
            System.out.println("Error saving configuration due to Config NULL");
        }
        return "OK";
    }


/*    // TODO: implement getConfig -> neu co ID, thi find by ID, neu ko co, thi tra ve all
    @GetMapping
    public ConfigurationDTO getConfig(@RequestParam Long id) {
        return service.getById(id);
    }

    @PatchMapping
    public List<ConfigurationDTO> getAllConfig() {
        return service.getAll();*/
    // Two in one
    @GetMapping
    public ResponseEntity<?> getConfig(@RequestParam(required = false) Long id){ // ResponseEntity<?>
        if (id != null){
            ConfigurationDTO config = service.getById(id);
            return ResponseEntity.ok(config);
        }
        else {
            List<ConfigurationDTO> configs = service.getAll();
            return ResponseEntity.ok(configs);
        }

    }
}
