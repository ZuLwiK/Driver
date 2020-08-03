package pl.zulwik.driver.controller.tag;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import pl.zulwik.driver.dto.TagDTO;

import java.text.ParseException;
import java.util.List;

@Api
public interface TagApi {

    @ApiOperation(value = "View a list of available tags", response = Iterable.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 401, message = "Not authorized!"), @ApiResponse(code = 403, message = "Forbidden!"),
            @ApiResponse(code = 404, message = "Not found!")})
    public ResponseEntity<List<TagDTO>> getTagDTOList();

    @ApiOperation(value = "Search a tag with an ID", response = TagDTO.class)
    public ResponseEntity<TagDTO> getTagDTO(Long tagId);

    @ApiOperation(value = "Add a tag")
    public ResponseEntity<TagDTO> createTagDTO(TagDTO tagDTO) throws ParseException;

    @ApiOperation(value = "Update a tag")
    public ResponseEntity<TagDTO> updateTagDTO(Long tagId, TagDTO tagDTO) throws ParseException;

    @ApiOperation(value = "Delete a tag")
    public ResponseEntity<Void> deleteTagDTO(Long tagId);
}
