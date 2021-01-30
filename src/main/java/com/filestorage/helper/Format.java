package com.filestorage.helper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class Format {
  private static String getExtension(String s) {
    String[] arr = s.split("\\.");
    List<String> list = Arrays.asList(arr);
    Collections.reverse(list);
    return list.get(0);
  }

  private static Optional<String> identifyFormat(String format) {
    List<String> image = Arrays.asList("jpg", "png", "bmp", "gif", "tif");
    List<String> document =
        Arrays.asList("doc", "docx", "xls", "xlsx", "pdf", "txt", "zip", "rar", ".7z", "gzip");
    List<String> video = Arrays.asList("mp4", "avi", "mkv", "wmv", "flv", "mpeg");
    List<String> audio = Arrays.asList("mp3", "wav", "midi", "aac");

    if (image.contains(format)) return Optional.of("image");
    if (document.contains(format)) return Optional.of("document");
    if (video.contains(format)) return Optional.of("video");
    if (audio.contains(format)) return Optional.of("audio");
    return Optional.empty();
  }

  public static Optional<String> identifyTag(String fileName) {
    return identifyFormat(getExtension(fileName.toLowerCase()));
  }
}
