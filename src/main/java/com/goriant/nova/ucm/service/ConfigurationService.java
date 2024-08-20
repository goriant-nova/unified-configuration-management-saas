package com.goriant.nova.ucm.service;

import com.goriant.nova.ucm.dto.ConfigurationDTO;
import com.goriant.nova.ucm.entity.Configuration;
import com.goriant.nova.ucm.repository.ConfigurationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConfigurationService {

    private final ConfigurationRepository repository;

    public ConfigurationService(ConfigurationRepository repository) {
        this.repository = repository;
    }

    public boolean validate(ConfigurationDTO config) {
        return config.getName() != null && config.getData() != null;
    }

    public void save(ConfigurationDTO dto) {
        Configuration config = new Configuration();
        config.setName(dto.getName());
        config.setData(dto.getData());
        repository.save(config);
    }

    public ConfigurationDTO getById(Long id) {
        Optional<Configuration> config = repository.findById(id);
        if (config.isPresent()) {
            ConfigurationDTO dto = new ConfigurationDTO();
            dto.setName(config.get().getName());
            dto.setData(config.get().getData());
            return dto;
        }
        return null;
    }
}
