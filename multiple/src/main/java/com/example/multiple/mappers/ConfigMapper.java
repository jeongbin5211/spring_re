package com.example.multiple.mappers;

import com.example.multiple.dto.ConfigDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ConfigMapper {
    @Select("select count(*) from config where config_code = #{configCode}")
    int checkConfigCode(String configCode);

    @Insert("insert into config values(null, #{configCode}, #{configTitle}, #{configComment}, #{configColor}, now())")
    void setConfigWrite(ConfigDto configDto);

    @Select("select * from config order by config_id desc")
    List<ConfigDto> getConfigList();

    @Update("update config set config_color = #{color} where config_id = #{id}")
    void getChangeColor(int id, String color);

    @Delete("delete from config where config_code = #{configCode}")
    void deleteConfig(String configCode);

    @Select("create table board_${configCode} (\n" +
            "id int not null auto_increment,\n" +
            "subject varchar(255) not null,\n" +
            "writer varchar(20) not null,\n" +
            "content text,\n" +
            "visit int,\n" +
            "regdate date,\n" +
            "grp int,\n" +
            "seq int,\n" +
            "depth int,\n" +
            "primary key(id)\n" +
            ");")
    void makeBoard(String configCode);

    @Select("create table files_${configCode}(\n" +
            "id int not null,\n" +
            "orgName varchar(255),\n" +
            "savedFileName varchar(255),\n" +
            "savedPathFileName varchar(255),\n" +
            "savedFileSize bigint,\n" +
            "folderName varchar(10),\n" +
            "ext varchar(20)\n" +
            ");")
    void makeFiles(String configCode);

    @Select("create table comment_${configCode}(\n" +
            "c_id int not null auto_increment,\n" +
            "c_subject varchar(50),\n" +
            "c_writer varchar(20),\n" +
            "c_comment varchar(100),\n" +
            "c_visit int,\n" +
            "c_regdate date,\n" +
            "primary key(c_id)\n" +
            ");")
    void makeComment(String configCode);

    @Select("drop table board_${configCode}")
    void dropBoard(String configCode);

    @Select("drop table files_${configCode}")
    void dropFiles(String configCode);

    @Select("drop table comment_${configCode}")
    void dropComment(String configCode);
}
