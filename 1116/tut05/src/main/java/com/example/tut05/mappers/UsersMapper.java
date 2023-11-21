package com.example.tut05.mappers;

import com.example.tut05.dto.UsersDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper {

    @Insert("insert into users values(#{email}, #{passwd});")
    public void setInsert(UsersDto usersDto);
}
