package com.meguru.blog.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog implements Serializable {
    private int bid;
    private String title;
    private String content;
    private int uid;
    private int viewNumber;
    private Date createTime;
    private Date updateTime;
}
