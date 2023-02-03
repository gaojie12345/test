package com.gj.qing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gj.qing.mode.dto.UserDto;
import com.gj.qing.mode.entity.UserEntity;

public interface UserSerivce extends IService<UserEntity> {


    void save(UserDto dto);

    void edit(UserDto dto);

    UserEntity detail(UserDto dto);

    void delete(UserDto dto);
}
