package pl.zulwik.driver.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class AdviceDTO {

    @NotBlank
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private List<QuestionDTO> questions = new ArrayList<>();

    @NotBlank
    private List<TagDTO> tags = new ArrayList<>();

    @NotBlank
    private LocalDateTime created = LocalDateTime.now();

    @NotBlank
    private LocalDateTime updated = LocalDateTime.now();

}
