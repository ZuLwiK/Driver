package pl.zulwik.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zulwik.driver.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
