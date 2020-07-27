package pl.zulwik.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zulwik.driver.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
