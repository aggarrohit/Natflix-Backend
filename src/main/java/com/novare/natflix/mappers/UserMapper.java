package com.novare.natflix.mappers;

import com.novare.natflix.dtos.UserDto;
import com.novare.natflix.models.User;

public class UserMapper {

    private UserMapper(){}

    public static UserDto toUserDto(User user){
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        if(user.getRole().equals("ROLE_ADMIN")){
            userDto.setType(1);
        }else{
            userDto.setType(2);
        }

        return  userDto;
    }

}
