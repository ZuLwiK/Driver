package pl.zulwik.driver.service;

import pl.zulwik.driver.model.Advice;


import java.util.List;
import java.util.Optional;

public interface AdviceService {

    List<Advice> findAll();

    Optional<Advice> findById(Long id);

    Advice save(Advice advice);

    void deleteById(Long id);

    Advice update (Long id, Advice advice);

}

