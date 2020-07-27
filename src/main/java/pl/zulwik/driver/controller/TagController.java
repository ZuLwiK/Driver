package pl.zulwik.driver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zulwik.driver.dto.TagDTO;
import pl.zulwik.driver.model.Tag;
import pl.zulwik.driver.service.ITagService;
import pl.zulwik.driver.service.TagService;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/advice/tag")
@Slf4j
@RequiredArgsConstructor
public class TagController {

    private final ITagService tagService;

    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<TagDTO>> findAll() {
        List<TagDTO> tags = tagService.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        if (!tags.isEmpty()) {
            log.error("There are no tags in database");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(tags);
    }

    @PostMapping
    public ResponseEntity<TagDTO> create(@Valid @RequestBody TagDTO tagDTO) throws ParseException {

        return ResponseEntity.ok(convertToDTO(tagService.save(convertToEntity(tagDTO))));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<TagDTO> findById(@PathVariable("id") Long id) {
        Optional<Tag> tag = tagService.findById(id);
        if (!tag.isPresent()) {
            log.error("Id " + id + " does not exist");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(convertToDTO(tag.get()));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody TagDTO tagDTO) throws ParseException {
        if (!tagService.findById(id).isPresent()) {
            log.error("Id " + id + " does not exist");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(tagService.save(convertToEntity(tagDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!tagService.findById(id).isPresent()) {
            log.error("Id " + id + " does not exist");
            ResponseEntity.badRequest().build();
        }
        tagService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    private TagDTO convertToDTO(Tag tag) {
        TagDTO tagDTO = modelMapper.map(tag, TagDTO.class);
        return tagDTO;
    }

    private Tag convertToEntity(TagDTO tagDTO) throws ParseException {
        Tag tag = modelMapper.map(tagDTO, Tag.class);
        return tag;
    }
}
