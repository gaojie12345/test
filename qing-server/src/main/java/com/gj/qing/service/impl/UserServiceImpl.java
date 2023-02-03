package com.gj.qing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gj.qing.dao.UserMapper;
import com.gj.qing.exception.OlsenException;
import com.gj.qing.exception.OlsenExceptionEnum;
import com.gj.qing.mode.dto.UserDto;
import com.gj.qing.mode.entity.UserEntity;
import com.gj.qing.service.UserSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Auther: Gaojie
 * @Date: 2023/2/3
 * @Desc:
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserSerivce {

    @Resource
    private UserMapper userMapper;

    @Override
    public void save(UserDto dto) {
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(dto, user);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setDelFlag(0);
        userMapper.insert(user);
    }

    @Override
    public void edit(UserDto dto) {
        Long id = dto.getId();
        UserEntity entity = userMapper.selectById(id);
        if (entity == null) {
            throw new OlsenException(OlsenExceptionEnum.DATA_NOT_EXIST, "该数据不存在！");
        }
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setAddress(dto.getAddress());
        entity.setUpdateTime(new Date());
        userMapper.updateById(entity);
    }

    @Override
    public UserEntity detail(UserDto dto) {
        LambdaQueryWrapper<UserEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserEntity::getId, dto.getId());
        wrapper.eq(UserEntity::getDelFlag, 0);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public void delete(UserDto dto) {
        Long id = dto.getId();
        UserEntity entity = userMapper.selectById(id);
        if (entity != null) {
            entity.setUpdateTime(new Date());
            entity.setDelFlag(1);
            userMapper.updateById(entity);
        }
    }
}
