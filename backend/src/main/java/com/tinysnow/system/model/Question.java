package com.tinysnow.system.model;

import lombok.Data;

import java.util.Date;

/**
 * question -
 *
 * @author Snow
 */
@Data
public class Question {
    private Long id;
    private String author;
    private String title;
    private String content;
    private Integer reward;
    private Date createdTime;
    private Date updatedTime;
}
