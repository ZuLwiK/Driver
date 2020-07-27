package pl.zulwik.driver.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DBFileDTO {

    @NotBlank
    private Long id;

    @NotBlank
    private String fileName;

    @NotBlank
    private String fileType;

    @NotBlank
    private byte[] data;

}
