package com.gj.qing.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gj.qing.ResultInfo;
import com.gj.qing.mode.dto.UserDto;
import com.gj.qing.mode.entity.UserEntity;
import com.gj.qing.service.UserSerivce;
import com.gj.qing.socket.WebSocket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

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

    @Resource
    private WebSocket webSocket;


    @PostMapping("/save")
    public ResultInfo<Object> save(@RequestBody UserDto dto) {
        Long id = userSerivce.save(dto);
        return ResultInfo.success(id);
    }

    @PostMapping("/update")
    public ResultInfo<Object> update(@RequestBody UserDto dto) {
        userSerivce.edit(dto);
        return ResultInfo.success();
    }


    @PostMapping("/detail/{userId}")
    public ResultInfo<Object> detail(@PathVariable("userId") Long userId) {
        return ResultInfo.success(userSerivce.detail(userId));
    }


    @PostMapping("/delete")
    public ResultInfo<Object> delete(@RequestBody UserDto dto) {
        userSerivce.delete(dto);
        return ResultInfo.success();
    }

    @PostMapping("/list")
    public ResultInfo<Object> list(@RequestBody UserDto dto) {
        IPage<UserEntity> page = userSerivce.getList(dto);
        return ResultInfo.success(page);
    }

    @PostMapping("/test")
    public ResultInfo<Object> test(@RequestBody UserDto dto) throws IOException {
        webSocket.sendMessageByUserId(dto.getId().toString(), dto.getName());
        return ResultInfo.success();
    }
}
