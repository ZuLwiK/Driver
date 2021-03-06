package pl.zulwik.driver.service;

import pl.zulwik.driver.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {

    List<Tag> findAll();

    Optional<Tag> findById(Long id);

    Tag save(Tag tag);

    void deleteById(Long id);

    Tag update(Long id, Tag tag);

}
