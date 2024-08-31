package com.goriant.nova.ucm.rest;

import com.goriant.nova.ucm.dto.ConfigurationDTO;
import com.goriant.nova.ucm.service.ConfigurationService;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Request;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;
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
    public ResponseEntity<?> getConfig(@RequestParam(required = false) Long id){
        // ResponseEntity: lớp đại diện cho toàn bộ phản hồi HTTP / <?> : cho phép trả về phản hồi với bất kỳ kiểu dữ liệu
        if (id != null){
            ConfigurationDTO config = service.getById(id);
            return ResponseEntity.ok(config);
        }
        else {
            List<ConfigurationDTO> configs = service.getAll();
            return ResponseEntity.ok(configs);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateConfig(@PathVariable Long id, @RequestBody ConfigurationDTO config) {
        if (service.validate(config)) {
            try {
                service.update(id, config);
                return ResponseEntity.ok("Configuration updated successfully");
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().body("Error updating configuration due to Config NULL");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConfig(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok("Configuration deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/get-by-name")
    public ResponseEntity<?> findByConfigName(@RequestParam("name") String name) {
        ConfigurationDTO config = service.getByConfigName(name);
        if (config != null) {
            return ResponseEntity.ok(config);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
