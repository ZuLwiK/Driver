package pl.zulwik.driver.controller.tag;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zulwik.driver.dto.TagDTO;
import pl.zulwik.driver.model.Tag;
import pl.zulwik.driver.service.impl.TagServiceImpl;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/advice/tag")
@Slf4j
@RequiredArgsConstructor
public class TagController implements TagApi {

    private final TagServiceImpl tagServiceImpl;

    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<TagDTO>> getTagDTOList() {
        List<TagDTO> tags = tagServiceImpl.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        if (!tags.isEmpty()) {
            log.error("There are no tags in database");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(tags);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<TagDTO> getTagDTO(@PathVariable("id") Long id) {
        Optional<Tag> tag = tagServiceImpl.findById(id);
        if (!tag.isPresent()) {
            log.error("Id " + id + " does not exist");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(convertToDTO(tag.get()));
    }

    @PostMapping
    public ResponseEntity<TagDTO> createTagDTO(@Valid @RequestBody TagDTO tagDTO) throws ParseException {
        tagServiceImpl.save(convertToEntity(tagDTO));
        return ResponseEntity.ok(tagDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagDTO> updateTagDTO(@PathVariable Long id, @Valid @RequestBody TagDTO tagDTO) throws ParseException {
        if (!tagServiceImpl.findById(id).isPresent()) {
            log.error("There is no tag with Id " + id + " to update");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(convertToDTO(tagServiceImpl.update(id,convertToEntity(tagDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTagDTO(@PathVariable Long id) {
        if (!tagServiceImpl.findById(id).isPresent()) {
            log.error("Id " + id + " does not exist");
            ResponseEntity.badRequest().build();
        }
        tagServiceImpl.deleteById(id);
        return ResponseEntity.ok().build();
    }

    private TagDTO convertToDTO(Tag tag) {
        return modelMapper.map(tag, TagDTO.class);
    }

    private Tag convertToEntity(TagDTO tagDTO) {
        return modelMapper.map(tagDTO, Tag.class);

    }
}
