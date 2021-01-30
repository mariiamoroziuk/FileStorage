package com.filestorage.repository;

import com.filestorage.model.File;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends ElasticsearchRepository<File, String> {
  Page<File> findAllByTags(List<String> tags, Pageable pageable);
}
