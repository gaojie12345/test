package com.gj.qing.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gj.qing.mode.dto.UserDto;
import com.gj.qing.mode.entity.UserEntity;

public interface UserSerivce extends IService<UserEntity> {


    Long save(UserDto dto);

    void edit(UserDto dto);

    UserEntity detail(Long userId);

    void delete(UserDto dto);

    IPage<UserEntity> getList(UserDto dto);
}
