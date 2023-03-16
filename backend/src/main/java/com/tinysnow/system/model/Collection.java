package com.tinysnow.system.model;

import lombok.Data;

import java.util.Date;

/**
 * collection -
 *
 * @author Snow
 */
@Data
public class Collection {
    private Long id;
    private String title;
    private String author;
    private String description;
    private Date createdTime;
    private Date updatedTime;
}
