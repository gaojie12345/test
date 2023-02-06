package com.gj.qing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gj.qing.contants.Contants;
import com.gj.qing.dao.UserMapper;
import com.gj.qing.exception.OlsenException;
import com.gj.qing.exception.OlsenExceptionEnum;
import com.gj.qing.mode.dto.UserDto;
import com.gj.qing.mode.entity.UserEntity;
import com.gj.qing.service.UserSerivce;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
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
    public Long save(UserDto dto) {
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(dto, user);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setDelFlag(Contants.NO);
        userMapper.insert(user);
        return user.getId();
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
    public UserEntity detail(Long userId) {
        LambdaQueryWrapper<UserEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserEntity::getId, userId);
        wrapper.eq(UserEntity::getDelFlag, Contants.NO);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public void delete(UserDto dto) {
        Long id = dto.getId();
        UserEntity entity = userMapper.selectById(id);
        if (entity != null) {
            entity.setUpdateTime(new Date());
            entity.setDelFlag(Contants.YES);
            userMapper.updateById(entity);
        }
    }

    @Override
    public IPage<UserEntity> getList(UserDto dto) {
        LambdaQueryWrapper<UserEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(dto.getName()), UserEntity::getName, dto.getName());
        wrapper.eq(UserEntity::getDelFlag, Contants.NO);
        IPage<UserEntity> page = new Page<>(dto.getPageNo(), dto.getPageSize());
        return userMapper.selectPage(page, wrapper);
    }
}
