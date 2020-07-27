package pl.zulwik.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zulwik.driver.model.Question;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
