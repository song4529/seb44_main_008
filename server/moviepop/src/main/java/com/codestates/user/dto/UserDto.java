package com.codestates.user.dto;

import com.codestates.tag.dto.TagDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class UserDto {
    @Getter
    @AllArgsConstructor
    public static class Post{
        @NotBlank
        @Email
        private String email;

        @NotBlank
        private String nickname;

        private String profileImage;

        @NotBlank
        private String name;

        @NotBlank
        private String birth;

        @NotBlank
        private String password;

        @NotNull
        private List<TagDto.UserRequest> tags;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch{
        @Setter
        private long userId;
        @NotBlank
        private String nickname;
        private String profileImage;

        @NotNull
        private List<TagDto.UserRequest> tags;
    }

    @Getter
    @AllArgsConstructor
    public static class PatchPassword{
        @NotBlank
        private String currentPassword;

        @NotBlank
        private String newPassword;
    }

    @Getter
    @Builder
    public static class Response{
        private Long userId;
        private String name;
        private String nickname;
        private String email;
        private String profileImage;
//        private List<TagDto.UserRequest> tags;
    }

    @Getter
    @AllArgsConstructor
    public static class ReviewBoardResponse {
        private long userId;
        private String username;
        private String profileImage;
    }
}
