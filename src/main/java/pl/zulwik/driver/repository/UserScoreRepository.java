package pl.zulwik.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zulwik.driver.model.UserScore;

public interface UserScoreRepository extends JpaRepository<UserScore,Long> {
}
