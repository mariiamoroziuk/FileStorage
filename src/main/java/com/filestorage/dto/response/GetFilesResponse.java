package com.filestorage.dto.response;

import com.filestorage.model.File;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetFilesResponse {
  private Long total;
  private Iterable<File> page;
}
