package com.filestorage.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class UploadFileRequest {
    @NotEmpty(message = "name empty")
    private String name;
    @Min(value = 1, message = "size wrong")
    private Long size;
}
