package com.gj.qing.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gj.qing.mode.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
