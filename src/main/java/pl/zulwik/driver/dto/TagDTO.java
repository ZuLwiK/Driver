package pl.zulwik.driver.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TagDTO {

    @NotBlank
    private Long id;

    @NotBlank
    private String name;

}
