package pl.zulwik.driver.controller.question;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import pl.zulwik.driver.dto.QuestionDTO;

import java.text.ParseException;
import java.util.List;

@Api
public interface QuestionApi {
    @ApiOperation(value = "View a list of available questions", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!"),
            @ApiResponse(code = 404, message = "Not found!")
    }
    )
    public ResponseEntity<List<QuestionDTO>> getQuestionDTOList();

    @ApiOperation(value = "Search a question with an ID", response = QuestionDTO.class)
    public ResponseEntity<QuestionDTO> getQuestionDTO(Long questionId);

    @ApiOperation(value = "Add a question")
    public ResponseEntity<QuestionDTO> createTagDTO(QuestionDTO questionDTO) throws ParseException;

    @ApiOperation(value = "Update a question")
    public ResponseEntity<QuestionDTO> updateTagDTO(Long questionId, QuestionDTO questionDTO) throws ParseException;

    @ApiOperation(value = "Delete a question")
    public ResponseEntity<Void> deleteQuestionDTO(Long questionId);
}
