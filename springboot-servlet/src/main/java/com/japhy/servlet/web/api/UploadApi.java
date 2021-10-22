package com.japhy.servlet.web.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Japhy
 * @since 2021/8/26 09:59
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/upload")
public class UploadApi {

    @PostMapping("/file")
    public ResponseEntity<Void> uploadFile(@RequestParam("file") MultipartFile multipartFile)
            throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("a.txt", this.getClass());

        Files.copy(multipartFile.getInputStream(), Paths.get(classPathResource.getPath()),
                StandardCopyOption.REPLACE_EXISTING);
        return ResponseEntity.ok().build();
    }

}
