package com.filestorage.model;

import com.filestorage.helper.Format;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Data
@Document(indexName = "fileindex")
public class File {
  @Id private String id;

  @Field private String name;

  @Field private Long size;

  @Field private Set<String> tags = new HashSet<>();

  public File(String name, Long size) {
    Format.identifyTag(name).ifPresent(f -> this.tags.add(f));
    this.name = name;
    this.size = size;
  }

  public void assignTags(String[] addTags) {
    Collections.addAll(this.tags, addTags);
  }

  public void removeTags(String[] removeTags) {
    for (String tag : removeTags) {
      if (!tags.contains(tag))
        throw new IllegalArgumentException(String.format("tag %s not found on file", tag));
    }
    this.tags.removeAll(Arrays.asList(removeTags));
  }
}
