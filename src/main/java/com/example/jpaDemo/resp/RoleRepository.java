package com.example.jpaDemo.resp;

import com.example.jpaDemo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 角色实体持久化
 *
 * @author ck
 * 2018/1/19 13:44
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

}
