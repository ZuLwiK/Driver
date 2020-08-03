package pl.zulwik.driver.controller.advice;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import pl.zulwik.driver.dto.AdviceDTO;

import java.text.ParseException;
import java.util.List;

@Api
public interface AdviceApi {

    @ApiOperation(value = "Get list of advices in the DB", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!"),
            @ApiResponse(code = 404, message = "Not found!")
    }
    )
    public ResponseEntity<List<AdviceDTO>> getAllAdviceDTOList();

    @ApiOperation(value = "Search an advice with an ID", response = AdviceDTO.class)
    public ResponseEntity<AdviceDTO> getAdviceDTO(Long AdviceId);

    @ApiOperation(value = "Add an advice", response = AdviceDTO.class)
    public ResponseEntity<AdviceDTO> createAdviceDTO(AdviceDTO adviceDTO) throws ParseException;

    @ApiOperation(value = "Update an advice", response = String.class)
    public ResponseEntity<AdviceDTO> updateAdviceDTO(Long adviceId, AdviceDTO adviceDTO) throws ParseException;

    @ApiOperation(value = "Delete an advice", response = String.class)
    public ResponseEntity<Void> deleteAdviceDTO(Long adviceId);
}
