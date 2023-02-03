package com.gj.qing.controller;

import com.gj.qing.ResultInfo;
import com.gj.qing.mode.dto.UserDto;
import com.gj.qing.mode.entity.UserEntity;
import com.gj.qing.service.UserSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: Gaojie
 * @Date: 2023/2/3
 * @Desc:
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserSerivce userSerivce;


    @PostMapping("/save")
    public ResultInfo<Object> save(@RequestBody UserDto dto) {
        userSerivce.save(dto);
        return ResultInfo.success();
    }

    @PostMapping("/update")
    public ResultInfo<Object> update(@RequestBody UserDto dto) {
        userSerivce.edit(dto);
        return ResultInfo.success();
    }


    @PostMapping("/detail")
    public ResultInfo<Object> detail(@RequestBody UserDto dto) {
        return ResultInfo.success(userSerivce.detail(dto));
    }


    @PostMapping("/delete")
    public ResultInfo<Object> delete(@RequestBody UserDto dto) {
        userSerivce.delete(dto);
        return ResultInfo.success();
    }
}
