package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.mappers.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardMapper boardMapper;

    @Value("fileDir")
    String fileDir;

    @GetMapping("/list")
    public String getList() {
        return "board/list.html";
    }

    @GetMapping("/write")
    public String getWrite() {
        return "board/write.html";
    }

    @PostMapping("/write")
    public String setWrite(@ModelAttribute BoardDto boardDto, @RequestParam("file") MultipartFile mf) {

        System.out.println(boardDto.toString());

        if (!mf.isEmpty()) {

            String folderName = new SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis());
            File makefolder = new File(fileDir + folderName);

            if (!makefolder.exists()) {
                makefolder.mkdir();
            }

            String originalName = mf.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();
            String ext = originalName.substring(originalName.lastIndexOf("."));
            String savedFileName = uuid + ext;
            String savedFilePathName = fileDir + folderName + "/" + savedFileName;

            boardDto.setOriginalName(originalName);
            boardDto.setSavedFileName(savedFileName);
            boardDto.setSavedFilePathName(savedFilePathName);
            boardDto.setSavedFileSize(mf.getSize());
            boardDto.setFolderName(folderName);
            boardDto.setExt(ext);

            System.out.println(boardDto.toString());

            int maxGrp = boardMapper.getMaxgrp();

            boardDto.setGrp(maxGrp);
            System.out.println(boardDto.toString());
        }

        boardMapper.setWrite(boardDto);
        System.out.println(boardDto.toString());

        return "redirect:/board/list";
    }
}
