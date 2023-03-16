package com.tinysnow.system.model;

import lombok.Data;

import java.util.Date;

/**
 * post -
 *
 * @author Snow
 */
@Data
public class Post {
    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createdTime;
    private Date updatedTime;
}
