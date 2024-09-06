package User.ucm.restUser;

import User.ucm.dtoUser.UsermanagementDTO;
import User.ucm.serviceUser.UsermanagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/usermanagement",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class UsermanagementController {

    private final UsermanagementService service;

    public UsermanagementController(UsermanagementService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UsermanagementDTO user) {
        if (service.validate(user)) {
            service.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
        } else {
            return ResponseEntity.badRequest().body("Error saving configuration due to invalid data");
        }
    }

    @GetMapping
    public ResponseEntity<?> getUser(@RequestParam(value = "id", required = false) Long id) {
        if (id != null) {
            UsermanagementDTO user = service.getById(id);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            List<UsermanagementDTO> users = service.getAll();
            return ResponseEntity.ok(users);
        }
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestParam Long id, @RequestBody UsermanagementDTO user) {
        if (service.validate(user)) {
            try {
                service.update(id, user);
                return ResponseEntity.ok("User updated successfully");
            } catch (RuntimeException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
        } else {
            return ResponseEntity.badRequest().body("Error updating configuration due to invalid data");
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestParam Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @GetMapping("/get-by-username")
    public ResponseEntity<?> findByUsername(@RequestParam("username") String username) {
        UsermanagementDTO user = service.getByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
