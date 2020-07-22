package pl.zulwik.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zulwik.driver.model.DbFile;

@Repository
public interface DbFileRepository extends JpaRepository<DbFile, String> {
}
