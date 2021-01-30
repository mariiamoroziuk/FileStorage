package com.filestorage.controller;

import com.filestorage.dto.request.UploadFileRequest;
import com.filestorage.dto.response.BaseResponse;
import com.filestorage.dto.response.GetFilesResponse;
import com.filestorage.dto.response.UploadFileResponse;
import com.filestorage.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("file")
@RequiredArgsConstructor
public class FileController {
  private final FileService service;

  @PostMapping
  public ResponseEntity<UploadFileResponse> upload(@RequestBody @Valid UploadFileRequest f) {
    return ResponseEntity.ok(service.upload(f));
  }

  @DeleteMapping("{ID}")
  public ResponseEntity<BaseResponse> delete(@PathVariable("ID") String id) {
    return ResponseEntity.ok(service.delete(id));
  }

  @GetMapping
  public ResponseEntity<GetFilesResponse> read(
      @RequestParam(required = false) List<String> tags,
      @RequestParam String page,
      @RequestParam String size) {
    return ResponseEntity.ok(service.read(tags, page, size));
  }

  @PostMapping("{ID}/tags")
  public ResponseEntity<BaseResponse> assignTags(
      @PathVariable("ID") String id, @RequestBody String[] tags) {
    return ResponseEntity.ok(service.assignTags(id, tags));
  }

  @DeleteMapping("{ID}/tags")
  public ResponseEntity<BaseResponse> removeTags(
      @PathVariable("ID") String id, @RequestBody String[] tags) {
    return ResponseEntity.ok(service.removeTags(id, tags));
  }
}
