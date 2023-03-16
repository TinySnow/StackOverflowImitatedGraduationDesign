package com.tinysnow.system.model;

import lombok.Data;

import java.util.Date;

/**
 * comment -
 *
 * @author Snow
 */
@Data
public class Comment {
    private Long id;
    private String question;
    private String parent;
    private String author;
    private String content;
    private Integer upvote;
    private Integer devote;
    private Date createdTime;
    private Date updatedTime;
    private Integer status;
}
