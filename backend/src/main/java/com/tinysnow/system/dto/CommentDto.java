package com.tinysnow.system.dto;

import com.tinysnow.system.model.Comment;
import lombok.Data;

@Data
public class CommentDto {
    private Comment comment;
    private UserDto userDto;
}
