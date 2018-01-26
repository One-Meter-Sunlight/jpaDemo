package com.example.jpaDemo.controller;

import com.example.jpaDemo.entity.User;
import com.example.jpaDemo.resp.UserRespository;
import com.example.jpaDemo.util.JSONUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户管理
 *
 * @author ck
 * 2018/1/19 13:46
 */
@Controller
@RequestMapping("user")
@Api(value = "user", description = "用户管理接口")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRespository userRespository;

    /**
     * 添加
     *
     * @param user
     */
    @ApiOperation(value = "添加对象")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void add(@RequestBody User user) {
        if (logger.isDebugEnabled()) {
            logger.debug("参数==>" + JSONUtil.toJSONString(user));
        }
        userRespository.save(user);
    }

    /**
     * 删除
     *
     * @param id
     */
    @ApiOperation(value = "删除对象")
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public void delete(@RequestParam(value = "id") Long id) {
        if (logger.isDebugEnabled()) {
            logger.debug(String.valueOf(id));
        }
        userRespository.delete(id);
    }

    /**
     * 修改
     *
     * @param user
     */
    @ApiOperation(value = "修改对象")
    @RequestMapping(value = "udpate", method = RequestMethod.POST)
    public void udpate(@RequestBody User user) {
        if (logger.isDebugEnabled()) {
            logger.debug("参数==>" + JSONUtil.toJSONString(user));
        }
        userRespository.save(user);
    }

    /**
     * 查询对象
     *
     * @param id
     */
    @ApiOperation(value = "查询对象")
    @RequestMapping(value = "getOne", method = RequestMethod.GET)
    public void getOne(@RequestParam(value = "id") Long id) {
        if (logger.isDebugEnabled()) {
            logger.debug(String.valueOf(id));
        }
        User user = userRespository.getOne(id);
        if (logger.isDebugEnabled()) {
            logger.debug("返回结果==>" + JSONUtil.toJSONString(user));
        }
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "分页查询对象")
    @RequestMapping(value = "getAllPage", method = RequestMethod.GET)
    public void getAllPage() {
        Page<User> page = (Page<User>) userRespository.findAll();
        if (logger.isDebugEnabled()) {
            logger.debug("返回结果==>" + JSONUtil.toJSONString(page));
        }
    }

}
