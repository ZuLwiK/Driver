package pl.zulwik.driver.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zulwik.driver.model.Question;
import pl.zulwik.driver.repository.QuestionRepository;
import pl.zulwik.driver.service.QuestionService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }

}
