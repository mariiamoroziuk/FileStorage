package com.filestorage.dto.response;

import lombok.Data;

@Data
public class ExceptionResponse {
  private boolean success = false;
  private String error;

  public ExceptionResponse(String error) {
    this.error = error;
  }
}
