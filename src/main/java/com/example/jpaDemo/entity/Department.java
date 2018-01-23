package com.example.jpaDemo.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 部门
 *
 * @author ck
 * @date 2018/1/18 17:54
 */
@Entity
@Table(name = "department")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID", example = "1", position = 1, hidden = true)
    private Long id;

    @ApiModelProperty(value = "部门", example = "财务部", position = 2)
    private String name;

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

}
