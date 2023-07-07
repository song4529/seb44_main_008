package com.codestates.user.mapper;

import com.codestates.tag.dto.TagDto;
import com.codestates.tag.mapper.TagMapper;
import com.codestates.user.dto.UserDto;
import com.codestates.user.dto.UserResponseDto;
import com.codestates.user.entity.User;
import com.codestates.user.entity.UserTag;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    default User userPostDtoToUser(UserDto.Post userPostDto, TagMapper tagMapper) {
        List<UserTag> userTags = tagMapper.usersRequestToUserTags(userPostDto.getTags());

        User user = User.builder()
                .email(userPostDto.getEmail())
                .nickname(userPostDto.getNickname())
                .password(userPostDto.getPassword())
                .profileImage(userPostDto.getProfileImage())
                .name(userPostDto.getName())
                .birth(userPostDto.getBirth())
                .userTags(userTags)
                .build();

        return user;
    }
    User userPatchDtoToUser(UserDto.Patch userPatchDto);
    UserDto.Patch userToUserPatchDto(User user);
    default List<UserTag> userPatchDtoToUserTags(UserDto.Patch userPatchDto, TagMapper tagMapper) {
        List<UserTag> userTags = tagMapper.usersRequestToUserTags(userPatchDto.getTags());

        return userTags;
    }
    UserDto.Response userToUserBriefResponseDto(User user);

    UserResponseDto userToUserResponseDto(User user);

    //default UserResponseDto
}