package pl.zulwik.driver.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zulwik.driver.model.Tag;
import pl.zulwik.driver.repository.TagRepository;
import pl.zulwik.driver.service.TagService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> findById(Long id) {
        return tagRepository.findById(id);
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void deleteById(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public Tag update(Long id, Tag tag) {
        if (tagRepository.findById(id).isPresent()) {
            Tag existingTag = tagRepository.findById(id).get();
            existingTag.setName(tag.getName());
            return existingTag;
        } else {
            throw new EntityNotFoundException("Tag with Id " + id.toString() + " not found in the database");
        }
    }
}