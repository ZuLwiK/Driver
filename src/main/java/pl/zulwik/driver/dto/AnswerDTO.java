package pl.zulwik.driver.dto;

import lombok.Data;
import pl.zulwik.driver.model.Answer;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
public class AnswerDTO {

    @NotBlank
    private Long id;

    @NotBlank
    private String content;

    @NotBlank
    private List<AnswerDTO> answers = new ArrayList<>();

    @NotBlank
    private Answer correctAnswer;
}
