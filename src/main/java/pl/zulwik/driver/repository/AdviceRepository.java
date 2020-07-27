package pl.zulwik.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zulwik.driver.model.Advice;

public interface AdviceRepository extends JpaRepository<Advice,Long> {
}
