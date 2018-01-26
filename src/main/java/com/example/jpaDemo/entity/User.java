package com.example.jpaDemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 职员
 *
 * @author ck
 * @date 2018/1/18 17:55
 */
@Entity
@Table(name = "user")
@ApiModel(value = "职员信息")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID", example = "1", position = 1, hidden = true)
    private Long id;

    @Column(name = "name")
    @ApiModelProperty(value = "姓名", example = "张飞", position = 2)
    private String name;

    @Column(name = "create_date")
    @ApiModelProperty(value = "日期", example = "1516947412747", position = 3)
    private Timestamp createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
}
