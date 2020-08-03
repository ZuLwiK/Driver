package pl.zulwik.driver.controller.advice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zulwik.driver.dto.AdviceDTO;
import pl.zulwik.driver.model.Advice;
import pl.zulwik.driver.service.impl.AdviceServiceImpl;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/advice")
@Slf4j
@RequiredArgsConstructor
public class AdviceController implements AdviceApi {
    private final AdviceServiceImpl adviceServiceImpl;
    private final ModelMapper modelMapper;


    @GetMapping
    @Override
    public ResponseEntity<List<AdviceDTO>> getAllAdviceDTOList() {
        List<AdviceDTO> advices = adviceServiceImpl.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        if (!advices.isEmpty()) {
            log.error("There are no advices in database");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(advices);
    }


    @GetMapping("/{id}")
    @Override
    public ResponseEntity<AdviceDTO> getAdviceDTO(@PathVariable("id") Long id) {
        Optional<Advice> advice = adviceServiceImpl.findById(id);
        if (!advice.isPresent()) {
            log.error("Advice with Id " + id + " does not exist");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(convertToDTO(advice.get()));
    }

    @PostMapping
    @Override
    public ResponseEntity<AdviceDTO> createAdviceDTO(@Valid @RequestBody AdviceDTO adviceDTO) throws ParseException {
        adviceServiceImpl.save(convertToEntity(adviceDTO));
        return ResponseEntity.ok(adviceDTO);
    }

    @Override
    public ResponseEntity<AdviceDTO> updateAdviceDTO(@PathVariable Long id, AdviceDTO adviceDTO) throws ParseException {
        if (!adviceServiceImpl.findById(id).isPresent()) {
            log.error("There is no advice with Id " + id + " to update");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(convertToDTO(adviceServiceImpl.update(id,convertToEntity(adviceDTO))));
    }

    @Override
    public ResponseEntity<Void> deleteAdviceDTO(Long id) {
        return null;
    }

    private AdviceDTO convertToDTO(Advice advice) {
        return modelMapper.map(advice, AdviceDTO.class);
    }

    private Advice convertToEntity(AdviceDTO adviceDTO) {
        return modelMapper.map(adviceDTO, Advice.class);
    }

}



