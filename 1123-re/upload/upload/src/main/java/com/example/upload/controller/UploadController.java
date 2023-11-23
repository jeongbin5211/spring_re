package com.example.upload.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadController {

    @Value("${fileDir}")
    String fileDir;

    @GetMapping("/upload")
    public String getUpload() {
        return "upload/upload.html";
    }

    @PostMapping("/upload")
    public String setUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize() / 1000 + "KB");

        String originalName = file.getOriginalFilename();

//      파일 중복 -> 변경(uuid) -> 확장자 기준으로 배열 0 -> uuid 변경하여 저장
//      UUID 임의의 난수 생성
//      UUID.randomUUID();
//      UUID를 String으로 변경 : String.valueOf 또는 .toString 사용
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);

//      확장자 앞에있는 .을 기준으로 자르기

        originalName.lastIndexOf(".");
        System.out.println(originalName.lastIndexOf(".")); // 4

        String ext = originalName.substring(originalName.lastIndexOf("."));
        System.out.println(ext); // .png

        String newName = uuid + ext;
        System.out.println(newName);

        // properties에 fileDir 경로작성 및 추가설정
        // 상단에 @Value("${fileDir}")을 작성해서 파일 저장 경로 가져오기
        
        String savePathFile = fileDir + newName;
        System.out.println(savePathFile);

        // file.transferTo(경로)를 실행하면 지정한 경로에 파일이 저장되고
        // 파일과 폴더 경로를 추상화한 것이 File 객체입니다.
        // new File()은 특정 경로를 가지는 File 객체를 만드는 것
        // 즉 savePathFile 경로를 가지는 File객체를 만들고 file을 해당 경로로 저장시킴
        file.transferTo(new File(savePathFile));

        model.addAttribute("newName", newName);


        return "upload/view";

    }

    @GetMapping("/view")
    public String getView() {
        return "upload/view";
    }
}
