package pl.zulwik.driver.service;

import pl.zulwik.driver.model.Tag;

import java.util.List;
import java.util.Optional;

public interface ITagService {

    List<Tag> findAll();

    Optional<Tag> findById(Long id);

    Tag save(Tag tag);

    void deleteById(Long id);

}
