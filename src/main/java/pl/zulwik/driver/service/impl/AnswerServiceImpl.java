package pl.zulwik.driver.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zulwik.driver.model.Answer;
import pl.zulwik.driver.repository.AnswerRepository;
import pl.zulwik.driver.service.AnswerService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    @Override
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public Optional<Answer> findById(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public void deleteById(Long id) {
        answerRepository.deleteById(id);
    }

}
