package com.goriant.nova.ucm.service;

import com.goriant.nova.ucm.dto.ConfigurationDTO;
import com.goriant.nova.ucm.entity.Configuration;
import com.goriant.nova.ucm.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConfigurationService {

    private final ConfigurationRepository repository;

    public ConfigurationService(ConfigurationRepository repository) {
        this.repository = repository;
    }

    // Kiểm tra tính hợp lệ của thông tin người dùng
/*    public boolean validate(ConfigurationDTO config) {
        return config.getName() != null && config.getData() != null;
    }*/
    public boolean validate(ConfigurationDTO config) {
        return config.getName() != null && config.getName() != null;
    }

    // Lưu thông tin người dùng
/*    public void save(ConfigurationDTO dto) {
        Configuration config = new Configuration();
        config.setName(dto.getName());
        config.setEmail(dto.getData());
        repository.save(config);
    }*/
    public void save(ConfigurationDTO dto) {
        Configuration config = new Configuration();
        config.setName(dto.getName());
        config.setPasswordHash(dto.getPasswordHash());
        config.setEmail(dto.getEmail());
        config.setProfilePicture(dto.getProfilePicture());
        config.setCreatedAt(dto.getCreatedAt());
        config.setCreatedBy(dto.getCreatedBy());
        config.setUpdatedAt(dto.getUpdatedAt());
        config.setUpdatedBy(dto.getUpdatedBy());
        repository.save(config);
    }

    // Lấy danh sách tất cả người dùng
/*    public List<ConfigurationDTO> getAll(){
        List<Configuration> configs = repository.findAll();
        List<ConfigurationDTO> result = new ArrayList<>();
        for(Configuration config : configs) {
            ConfigurationDTO dto = new ConfigurationDTO();
            dto.setName(config.getName());
            dto.setData(config.getEmail());
            result.add(dto);
        }
        return result;
    }*/
    public List<ConfigurationDTO> getAll() {
        List<Configuration> configs = repository.findAll();
        List<ConfigurationDTO> result = new ArrayList<>();
        for (Configuration config : configs) {
            ConfigurationDTO dto = new ConfigurationDTO();
            dto.setUserId(config.getId());
            dto.setName(config.getName());
            dto.setPasswordHash(config.getPasswordHash());
            dto.setEmail(config.getEmail());
            dto.setProfilePicture(config.getProfilePicture());
            dto.setCreatedAt(config.getCreatedAt());
            dto.setCreatedBy(config.getCreatedBy());
            dto.setUpdatedAt(config.getUpdatedAt());
            dto.setUpdatedBy(config.getUpdatedBy());
            result.add(dto);
        }
        return result;
    }

    // Lấy thông tin người dùng theo ID
   /* public ConfigurationDTO getById(Long id) {
        Optional<Configuration> config = repository.findById(id);
        if (config.isPresent()) {
            ConfigurationDTO dto = new ConfigurationDTO();
            dto.setName(config.get().getName());
            dto.setData(config.get().getEmail());
            return dto;
        }
        return null;*/
    public ConfigurationDTO getById(Long id) {
        Optional<Configuration> config = repository.findById(id);
        if (config.isPresent()) {
            ConfigurationDTO dto = new ConfigurationDTO();
            dto.setUserId(config.get().getId());
            dto.getName(config.get().getName());
            dto.setPasswordHash(config.get().getPasswordHash());
            dto.setEmail(config.get().getEmail());
            dto.setProfilePicture(config.get().getProfilePicture());
            dto.setCreatedAt(config.get().getCreatedAt());
            dto.setCreatedBy(config.get().getCreatedBy());
            dto.setUpdatedAt(config.get().getUpdatedAt());
            dto.setUpdatedBy(config.get().getUpdatedBy());
            return dto;

        }
        return null;
    }
  // cập nhật thông tin theo id
    public void update(Long id, ConfigurationDTO dto) {
        Optional<Configuration> optionalConfiguration = repository.findById(id);
        if (optionalConfiguration.isPresent()) {
            Configuration config = optionalConfiguration.get();
            config.setName(dto.getName());
            config.setPasswordHash(dto.getPasswordHash());
            config.setEmail(dto.getEmail());
            config.setProfilePicture(dto.getProfilePicture());
            config.setCreatedAt(dto.getCreatedAt());
            config.setCreatedBy(dto.getCreatedBy());
            config.setUpdatedAt(dto.getUpdatedAt());
            config.setUpdatedBy(dto.getUpdatedBy());
            repository.save(config);
        } else {
            throw new RuntimeException("Configuration with ID " + id + " does not exist.");
        }
    }
    // Xóa thông tin người dùng theo ID
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Configuration with ID " + id + " does not exist.");
        }
    }
    @Autowired
    private ConfigurationRepository Repository;

    public  ConfigurationDTO getByConfigName(String Name){
        Optional<Configuration> config = Repository.findByName(Name);
        return config.map(this::convertoDTO).orElse(null);
    }
    public ConfigurationDTO convertoDTO(Configuration config){
        return new ConfigurationDTO(
                config.getId(),
                config.getName(),
                config.getPasswordHash(),
                config.getEmail(),
                config.getProfilePicture(),
                config.getCreatedAt(),
                config.getCreatedBy(),
                config.getUpdatedAt(),
                config.getUpdatedBy()
        );
    }
}
