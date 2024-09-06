package User.ucm.serviceUser;

import User.ucm.dtoUser.UsermanagementDTO;
import User.ucm.entityUser.UsermanagementEntity;
import User.ucm.repositoryUser.UsermanagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsermanagementService {

    private final UsermanagementRepository repository;

    @Autowired
    public UsermanagementService(UsermanagementRepository repository) {
        this.repository = repository;
    }

    // Validate user information
    public boolean validate(UsermanagementDTO user) {
        return user.getUsername() != null && user.getEmail() != null;
    }

    // Save user information
    public void save(UsermanagementDTO dto) {
        UsermanagementEntity user = new UsermanagementEntity();
        user.setUsername(dto.getUsername());
        user.setPasswordHash(dto.getPasswordHash()); // Corrected method name
        user.setEmail(dto.getEmail());
        user.setProfilePicture(dto.getProfilePicture());
        user.setCreatedAt(dto.getCreatedAt());
        user.setCreatedBy(dto.getCreatedBy());
        user.setUpdatedAt(dto.getUpdatedAt());
        user.setUpdatedBy(dto.getUpdatedBy());
        repository.save(user);
    }

    // Get all users
    public List<UsermanagementDTO> getAll() {
        List<UsermanagementEntity> users = repository.findAll();
        List<UsermanagementDTO> result = new ArrayList<>();
        for (UsermanagementEntity user : users) {
            result.add(convertToDTO(user)); // Consistent method name
        }
        return result;
    }

    // Get user by ID
    public UsermanagementDTO getById(Long id) {
        Optional<UsermanagementEntity> user = repository.findById(id);
        return user.map(this::convertToDTO).orElse(null); // Consistent method name
    }

    // Update user by ID
    public void update(Long id, UsermanagementDTO dto) {
        Optional<UsermanagementEntity> optionalUser = repository.findById(id);
        if (optionalUser.isPresent()) {
            UsermanagementEntity user = optionalUser.get();
            user.setUsername(dto.getUsername());
            user.setPasswordHash(dto.getPasswordHash()); // Corrected method name
            user.setEmail(dto.getEmail());
            user.setProfilePicture(dto.getProfilePicture());
            user.setUpdatedAt(dto.getUpdatedAt());
            user.setUpdatedBy(dto.getUpdatedBy());
            repository.save(user);
        } else {
            throw new RuntimeException("User with ID " + id + " does not exist.");
        }
    }

    // Delete user by ID
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("User with ID " + id + " does not exist.");
        }
    }

    // Get user by username
    public UsermanagementDTO getByUsername(String username) {
        Optional<UsermanagementEntity> user = repository.findByUsername(username); // Corrected method name
        return user.map(this::convertToDTO).orElse(null);
    }

    // Convert Entity to DTO
    private UsermanagementDTO convertToDTO(UsermanagementEntity user) {
        return new UsermanagementDTO(
                user.getId(),
                user.getUsername(),
                user.getPasswordHash(),
                user.getEmail(),
                user.getProfilePicture(),
                user.getCreatedAt(),
                user.getCreatedBy(),
                user.getUpdatedAt(),
                user.getUpdatedBy()
        );
    }
}
