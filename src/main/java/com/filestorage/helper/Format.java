package com.filestorage.helper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Format {
    static final List<String> image = Arrays.asList("jpg", "png", "bmp", "gif", "tif");
    static final List<String> document = Arrays.asList("doc", "docx", "xls", "xlsx", "pdf", "txt", "zip", "rar", ".7z", "gzip");
    static final List<String> video = Arrays.asList("mp4", "avi", "mkv", "wmv", "flv", "mpeg");
    static final List<String> audio = Arrays.asList("mp3", "wav", "midi", "aac");

    static Optional<String> getExtension(String s){
        String[] arr = s.split("\\.");
        if(arr.length == 2)return Optional.of(arr[1]);
        return Optional.empty();
    }

    static Optional<String> identifyFormat(String format){
        if (image.contains(format)) return Optional.of("image");
        if (document.contains(format)) return Optional.of("document");
        if (video.contains(format)) return Optional.of("video");
        if (audio.contains(format)) return Optional.of("audio");
        return Optional.empty();
    }
    public static Optional<String> identifyTag(String fileName) {
        return getExtension(fileName).flatMap(Format::identifyFormat);
    }
}
