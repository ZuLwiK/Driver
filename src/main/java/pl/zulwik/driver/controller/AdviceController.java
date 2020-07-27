package pl.zulwik.driver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zulwik.driver.dto.AdviceDTO;
import pl.zulwik.driver.dto.TagDTO;
import pl.zulwik.driver.model.Advice;
import pl.zulwik.driver.model.Tag;
import pl.zulwik.driver.service.AdviceService;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/advice")
@Slf4j
@RequiredArgsConstructor
public class AdviceController {
    private final AdviceService adviceService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<AdviceDTO>> findAll(){
        List<AdviceDTO> advices = adviceService.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        if (!advices.isEmpty()){
            log.error("There are no advices in database");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(advices);
    }


    private AdviceDTO convertToDTO(Advice advice) {
        AdviceDTO adviceDTO = modelMapper.map(advice, AdviceDTO.class);
        return adviceDTO;
    }

    private Advice convertToEntity(AdviceDTO adviceDTO) throws ParseException {
        Advice advice = modelMapper.map(adviceDTO, Advice.class);
        return advice;
    }

}


