package com.example.jpaDemo.resp;

import com.example.jpaDemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户实体持久化
 *
 * @author ck
 * @date 2018/1/18 18:45
 */
public interface UserRespository extends JpaRepository<User, Long> {

}
