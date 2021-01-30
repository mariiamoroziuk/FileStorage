package com.filestorage.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class UploadFileRequest {
  @NotEmpty(message = "name empty")
  private String name;

  @NotNull(message = "size null")
  @Min(value = 0, message = "size wrong")
  private Long size;
}
