package com.example.fileupload.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Controller
public class UploadController {

    @Value("${fileDir}")
    String fileDir;

    @GetMapping("/upload")
    public String getUpload() {
        return "upload/uploadForm.html";
    }

    @PostMapping("/upload")
    public String setUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        // 저장을 위한 폴더 생성(날짜를 이용해서 생성)
        // 2023-11-24   20231124
        // 파일, 폴더를 만드는 준비 객체
        // File folderName = new File();

        new SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis());
        // System.out.println(new SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis()));

        String folderName = new SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis());
        File makeFolder = new File(fileDir + folderName);

        if (!makeFolder.exists()) {
            System.out.println(folderName);
            makeFolder.mkdir();
        }

        String originalName = file.getOriginalFilename();
        System.out.println(originalName);

        String ext = originalName.substring(originalName.lastIndexOf("."));
        System.out.println(ext);

        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);

        String newName = uuid + ext;
        System.out.println(newName);

        String savedPathFileName = fileDir + folderName + "/" + newName;
        System.out.println(savedPathFileName);

        String showImg = "/" + folderName + "/" + newName;
        System.out.println(showImg);

        file.transferTo(new File(savedPathFileName));

        model.addAttribute("newName", newName);
        model.addAttribute("folderName", folderName);
        model.addAttribute("savedPathFileName", savedPathFileName);
        model.addAttribute("showImg", showImg);
        model.addAttribute("fileDir", fileDir);

        return "upload/uploadView";
    }

    @GetMapping("/view")
    public String getView() {
        return "upload/uploadView.html";
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> getDownload(@RequestParam String savedPathFileName) throws MalformedURLException {
        System.out.println(savedPathFileName);
        UrlResource resource = new UrlResource("file:" + savedPathFileName);

        String encodedFileName = UriUtils.encode(savedPathFileName, StandardCharsets.UTF_8);
        String contentDisposition = "attachment; filename=\"" + encodedFileName + "\"";

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition).body(resource);
    }
}
