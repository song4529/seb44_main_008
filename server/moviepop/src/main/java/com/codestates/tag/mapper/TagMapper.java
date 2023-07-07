package com.codestates.tag.mapper;

import com.codestates.reviewBoard.dto.ReviewBoardDto;
import com.codestates.reviewBoard.entity.ReviewBoard;
import com.codestates.reviewBoard.entity.ReviewBoardTag;
import com.codestates.tag.dto.TagDto;
import com.codestates.tag.entity.Tag;
import com.codestates.user.dto.UserDto;
import com.codestates.user.entity.UserTag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {

    TagDto.response tagToResponse(Tag tag);
    List<TagDto.response> tagsToResponses(List<Tag> tag);
    Tag requestToReviewBoardTag(TagDto.ReviewBoardRequest reviewBoardRequest);

    List<Tag> requestsToReviewBoardTags(List<TagDto.ReviewBoardRequest> reviewBoardRequests);

    Tag userToUserTag(TagDto.UserRequest userRequest);

    List<Tag> userToUserTags(List<TagDto.UserRequest> userRequests);

    // List<TagDto.ReviewBoardRequest> -> List<ReviewBoardTag>

    @Mapping(source = "tagId", target = "tag.tagId")
    ReviewBoardTag reviewBoardRequestToReviewBoardTag(TagDto.ReviewBoardRequest request);
    List<ReviewBoardTag> reviewBoardsRequestToReviewBoardTags(List<TagDto.ReviewBoardRequest> requests);

    @Mapping(source = "tagId", target = "tag.tagId")
    UserTag userRequestToUserTag(TagDto.UserRequest request);
    List<UserTag> usersRequestToUserTags(List<TagDto.UserRequest> requests);

    Tag userTagToTag(UserTag userTag);

    List<Tag> userTagToTags(List<UserTag> userTags);
}
