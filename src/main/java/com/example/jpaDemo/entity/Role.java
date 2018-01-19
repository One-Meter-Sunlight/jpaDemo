package com.example.jpaDemo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 角色
 *
 * @author ck
 * @date 2018/1/18 17:56
 */
@Entity
@Table(name = "role")
public class Role implements Serializable {

    private Long id;
    private String name;

    public Role(){}
}
