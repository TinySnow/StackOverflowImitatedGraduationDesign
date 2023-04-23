package com.tinysnow.system.dto;

import com.tinysnow.system.model.Collection;
import com.tinysnow.system.model.Question;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CollectionDto {
    private Long id;
    private String title;
    private String author;
    private String description;
    private Date createdTime;
    private Date updatedTime;
    List<Question> question;
}
