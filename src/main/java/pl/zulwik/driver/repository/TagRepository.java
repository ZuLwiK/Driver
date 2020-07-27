package pl.zulwik.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zulwik.driver.model.Tag;

public interface TagRepository extends JpaRepository<Tag,Long> {
}
