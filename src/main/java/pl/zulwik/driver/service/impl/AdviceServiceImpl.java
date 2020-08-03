package pl.zulwik.driver.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zulwik.driver.model.Advice;
import pl.zulwik.driver.repository.AdviceRepository;
import pl.zulwik.driver.service.AdviceService;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdviceServiceImpl implements AdviceService {

    private final AdviceRepository adviceRepository;

    @Override
    public List<Advice> findAll() {
        return adviceRepository.findAll();
    }

    @Override
    public Optional<Advice> findById(Long id) {
        return adviceRepository.findById(id);
    }

    @Override
    public Advice save(Advice advice) {
        return adviceRepository.save(advice);
    }


    @Override
    public void deleteById(Long id) {
        adviceRepository.deleteById(id);
    }

    @Override
    public Advice update(Long id, Advice advice) {
        if (adviceRepository.findById(id).isPresent()) {
            Advice existingAdvice = adviceRepository.findById(id).get();
            existingAdvice.setTitle(advice.getTitle());
            existingAdvice.setContent(advice.getContent());
            existingAdvice.setQuestions(advice.getQuestions());
            existingAdvice.setTags(advice.getTags());
            existingAdvice.setCreated(advice.getCreated());
            existingAdvice.setUpdated(LocalDateTime.now());
            return existingAdvice;
        } else {
            throw new EntityNotFoundException("Advice with Id " + id.toString() + " not found in the database");
        }
    }
}