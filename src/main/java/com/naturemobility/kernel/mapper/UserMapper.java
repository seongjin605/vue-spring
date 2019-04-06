package com.naturemobility.kernel.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.naturemobility.kernel.entity.User;

import java.util.List;

@Repository
public interface UserMapper {


    User selectUserByUserId(@Param("userId") Integer userId);

    User selectUserByName(@Param("userName") String userName);

    List<User> selectAllUser();

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insertSelective(User record);

    int updateByPrimaryKeySelective(User record);



}