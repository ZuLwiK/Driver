package pl.zulwik.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zulwik.driver.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByUsername(String username);

    UserEntity getByEmail(String email);
}
