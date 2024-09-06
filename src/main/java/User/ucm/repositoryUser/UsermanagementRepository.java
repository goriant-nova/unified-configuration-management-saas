package User.ucm.repositoryUser;

import User.ucm.entityUser.UsermanagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsermanagementRepository extends JpaRepository<UsermanagementEntity, Long> {
    Optional<UsermanagementEntity> findByUsername(String username);  // Sửa lại tên phương thức
    Optional<UsermanagementEntity> findByEmail(String email);
}
