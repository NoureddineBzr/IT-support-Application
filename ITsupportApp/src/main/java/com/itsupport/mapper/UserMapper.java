package com.itsupport.mapper;

import com.itsupport.dto.UserDto;
import com.itsupport.model.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {


    UserDto toDto(User user);
}
