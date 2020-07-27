package pl.zulwik.driver.service;

import pl.zulwik.driver.model.Advice;


import java.util.List;
import java.util.Optional;

public interface IAdviceService {

    List<Advice> findAll();

    Optional<Advice> findById(Long id);

    Advice save(Advice advice);

    void deleteById(Long id);

}

