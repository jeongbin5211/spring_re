package com.example.multiple.service;

import com.example.multiple.dto.ConfigDto;
import com.example.multiple.mappers.ConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigService {

    @Autowired
    ConfigMapper configMapper;

    public int checkConfigCode(String configCode) {

        return configMapper.checkConfigCode(configCode);
    }

    public void setConfigWrite(ConfigDto configDto) {
        configMapper.setConfigWrite(configDto);
    }

    public List<ConfigDto> getConfigList() {
        return configMapper.getConfigList();
    }

    public void getChangeColor(int id, String color) {
        configMapper.getChangeColor(id, color);
    }

    public void deleteConfig(String configCode) {
        configMapper.deleteConfig(configCode);
    }

    public void makeBoard(String configCode) {
        configMapper.makeBoard(configCode);
    }

    public void makeFiles(String configCode) {
        configMapper.makeFiles(configCode);
    }

    public void makeComment(String configCode) {
        configMapper.makeComment(configCode);
    }

    public void dropBoard(String configCode) {
        configMapper.dropBoard(configCode);
    }

    public void dropFiles(String configCode) {
        configMapper.dropFiles(configCode);
    }

    public void dropComment(String configCode) {
        configMapper.dropComment(configCode);
    }
}
