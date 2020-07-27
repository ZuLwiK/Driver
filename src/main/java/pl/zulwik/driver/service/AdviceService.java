package pl.zulwik.driver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zulwik.driver.model.Advice;
import pl.zulwik.driver.repository.AdviceRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdviceService implements IAdviceService {

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

}
