package com.filestorage.service;

import com.filestorage.dto.request.UploadFileRequest;
import com.filestorage.dto.response.BaseResponse;
import com.filestorage.dto.response.GetFilesResponse;
import com.filestorage.dto.response.UploadFileResponse;
import com.filestorage.model.File;
import com.filestorage.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository repository;

    public UploadFileResponse upload(UploadFileRequest f) {
        File file = repository.save(new File(f.getName(), f.getSize()));
        return new UploadFileResponse(file.getId());
    }

    public BaseResponse delete(String id) {
        repository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("file id %s not found", id)));
        repository.deleteById(id);
        return new BaseResponse(true);
    }

    public GetFilesResponse read(List<String> tags, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<File> files = (tags != null)
                ? repository.findAllByTags(tags, pageable)
                : repository.findAll(pageable);
        return new GetFilesResponse(files.getTotalElements(), files.getContent());
    }

    public BaseResponse assignTags(String id, String[] tags){
        return repository.findById(id)
                .map(f->{f.assignTags(tags); repository.save(f); return new BaseResponse(true);})
                .orElseThrow(() -> new NoSuchElementException(String.format("file id %s not found", id)));
    }

    public BaseResponse removeTags(String id, String[] tags){
        return repository.findById(id)
                .map(f->{f.removeTags(tags); repository.save(f); return new BaseResponse(true);})
                .orElseThrow(() -> new NoSuchElementException(String.format("file id %s not found", id)));
    }
}
