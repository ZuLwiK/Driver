package pl.zulwik.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zulwik.driver.model.DBFile;

public interface DBFileRepository extends JpaRepository<DBFile, String> {
}
